package com.example.android.worldtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.worldtourguide.spain.AlhambraSpainActivity;
import com.example.android.worldtourguide.spain.IbizaSpainActivity;
import com.example.android.worldtourguide.spain.MajorcaSpainActivity;
import com.example.android.worldtourguide.spain.SagradaSpainActivity;

import java.util.ArrayList;

public class SpainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);

        // Create an ArrayList of TourismCountry objects
        ArrayList<TourismCountry> tourisminCountry = new ArrayList<>();
        tourisminCountry.add(new TourismCountry(getString(R.string.title_sagrada), getString(R.string.sub_title_sagrada), R.drawable.sagrada));
        tourisminCountry.add(new TourismCountry(getString(R.string.majorka), getString(R.string.sub_title_majorka), R.drawable.majorca));
        tourisminCountry.add(new TourismCountry(getString(R.string.alhambra), getString(R.string.sub_title_alhambra), R.drawable.alhambra));
        tourisminCountry.add(new TourismCountry(getString(R.string.ibiza), getString(R.string.sub_title_ibiza), R.drawable.ibiza));

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
                        Intent sagrada = new Intent(SpainActivity.this, SagradaSpainActivity.class);
                        listView.getContext().startActivity(sagrada);
                        break;
                    case 1:
                        Intent majorca = new Intent(SpainActivity.this, MajorcaSpainActivity.class);
                        listView.getContext().startActivity(majorca);
                        break;
                    case 2:
                        Intent alhambra = new Intent(SpainActivity.this, AlhambraSpainActivity.class);
                        listView.getContext().startActivity(alhambra);
                        break;
                    case 3:
                        Intent ibiza = new Intent(SpainActivity.this, IbizaSpainActivity.class);
                        listView.getContext().startActivity(ibiza);
                        break;
                }
            }

        });

    }
}
