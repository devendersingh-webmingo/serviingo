package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipContentRepo;


public class MembershipContentAdapter extends RecyclerView.Adapter<MembershipContentAdapter.myViewHolder> {

    MembershipContentRepo modelArrayList;
    Context context;
// private CheckBoxListener itemClickListenerr;

    /*  public CartAdapter(AddonseRepo modelArrayList, Context context, CheckBoxListener itemClickListenerr) {
          this.modelArrayList = modelArrayList;
          this.context = context;
          this.itemClickListenerr = itemClickListenerr;
      }
  */
    public MembershipContentAdapter(MembershipContentRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.membershipcontentadapter, parent, false);

        return new MembershipContentAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        holder.countTV.setText(modelArrayList.getData().get(position).getCount() + "+");

        holder.titleTV.setText(modelArrayList.getData().get(position).getTitle());
        if (modelArrayList.getData().get(position).getTitle().trim().equalsIgnoreCase("Active Members")) {

            holder.ivImages.setImageDrawable(context.getResources().getDrawable(R.drawable.friend));

        } else if (modelArrayList.getData().get(position).getTitle().equalsIgnoreCase("Exclusive Every Deals New")) {


            holder.ivImages.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_group));
        } else if (modelArrayList.getData().get(position).getTitle().equalsIgnoreCase("Published Research & Analysis")) {

            holder.ivImages.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_book));

        }




     /*   if (modelArrayList.getData().getAddonServices().get(position).getAfterDiscount()!=null)
        {
            holder.text.setText( " \u20B9 "+modelArrayList.getData().getAddonServices().get(position).getAfterDiscount());

        }else {
            holder.text.setText( " \u20B9 "+modelArrayList.getData().getAddonServices().get(position).getAmount());

        }

        holder.tvwallet.setText(modelArrayList.getData().getAddonServices().get(position).getName());
*/


    }

    @Override
    public int getItemCount() {
        return modelArrayList.getData().size();

    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView countTV, titleTV;
        ImageView ivImages;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            countTV = itemView.findViewById(R.id.countTV);
            titleTV = itemView.findViewById(R.id.titleTV);
            ivImages = itemView.findViewById(R.id.ivImages);
        }
    }
   /* public interface CheckBoxListener {

        void CheckedClick(String id, int position,Boolean bb);


    }*/
}
