package com.example.android.worldtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.worldtourguide.france.CannesFranceActivity;
import com.example.android.worldtourguide.france.DisneyLandFranceActivity;
import com.example.android.worldtourguide.france.EiffelFranceActivity;
import com.example.android.worldtourguide.france.LouvreFranceActivity;

import java.util.ArrayList;

public class FranceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);

        // Create an ArrayList of TourismCountry objects
        ArrayList<TourismCountry> tourisminCountry = new ArrayList<>();
        tourisminCountry.add(new TourismCountry(getString(R.string.title_eiffel), getString(R.string.sub_title_eiffel), R.drawable.eiffel));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_disney), getString(R.string.sub_title_disney), R.drawable.disney));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_cannes), getString(R.string.sub_title_cannes), R.drawable.cannes));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_louvre), getString(R.string.sub_title_louvre), R.drawable.louvre));

        // Create an {@link TourismCountryAdapter}, whose data source is a list of
        // {@link TourismCountry}s. The adapter knows how to create list item views for each item
        // in the list.
        TourismCountryAdapter tourismCountryAdapter = new TourismCountryAdapter(this, tourisminCountry);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = findViewById(R.id.listview_places);
        listView.setAdapter(tourismCountryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent tajmahal = new Intent(FranceActivity.this, EiffelFranceActivity.class);
                        listView.getContext().startActivity(tajmahal);
                        break;
                    case 1:
                        Intent hillstation = new Intent(FranceActivity.this, DisneyLandFranceActivity.class);
                        listView.getContext().startActivity(hillstation);
                        break;
                    case 2:
                        Intent Dudhsagar = new Intent(FranceActivity.this, CannesFranceActivity.class);
                        listView.getContext().startActivity(Dudhsagar);
                        break;
                    case 3:
                        Intent varanasi = new Intent(FranceActivity.this, LouvreFranceActivity.class);
                        listView.getContext().startActivity(varanasi);
                        break;
                }

            }

        });

    }
}