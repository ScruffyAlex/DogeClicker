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


    public void onUpgradeClick(View v){
        setContentView(R.layout.perm_upgrade_page);

    }

    public void onDogeCoinClick(View v){
        ImageButton dogeBtn = findViewById(R.id.dogeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        dogeBtn.startAnimation(myAnimation);


    }

    public void onCursorClick(View v){
        Button cursorBtn = findViewById(R.id.cursorBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cursorBtn.startAnimation(myAnimation);

    }

    public void onCPUClick(View v){
        Button cpuBtn = findViewById(R.id.cpuBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cpuBtn.startAnimation(myAnimation);

    }
    public void onRAMClick(View v){
        Button ramBtn = findViewById(R.id.ramBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        ramBtn.startAnimation(myAnimation);

    }
}
