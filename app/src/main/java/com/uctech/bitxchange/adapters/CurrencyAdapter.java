package com.uctech.bitxchange.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uctech.bitxchange.R;
import com.uctech.bitxchange.Interfaces.ItemClickListener;
import com.uctech.bitxchange.model.CoinResult;
import com.uctech.bitxchange.model.Currency;
import com.uctech.bitxchange.ui.activities.CoinExchangeActivity;

/**
 * Created by Uche on 10/23/2017.
 */
class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    ImageView mCountryFlagUrl;
    TextView mName;
    TextView mCode;
    TextView mExchangeRate;
    private ItemClickListener itemClickListener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.mCountryFlagUrl = (ImageView) itemView.findViewById(R.id.flag_icon);
        this.mName = (TextView) itemView.findViewById(R.id.country_code_name_label);
        this.mCode = (TextView) itemView.findViewById(R.id.country_code_label);
        this.mExchangeRate = (TextView) itemView.findViewById(R.id.country_exchange_label);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }
}

public class CurrencyAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private Currency[] mCurrencyList;
    private CoinResult mCoinResult;
    private LayoutInflater mLayoutInflater;
    private  String mTabTitle ;
    private static final String SELECTED_ITEM = "SELECTED_ITEM";
    private static final String SELECTED_ITEM_INDEX = "SELECTED_ITEM_INDEX";
    private static final String ALL_ITEMS = "ALL_ITEMS";
    private static final String TAB_TITLE = "TAB_TITLE";

    public CurrencyAdapter(Currency[] currencyList, Context context, String tabTitle) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mCurrencyList = currencyList;
        this.mTabTitle = tabTitle;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = mLayoutInflater.inflate(R.layout.currency_item, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final Context context = holder.mCountryFlagUrl.getContext();
        Currency currentItem = mCurrencyList[position];
        holder.mCountryFlagUrl.setImageResource( context.getResources().getIdentifier(currentItem.getFlag(),"drawable",context.getPackageName()));
        holder.mName.setText(currentItem.getName());
        holder.mCode.setText(currentItem.getCode());
        holder.mExchangeRate.setText(currentItem.getExchangeRate().toString());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {
                    Intent intent = new Intent(context, CoinExchangeActivity.class);
                    intent.putExtra(SELECTED_ITEM_INDEX, position);
                    intent.putExtra(SELECTED_ITEM, mCurrencyList[position]);
                    intent.putExtra(ALL_ITEMS, mCurrencyList);
                    intent.putExtra(TAB_TITLE, mTabTitle);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCurrencyList != null ? mCurrencyList.length : 0;
    }
}
