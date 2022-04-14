package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.GetReferrals;
import com.squareup.picasso.Picasso;


public class ReferralUserAdapter extends RecyclerView.Adapter<ReferralUserAdapter.myViewHolder> {

    GetReferrals modelArrayList;
    Context context;
    //  private CheckBoxListener itemClickListenerr;

   /* public ReferralUserAdapter(GetReferrals modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }
*/
 /*  public ReferralUserAdapter(Context context) {
       this.context = context;
   }*/

    public ReferralUserAdapter(GetReferrals modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.referraluseradapter, parent, false);

        return new ReferralUserAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        if (modelArrayList.data.referralUsers.get(position).senderReferralStatus.equalsIgnoreCase("Success")) {


        } else {

            holder.StatusTV.setText("Pending");
            holder.StatusTV.setBackground(context.getResources().getDrawable(R.drawable.reddrawable));
            holder.StatusTV.setTextColor(context.getResources().getColor(R.color.white));

        }
        holder.nameTV.setText(modelArrayList.data.referralUsers.get(position).name);
        holder.rupessTv.setText("\u20B9" + modelArrayList.data.referralUsers.get(position).receiverAmount);

        holder.emailTv.setText(modelArrayList.data.referralUsers.get(position).email);
        holder.numberTV.setText(modelArrayList.data.referralUsers.get(position).mobileNumber);


    }

    @Override
    public int getItemCount() {
        return modelArrayList.data.referralUsers.size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView StatusTV, rupessTv, numberTV, emailTv, nameTV;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            StatusTV = itemView.findViewById(R.id.StatusTV);
            rupessTv = itemView.findViewById(R.id.rupessTv);
            numberTV = itemView.findViewById(R.id.numberTV);

            emailTv = itemView.findViewById(R.id.emailTv);
            nameTV = itemView.findViewById(R.id.nameTV);
        }
    }

  /*  public interface CheckBoxListener {

        void CheckedClick(String id, int position, Boolean bb);


    }*/
}
