package com.example.dogeclicker.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.dogeclicker.R;


public class MainActivity extends AppCompatActivity {
    static float masterSum =0;
    float coinSum;
    static int cursorLvl = 0;
    static int ramLvl = 0;
    static int cpuLvl = 0;
    boolean cursorBought = false;
    boolean cpuBought = false;
    boolean ramBought = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        coinSum = masterSum;
    }

    public void launchActivity(View v){
        setContentView(R.layout.activity_main);

    }
    public void backButton(View v){
        setContentView(R.layout.activity_main);
    }


    public void onUpgradeClick(View v){
        setContentView(R.layout.perm_upgrade_page);

    }

    public void onDogeCoinClick(View v){
        ImageButton dogeBtn = findViewById(R.id.dogeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        dogeBtn.startAnimation(myAnimation);


    }

    public boolean onCursorClick(View v){

        int cost = 5;
        float cursorMultiplier = 0.5f;
        if(masterSum>cost){
            cursorLvl+=1;
            return cursorBought = true;
        }
        else{
            return cursorBought = false;
        }
    }

    public boolean onCPUClick(View v){
        int cost = 100;
        float cpuMultiplier = 2f;
        if(masterSum>cost){
            cpuLvl+=1;
            return  cpuBought = true;
        }
        else{
            return cpuBought = false;
        }
    }
    public boolean onRAMClick(View v){
        int cost = 5;
        float cursorMultiplier = 0.5f;
        if(masterSum>cost){
            ramLvl+=1;
            return true;
        }
        else{
            return false;
        }
    }
}
