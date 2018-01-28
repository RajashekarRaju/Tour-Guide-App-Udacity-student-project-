package com.example.android.worldtourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourismCountryAdapter extends ArrayAdapter<TourismCountry> {

    TourismCountryAdapter(Activity context, ArrayList<TourismCountry> tourisminIndia) {
        super(context, 0, tourisminIndia);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TourismCountry currentTourismCountry = getItem(position);

        TextView placenameTextView = listItemView.findViewById(R.id.place_name);
        assert currentTourismCountry != null;
        placenameTextView.setText(currentTourismCountry.getPlaceName());

        TextView citynameTextView = listItemView.findViewById(R.id.city_name);
        citynameTextView.setText(currentTourismCountry.getCityName());

        ImageView iconView = listItemView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(currentTourismCountry.getImageResourceId());

        // Return the whole list item layout
        return listItemView;
    }

}