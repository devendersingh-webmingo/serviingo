package com.serviingo.serviingo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.serviingo.serviingo.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    TextView tv_Dashboard, tv_myBooking, tv_myProfile, tv_myWallet, tv_changePassword, tv_myReviews, tv_myAddressbook, tv_mySupport, tv_referralDashboard;
    RelativeLayout ll_dropdown;
    LinearLayoutManager linearLayoutManager;
    DashboardFragment.DashboardAdapter dashboardAdapter;
    ImageView iv_arrow;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        setui(view);


        return view;


    }

    private void setui(View view) {
        ll_dropdown = view.findViewById(R.id.ll_dropdown);
        recyclerView = view.findViewById(R.id.recyclerView);
        tv_Dashboard = view.findViewById(R.id.tv_Dashboard);
        iv_arrow=view.findViewById(R.id.iv_arrow);


        tv_myBooking = view.findViewById(R.id.tv_myBooking);
        tv_myProfile = view.findViewById(R.id.tv_myProfile);
        tv_myWallet = view.findViewById(R.id.tv_myWallet);
        tv_changePassword = view.findViewById(R.id.tv_changePassword);
        tv_myReviews = view.findViewById(R.id.tv_myReviews);
        tv_myAddressbook = view.findViewById(R.id.tv_myAddressbook);
        tv_mySupport = view.findViewById(R.id.tv_mySupport);
        tv_referralDashboard = view.findViewById(R.id.tv_referralDashboard);

        setOnClickListener();


        dashboardAdapter = new DashboardFragment.DashboardAdapter();
        recyclerView.setAdapter(dashboardAdapter);
        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        iv_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if (ll_dropdown.getVisibility()==view.VISIBLE)
                 {
                     ll_dropdown.setVisibility(View.GONE);
                 }else {
                     ll_dropdown.setVisibility(View.VISIBLE);

                 }
                /*} else {
                    if (scrollView.getVisibility() == View.VISIBLE) {

                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                }*/

            }
        });

    }

    private class DashboardAdapter extends RecyclerView.Adapter<DashboardFragment.DashboardAdapter.WalletHolder> {
        // ArrayList<HashMap<String, String>> data = new ArrayList();
        /*  public CategoryAdapter(ArrayList<HashMap<String, String>> programlist ) {
              this.data = programlist;
          }
  */
        @Override
        public DashboardFragment.DashboardAdapter.WalletHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.dashboard_items, parent, false);
            return new DashboardFragment.DashboardAdapter.WalletHolder(view);
        }

        @Override
        public int getItemCount() {
            return 2;
        }

        @Override
        public void onBindViewHolder(final DashboardFragment.DashboardAdapter.WalletHolder holder, final int position) {

        }


        public class WalletHolder extends RecyclerView.ViewHolder {
            TextView tvCategory;
            ImageView ivImages;

            public WalletHolder(View itemView) {
                super(itemView);

                //  ivImages = itemView.findViewById(R.id.ivImages);
            }

        }
    }

    private void setOnClickListener() {
        tv_Dashboard.setOnClickListener(this);
        tv_myBooking.setOnClickListener(this);

        tv_myProfile.setOnClickListener(this);
        tv_myWallet.setOnClickListener(this);
        tv_changePassword.setOnClickListener(this);
        tv_myReviews.setOnClickListener(this);
        tv_myAddressbook.setOnClickListener(this);
        tv_mySupport.setOnClickListener(this);
        tv_referralDashboard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        switch (v.getId()) {

           /* case R.id.ivNav:
                if (AppSettings.getString(AppSettings.id).isEmpty()) {
                    if (scrollView.getVisibility() == View.VISIBLE) {
                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                } else {
                    if (scrollView.getVisibility() == View.VISIBLE) {

                        AppUtils.collapse(scrollView);
                        break;
                    }
                    AppUtils.expand(scrollView);
                }

                break;*/


            case R.id.tv_Dashboard:
               // onBackPressed();



                Fragment homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragment_Container,homeFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myProfile:
                // onBackPressed();


                Fragment profileFragment = new ProfileFragment();
                fragmentTransaction.replace(R.id.fragment_Container,profileFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myBooking:
                // onBackPressed();
               /* Fragment profileFragment = new ProfileFragment();
                fragmentTransaction.replace(R.id.fragment_Container,profileFragment);
                fragmentTransaction.commit();*/
                Fragment RecentBookingFragment = new RecentBookingFragment();
                fragmentTransaction.replace(R.id.fragment_Container,RecentBookingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

                break;
            case R.id.tv_myWallet:
                // onBackPressed();
                Fragment myWalletFragment = new MyWalletFragment();
                fragmentTransaction.replace(R.id.fragment_Container,myWalletFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_changePassword:
                // onBackPressed();
                Fragment changePasswordFragment = new ChangePasswordFragment();
                fragmentTransaction.replace(R.id.fragment_Container,changePasswordFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myReviews:
                // onBackPressed();

                Fragment reviewRatingFragment = new ReviewRatingFragment();
                fragmentTransaction.replace(R.id.fragment_Container,reviewRatingFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_myAddressbook:
                // onBackPressed();

                Fragment addressFragment = new AddressFragment();
                fragmentTransaction.replace(R.id.fragment_Container,addressFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_mySupport:
                // onBackPressed();


                Fragment tabs = new SupportTicketsFragment();
                fragmentTransaction.replace(R.id.fragment_Container,tabs);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;
            case R.id.tv_referralDashboard:
                // onBackPressed();

                Fragment ReferralUser = new ReferralUserFragment();
                fragmentTransaction.replace(R.id.fragment_Container,ReferralUser);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
                break;



        }
    }
}