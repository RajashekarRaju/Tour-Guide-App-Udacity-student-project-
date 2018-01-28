package com.example.android.worldtourguide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private Context mContext;
    private List<Country> countryList;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, count;
        ImageView thumbnail;
        View view;


        MyViewHolder(View v) {
            super(v);
            view = v;
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.count);
            thumbnail = view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (getAdapterPosition()) {
                        case 0:
                            Intent india = new Intent(view.getContext(), IndiaActivity.class);
                            view.getContext().startActivity(india);
                            break;
                        case 1:
                            Intent italy = new Intent(view.getContext(), ItalyActivity.class);
                            view.getContext().startActivity(italy);
                            break;
                        case 2:
                            Intent china = new Intent(view.getContext(), ChinaActivity.class);
                            view.getContext().startActivity(china);
                            break;
                        case 3:
                            Intent USA = new Intent(view.getContext(), USAActivity.class);
                            view.getContext().startActivity(USA);
                            break;
                        case 4:
                            Intent spain = new Intent(view.getContext(), SpainActivity.class);
                            view.getContext().startActivity(spain);
                            break;
                        case 5:
                            Intent france = new Intent(view.getContext(), FranceActivity.class);
                            view.getContext().startActivity(france);
                            break;
                    }
                }
            });
        }
    }

    CountryAdapter(Context mContext, List<Country> countryList) {
        this.mContext = mContext;
        this.countryList = countryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.title.setText(country.getName());
        holder.count.setText(mContext.getString(R.string.ranks) + country.getWorldRankings() + mContext.getString(R.string.world));

        // loading country cover using Glide library
        Glide.with(mContext).load(country.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}