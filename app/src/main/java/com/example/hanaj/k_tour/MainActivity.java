package com.example.hanaj.k_tour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.hanaj.k_tour.common.Culture.CultureActivity;
import com.example.hanaj.k_tour.common.Festival.FestivalActivity;
import com.example.hanaj.k_tour.common.House.HouseActivity;
import com.example.hanaj.k_tour.common.Restaurant.RestaurantActivity;
import com.example.hanaj.k_tour.common.Tour.TourActivity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        //tourMainBtn 클릭시 TourActivity
        Button tourMainBtn = (Button) findViewById(R.id.tourMainBtn);
        tourMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TourActivity.class);
                startActivity(intent);
            }
        });

        //houseMainBtn 클릭시 HouseActivity
        Button houseMainBtn = (Button) findViewById(R.id.houseMainBtn);
        houseMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HouseActivity.class);
                startActivity(intent);
            }
        });

        //festivalMainBtn 클릭시 FestivalActivity
        Button festivalMainBtn = (Button) findViewById(R.id.festivalMainBtn);
        festivalMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FestivalActivity.class);
                startActivity(intent);
            }
        });

        //cultureMainBtn 클릭시 CultureActivity
        Button cultureMainBtn = (Button) findViewById(R.id.cultureMainBtn);
        cultureMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CultureActivity.class);
                startActivity(intent);
            }
        });

        //restaurantMainBtn 클릭시 RestaurantActivity
        Button restaurantMainBtn = (Button) findViewById(R.id.restaurantMainBtn);
        restaurantMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });
    }
}