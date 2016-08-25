package com.example.hanaj.k_tour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.hanaj.k_tour.R;
import com.example.hanaj.k_tour.common.Network.Sample.NetworkTestActivity;

import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button networkTestBtn = (Button)findViewById(R.id.network_test_btn);
        ListView listView = (ListView) findViewById(R.id.listView);

        networkTestBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkTestActivity.class);
                startActivity(intent);
            }
        });
    }
}