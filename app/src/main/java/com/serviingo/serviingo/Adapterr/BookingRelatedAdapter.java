package com.serviingo.serviingo.Adapterr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.GetOrderNumbersRepo;
import com.serviingo.serviingo.modelrepo.Responsee.GetTransactionRepo;

public class BookingRelatedAdapter extends BaseAdapter {
    Context context;
    GetOrderNumbersRepo arrayListt;
    LayoutInflater inflter;

    public BookingRelatedAdapter(Context context, GetOrderNumbersRepo arrayList) {
        this.context = context;
        this.arrayListt = arrayList;
        inflter = (LayoutInflater.from(context));

    }




    @Override
    public int getCount() {
        return arrayListt.data.bookingNumbers.size();
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
        coinNames.setText(arrayListt.data.bookingNumbers.get(position).orderNumber);

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

