package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Membership.MembershipPlansRepo;


public class MembershipPlansAdapter extends RecyclerView.Adapter<MembershipPlansAdapter.myViewHolder> {

    MembershipPlansRepo modelArrayList;
    Context context;
    private MembershipPlansclick itemClickListenerr;

    public MembershipPlansAdapter(MembershipPlansRepo modelArrayList, Context context, MembershipPlansclick itemClickListenerr) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        this.itemClickListenerr = itemClickListenerr;
    }

  /*  public MembershipPlansAdapter(MembershipPlansRepo modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }*/

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.membershipplansadapter, parent, false);

        return new MembershipPlansAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tv_name.setText(modelArrayList.getData().get(position).getName());


        holder.crossreupess.setText(modelArrayList.getData().get(position).getCost());
        holder.price.setText("\u20B9" + modelArrayList.getData().get(position).getFinalCost() + "/-");
        holder.joinnowTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.CheckedClick(modelArrayList, position);
            }
        });

        int days = Integer.valueOf(modelArrayList.getData().get(position).getUsedInMonth()) * 28;
        holder.daysTV.setText("For " + modelArrayList.getData().get(position).getValidity() + "  Months");

      /*  holder.countTV.setText(modelArrayList.getData().get(position).getCount() + "+");

        holder.titleTV.setText(modelArrayList.getData().get(position).getTitle());
        if (modelArrayList.getData().get(position).getTitle().trim().equalsIgnoreCase("Active Members")) {

            holder.ivImages.setImageDrawable(context.getResources().getDrawable(R.drawable.friend));

        } else if (modelArrayList.getData().get(position).getTitle().equalsIgnoreCase("Exclusive Every Deals New")) {


            holder.ivImages.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_group));
        } else if (modelArrayList.getData().get(position).getTitle().equalsIgnoreCase("Published Research & Analysis")) {

            holder.ivImages.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_book));

        }
*/



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
        TextView tv_name, crossreupess, daysTV, joinnowTv, price;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);

            price = itemView.findViewById(R.id.price);
            crossreupess = itemView.findViewById(R.id.crossreupess);
            daysTV = itemView.findViewById(R.id.daysTV);
            joinnowTv = itemView.findViewById(R.id.joinnowTv);
        }
    }

    public interface MembershipPlansclick {

        void CheckedClick(MembershipPlansRepo repo, int position);


    }
}
