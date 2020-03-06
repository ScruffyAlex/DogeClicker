package com.example.dogeclicker.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dogeclicker.R;
import com.example.dogeclicker.models.Upgrade;
import com.example.dogeclicker.models.UpgradeType;


public class MainActivity extends AppCompatActivity {
    static float masterSum =0;
    float coinSum = 0;
    static int cursorLvl = 0;
    static int ramLvl = 0;
    static int cpuLvl = 0;
    static int skillPointSum = 20;

    public int cursorCost = 15;
    public int cpuCost = 150;
    public int ramCost = 1500;


    boolean cursorBought = false;
    boolean cpuBought = false;
    boolean ramBought = false;

    TextView skillPointTxt;
    TextView cursorLvlText;
    TextView ramLvlText;
    TextView cpuLvlText;
    TextView coinTotal;
    TextView multiplyerTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
    }

    public void launchActivity(View v){
        setContentView(R.layout.activity_main);
       overridePendingTransition(R.anim.slideinright,R.anim.slideinleft);


    }
    public void backButton(View v){
        setContentView(R.layout.activity_main);
        generateGameInfo();
    }


    public void onUpgradeClick(View v){
        Button upgrade = findViewById(R.id.permUpgradeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        upgrade.startAnimation(myAnimation);
        setContentView(R.layout.perm_upgrade_page);
        generateUpdateInfo();
    }

    public void generateUpdateInfo(){
        skillPointTxt = findViewById(R.id.skillPointTxt);
        skillPointTxt.setText("Skill Points: "+MainActivity.skillPointSum);
    }


    public void generateGameInfo(){
        cursorLvlText = findViewById(R.id.cursorLvl);
        cpuLvlText = findViewById(R.id.cpuLvl);
        ramLvlText = findViewById(R.id.ramLvl);


        cursorLvlText.setText("Level: "+cursorLvl);
        cpuLvlText.setText("Level: "+cpuLvl);
        ramLvlText.setText("Level: "+ramLvl);
    }


    public Upgrade addUpgrade() {
            if (cursorBought) {
                Upgrade cursorUpgrade = new Upgrade("Cursor", UpgradeType.BASIC, 0.5 * cursorLvl);
                return cursorUpgrade;
            } else if (cpuBought) {
                Upgrade cpuUpgrade = new Upgrade("CPU", UpgradeType.BASIC, 2 * cpuLvl);
                return cpuUpgrade;
            } else if (ramBought) {
                Upgrade ramUpgrade = new Upgrade("RAM", UpgradeType.BASIC, 3 * ramLvl);
                return ramUpgrade;
            }
            else{
                return null;
        }
    }

    public void onDogeCoinClick(View v){
        ImageButton dogeBtn = findViewById(R.id.dogeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        dogeBtn.startAnimation(myAnimation);
        masterSum = masterSum + (1*masterSum);
    }

    public boolean onCursorClick(View v){
        TextView cursorLvlText = findViewById(R.id.cursorLvl);
        Button cursorBtn = findViewById(R.id.cursorBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cursorBtn.startAnimation(myAnimation);
        int cost = 5;
        //float cursorMultiplier = 0.5f;
        //if(masterSum>cost){
            cursorLvl+=1;
            cursorLvlText.setText("Level: "+cursorLvl);
            return cursorBought = true;
        //}
        //else{
            //return cursorBought = false;
        //}

    }

    public boolean onCPUClick(View v){
        TextView cpuLvlText = findViewById(R.id.cpuLvl);
        Button cpuBtn = findViewById(R.id.cpuBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cpuBtn.startAnimation(myAnimation);
        int cost = 100;
        //float cpuMultiplier = 2f;
        //if(masterSum>cost){
            cpuLvl+=1;
            cpuLvlText.setText("Level:"+cpuLvl);
            return  cpuBought = true;
        //}
        //else{
        //    return cpuBought = false;
        //}

    }
    public boolean onRAMClick(View v) {
        TextView ramLvlText = findViewById(R.id.ramLvl);
        Button ramBtn = findViewById(R.id.ramBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        ramBtn.startAnimation(myAnimation);
        int cost = 5;
        //float ramMultiplier = 3f;
        //if (masterSum > cost) {
            ramLvl += 1;
            ramLvlText.setText("Level:"+ramLvl);
            return true;
        //} else {
            //uwu
        //    return false;
        //}

    }
}
