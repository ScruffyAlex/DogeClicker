package com.example.dogeclicker.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dogeclicker.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

    }

    public void launchActivity(View v){
        setContentView(R.layout.activity_main);

    }
    public void backButton(View v){
        setContentView(R.layout.activity_main);
    }


    public void onUpgradeCilck(View v){
        setContentView(R.layout.perm_upgrade_page);

    }

    public void onDogeCoinClick(View v){

    }

    public void onCursorClick(View v){


    }

    public void onCPUClick(View v){

    }
    public void onRAMClick(View v){

    }
}
