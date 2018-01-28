package com.example.android.worldtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.worldtourguide.india.DudhsagarIndiaActivity;
import com.example.android.worldtourguide.india.HillstationIndiaActivity;
import com.example.android.worldtourguide.india.TajMahalIndiaActivity;
import com.example.android.worldtourguide.india.VaranasiIndiaActivity;

import java.util.ArrayList;


public class IndiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);

        // Create an ArrayList of TourismCountry objects
        ArrayList<TourismCountry> tourisminCountry = new ArrayList<>();
        tourisminCountry.add(new TourismCountry(getString(R.string.title_taj), getString(R.string.sub_title_taj), R.drawable.taj_mahal));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_hill), getString(R.string.sub_title_hill), R.drawable.hillstations));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_falls), getString(R.string.sub_title_falls), R.drawable.dudhsagar_falls));
        tourisminCountry.add(new TourismCountry(getString(R.string.ghats), getString(R.string.sub_title_ghats), R.drawable.varanasi));

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
                        Intent tajmahal = new Intent(IndiaActivity.this, TajMahalIndiaActivity.class);
                        listView.getContext().startActivity(tajmahal);
                        break;
                    case 1:
                        Intent hillstation = new Intent(IndiaActivity.this, HillstationIndiaActivity.class);
                        listView.getContext().startActivity(hillstation);
                        break;
                    case 2:
                        Intent Dudhsagar = new Intent(IndiaActivity.this, DudhsagarIndiaActivity.class);
                        listView.getContext().startActivity(Dudhsagar);
                        break;
                    case 3:
                        Intent varanasi = new Intent(IndiaActivity.this, VaranasiIndiaActivity.class);
                        listView.getContext().startActivity(varanasi);
                        break;
                }

            }

        });

    }
}