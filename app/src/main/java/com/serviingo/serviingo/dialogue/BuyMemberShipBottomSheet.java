package com.serviingo.serviingo.dialogue;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.irozon.sneaker.Sneaker;
import com.rjesture.startupkit.AppTools;
import com.serviingo.serviingo.Activity.HomeActivity;
import com.serviingo.serviingo.Adapterr.MembershipContentAdapter;
import com.serviingo.serviingo.Adapterr.MembershipPlansAdapter;
import com.serviingo.serviingo.Fragments.AppliencesCareServicesFragment;
import com.serviingo.serviingo.Fragments.HomeFragment;
import com.serviingo.serviingo.Fragments.MyMemberShipFragment;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.ViewPresenter.MembershipPresenter;
import com.serviingo.serviingo.ViewPresenter.MyMembershipPresenter;
import com.serviingo.serviingo.ViewPresenter.UserLoginPresenter;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.BuyMembershipRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipContentRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipPlansRepo;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MyMembershipRepo;
import com.serviingo.serviingo.storage.SharedPrefManager;
import com.serviingo.serviingo.utils.AppUtils;

import static com.serviingo.serviingo.R.drawable.globalloader;

public class BuyMemberShipBottomSheet extends BottomSheetDialogFragment implements MembershipPresenter.MembershipView, MembershipPlansAdapter.MembershipPlansclick {


    BottomSheetDialog bottomSheet;
    RecyclerView recyclerViewJoin, recyclerViewPlan;
    LinearLayoutManager linearLayoutManager, linearLayoutManager2;
    MembershipPresenter membershipPresenter;
    TextView exit;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        bottomSheet = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);


        View view = View.inflate(getContext(), R.layout.buymembershipbottomsheet, null);
        recyclerViewJoin = view.findViewById(R.id.recyclerViewJoin);
        recyclerViewPlan = view.findViewById(R.id.recyclerViewPlan);
        exit = view.findViewById(R.id.exit);
        linearLayoutManager = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));

        recyclerViewJoin.setLayoutManager(linearLayoutManager);
        recyclerViewJoin.setHasFixedSize(true);
        linearLayoutManager2 = (new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, true));


        recyclerViewPlan.setLayoutManager(linearLayoutManager2);
        recyclerViewPlan.setHasFixedSize(true);


        membershipPresenter = new MembershipPresenter(this);
        membershipPresenter.MembershipContent(getContext());
        membershipPresenter.MembershipPlan(getContext());
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet.dismiss();
            }
        });

        bottomSheet.setContentView(view);
        bottomSheet.setCancelable(true);
        bottomSheet.setCanceledOnTouchOutside(false);


        return bottomSheet;

    }

    @Override
    public void CheckedClick(MembershipPlansRepo repo, int position) {


        AlertDialogBox(repo.getData().get(position).getId(), repo.getData().get(position).getFinalCost(),repo.getData().get(position).getName());

    }

    @Override
    public void onMembershipError(String message) {
        Sneaker.with(getActivity())
                .setTitle(message)
                .setMessage("")
                .sneakError();
        Toast.makeText(getActivity(), message + "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void GetMembershipSuccess(MembershipContentRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            MembershipContentAdapter membershipContentAdapter = new MembershipContentAdapter(response, getContext());
            recyclerViewJoin.setAdapter(membershipContentAdapter);

        }
    }

    @Override
    public void GetMembershipPlanSuccess(MembershipPlansRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {


            MembershipPlansAdapter membershipContentAdapter = new MembershipPlansAdapter(response, getContext(), this);
            recyclerViewPlan.setAdapter(membershipContentAdapter);

        }
    }

    @Override
    public void BuyMembershipPlanSuccess(BuyMembershipRepo response, String message) {
        if (message.equalsIgnoreCase("ok")) {

            Sneaker.with(getActivity())
                    .setTitle(response.getMessage())
                    .setMessage("")
                    .sneakSuccess();
            // Toast.makeText(getActivity(), response.getMessage()+"", Toast.LENGTH_LONG).show();

         /*   SharedPrefManager.getInstance(getActivity())
                    .GetMemberShidata(String.valueOf(response.getData().getId()), String.valueOf(response.getData().getCost()));
*/
            bottomSheet.dismiss();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment appliencesCareServicesFragment = new AppliencesCareServicesFragment();

           /* Bundle args = new Bundle();
            args.putString("membership_id", String.valueOf(response.getData().getId()));
            args.putString("membership_cost", String.valueOf(response.getData().getCost()));

            appliencesCareServicesFragment.setArguments(args);
         */
            fragmentTransaction.replace(R.id.fragment_Container, appliencesCareServicesFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }

    @Override
    public void GetMembershipSuccess(MyMembershipRepo response, String message) {

    }

    @Override
    public void onMembershipFailure(Throwable t) {
        Sneaker.with(getActivity())
                .setTitle(t.getLocalizedMessage())
                .setMessage("")
                .sneakError();
        Toast.makeText(getActivity(), t.getLocalizedMessage() + "", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showHideProgress(boolean isShow) {
        if (isShow) {
            AppTools.showGifDialog(getActivity(), globalloader);

        } else {
            AppTools.hideGifDialog();

        }
    }

    public void AlertDialogBox(String idd, String amount,String name) {

        //Logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        // set title
        alertDialogBuilder.setTitle("Are you sure?");

        // set dialog message
        //  alertDialogBuilder.setIcon(R.mipmap.logo);
        alertDialogBuilder
                .setMessage("Add This Membership Plan")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  membershipPresenter.BuyMembershipPlan(getContext(), idd);
                        SharedPrefManager.getInstance(getActivity())
                                .GetMemberShidata(idd, amount,name);


                        bottomSheet.dismiss();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        Fragment appliencesCareServicesFragment = new AppliencesCareServicesFragment();
                        fragmentTransaction.replace(R.id.fragment_Container, appliencesCareServicesFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}



