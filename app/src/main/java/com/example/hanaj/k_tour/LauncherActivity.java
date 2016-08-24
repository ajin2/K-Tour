package com.example.hanaj.k_tour;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hanaj.k_tour.common.Network.Sample.NetworkTestActivity;

import java.util.Random;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.launcher_layout);

        // 핸들러를 사용한 일정 시간이 흐른 후 화면 전환 = java 의 timer 기능.
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LauncherActivity.this, MainActivity.class);
                // ~~.this가 현재 activity,
                // ~~.class가 이동할 activity
                startActivity(i);
                finish();
            }
        }, 500); // 0.5초

        Button networkTestBtn = (Button)findViewById(R.id.network_test_btn);
        networkTestBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity.this, NetworkTestActivity.class);
                startActivity(intent);
            }
        });

       // LinearLayout background;

        int img[] = {
                R.drawable.launcher_androids, R.drawable.launcher_avril_lavigne, R.drawable.launcher_twice,
                R.drawable.launcher_kaka
        };

        LinearLayout background = (LinearLayout)findViewById(R.id.launcherlayout);
        Random random = new Random();
        Integer num = random.nextInt(img.length);
        background.setBackgroundResource(img[num]);
    }
}
