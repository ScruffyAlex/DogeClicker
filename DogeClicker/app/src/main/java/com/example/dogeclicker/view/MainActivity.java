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

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static float masterSum =0;
    static float masterMult = 1;
    static int cursorLvl = 0;
    static int ramLvl = 0;
    static int cpuLvl = 0;
    static int skillPointSum = 20;

    ArrayList<Upgrade> upgradeList = new ArrayList<>();

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
    TextView masterSumTxt;
    TextView masterMultTxt;

    TextView ramCostTxt;
    TextView cpuCostTxt;
    TextView cursorCostTxt;


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
        masterSumTxt = findViewById(R.id.masterSumTxt);
        masterMultTxt = findViewById(R.id.masterMultiplierTxt);

        ramCostTxt = findViewById(R.id.ramCost);
        cpuCostTxt = findViewById(R.id.cpuCost);
        cursorCostTxt = findViewById(R.id.cursorCost);

        cursorLvlText.setText("Level: "+cursorLvl);
        cpuLvlText.setText("Level: "+cpuLvl);
        ramLvlText.setText("Level: "+ramLvl);
        masterSumTxt.setText("Coins:"+masterSum);
        masterMultTxt.setText("Multiplier: "+masterMult);

        ramCostTxt.setText("Cost: "+ramCost);
        cpuCostTxt.setText("Cost: "+cpuCost);
        cursorCostTxt.setText("Cost: "+cursorCost);

    }

    public void applyUpgrades(){
        for(int i=0;i<upgradeList.size();i++){
            masterMult += upgradeList.get(i).getMultiplier();
        }
    }


    public Upgrade addUpgrade() {
            if (cursorBought) {
                Upgrade cursorUpgrade = new Upgrade("Cursor", UpgradeType.BASIC, 0.1 * cursorLvl);
                return cursorUpgrade;
            } else if (cpuBought) {
                Upgrade cpuUpgrade = new Upgrade("CPU", UpgradeType.BASIC, 0.5 * cpuLvl);
                return cpuUpgrade;
            } else if (ramBought) {
                Upgrade ramUpgrade = new Upgrade("RAM", UpgradeType.BASIC, 2 * ramLvl);
                return ramUpgrade;
            }
            else{
                return null;
        }
    }

    public void onDogeCoinClick(View v){
        ImageButton dogeBtn = findViewById(R.id.dogeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        masterSumTxt = findViewById(R.id.masterSumTxt);
        masterMultTxt = findViewById(R.id.masterMultiplierTxt);
        dogeBtn.startAnimation(myAnimation);

        if(upgradeList.isEmpty()){
            masterSum = masterSum + (1*masterMult);
        }
        else{
         applyUpgrades();
         masterSum = masterSum+(1*masterMult);
        }

        masterSumTxt.setText("Coins: "+masterSum);
        masterMultTxt.setText("Multiplier: "+masterMult);
    }

    public boolean onCursorClick(View v){
        TextView cursorLvlText = findViewById(R.id.cursorLvl);
        Button cursorBtn = findViewById(R.id.cursorBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cursorBtn.startAnimation(myAnimation);
        int cost = 5;
        if(masterSum>cost){
            cursorLvl+=1;
            cursorLvlText.setText("Level: "+cursorLvl);
            updateCoinsSum(masterSum,cursorCost);
            cursorBought = true;
            cpuBought = false;
            ramBought = false;
            upgradeList.add(addUpgrade());
            return cursorBought;
        }
        else{
            return cursorBought;
        }

    }

    public boolean onCPUClick(View v){
        TextView cpuLvlText = findViewById(R.id.cpuLvl);
        Button cpuBtn = findViewById(R.id.cpuBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cpuBtn.startAnimation(myAnimation);

        if(masterSum>cpuCost){
            cpuLvl+=1;
            cpuLvlText.setText("Level:"+cpuLvl);
            updateCoinsSum(masterSum,cpuCost);
            ramBought = false;
            cursorBought = false;
            cpuBought = true;
            upgradeList.add(addUpgrade());
            return  cpuBought;

        }
        else{
            return cpuBought = false;
        }

    }
    public boolean onRAMClick(View v) {
        TextView ramLvlText = findViewById(R.id.ramLvl);
        Button ramBtn = findViewById(R.id.ramBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        ramBtn.startAnimation(myAnimation);
        if (masterSum > ramCost) {
            ramLvl += 1;
            ramLvlText.setText("Level:"+ramLvl);
            updateCoinsSum(masterSum,ramCost);
            cpuBought = false;
            cursorBought=false;
            ramBought = true;
            upgradeList.add(addUpgrade());
            return ramBought;
        } else {
            return ramBought;
        }
    }

    public void updateCoinsSum(float coinSum, int cost){
        masterSum = coinSum-cost;
        masterSumTxt.setText("Coins:"+ masterSum);
    }
}
