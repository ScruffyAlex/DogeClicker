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
        int cursorSum = 0;
        int cost = 5;
        float cursorMultiplier = 0.5f;
        if(masterSum>cost){
            cursorSum++;
            return true;
            /*TODO Change text for the cursor sum. Also create calculation that increases the cost
            according to how many updates were already bought.
             */
        }
        else{
            return false;
        }


    }

    public void onCPUClick(View v){
            /*TODO Change text for the CPU sum. Also create calculation that increases the cost
            according to how many updates were already bought.
             */
    }
    public void onRAMClick(View v){
        /*TODO Change text for the RAM sum. Also create calculation that increases the cost
            according to how many updates were already bought.
             */
    }
}
