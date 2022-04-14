package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.GetTransactionRepo;
import com.serviingo.serviingo.modelrepo.Responsee.MyAddressRepoo;

public class TransationAdapter extends BaseAdapter {
    Context context;
    GetTransactionRepo arrayListt;
    LayoutInflater inflter;

    public TransationAdapter(Context context, GetTransactionRepo arrayList) {
        this.context = context;
        this.arrayListt = arrayList;
        inflter = (LayoutInflater.from(context));

    }




    @Override
    public int getCount() {
        return arrayListt.data.transaction.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.state_layout, null);
        TextView coinNames = (TextView) view.findViewById(R.id.coinName);
        //TextView coinSymbol = (TextView) view.findViewById(R.id.coinsymbols);

        // coinImages.setImageResource(coinImage[i]);
        coinNames.setText(arrayListt.data.transaction.get(position).transactionId);

        /*if (arrayListt.get(position).getId().equalsIgnoreCase("00"))
        {
            coinNames.setText(arrayListt.get(position).getName());
            coinNames.setTextColor(Color.parseColor("#757575"));

        }
        else {
            coinNames.setText(arrayListt.get(position).getName());

        }
*/



        return view;
    }
}

