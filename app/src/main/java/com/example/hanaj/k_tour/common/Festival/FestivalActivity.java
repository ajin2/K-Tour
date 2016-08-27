package com.example.hanaj.k_tour.common.Festival;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hanaj.k_tour.R;

/**
 * Created by hanaj on 2016-08-24.
 */
public class FestivalActivity extends AppCompatActivity {

    //tourMainBtn 클릭시 tour_main_layout
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.festival_main_layout);
    }
}
