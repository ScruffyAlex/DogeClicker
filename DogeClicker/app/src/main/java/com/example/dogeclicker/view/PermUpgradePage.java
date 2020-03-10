package com.example.dogeclicker.view;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dogeclicker.R;
import com.example.dogeclicker.models.PCType;
import com.example.dogeclicker.models.Upgrade;
import com.example.dogeclicker.models.UpgradeType;

public class PermUpgradePage extends AppCompatActivity {

//    Button wifiBtn = findViewById(R.id.wifiBtn);
//    Button elecBtn = findViewById(R.id.elecBtn);
//    Button miningBtn = findViewById(R.id.miningBtn);


    TextView skillPointTxt;
    TextView wifiLvlTxt;
    TextView electricityLvlTxt;
    TextView miningPoolLvlTxt;
    TextView pcLvlTxt;

   public int upgradeCost = 1;
   public int prestigeCost = 99999;

   static int wifiMult = 20;
   static int electricityMult = 30;
   static int miningMult = 40;

    boolean wifiBought = false;
    boolean electricityBought = false;
    boolean miningPoolBought = false;
    boolean pcBought = false;

    int wifiLvl =0;
    int electricityLvl = 0;
    int miningLvl = 0;

    PCType currentPC = PCType.POTATO;



    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.perm_upgrade_page);

//        wifiBtn.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//            onWifiClick();
//            }
//        });
//
//        elecBtn.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                onElectricityClick();
//            }
//        });
//
//        miningBtn.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                onMiningPoolCLick();
//            }
//        });


    }

    public void onWifiClick() {
        if(MainActivity.skillPointSum>upgradeCost){
            wifiLvlTxt = findViewById(R.id.wifiTxt);
            wifiLvl+=1;
            wifiLvlTxt.setText("Level: "+wifiLvl);
            updateSkillText(true);
             wifiBought = true;
        }
        else{
            updateSkillText(false);
            wifiBought = false;
        }
    }

    public void onElectricityClick() {
        if(MainActivity.skillPointSum>upgradeCost){
            electricityLvlTxt = findViewById(R.id.electricityLvlTxt);
            electricityLvl+=1;
            electricityLvlTxt.setText("Level: "+electricityLvl);
            updateSkillText(true);
            electricityBought = true;
        }
        else{
            updateSkillText(false);
            electricityBought = false;
        }

    }

    public void onMiningPoolCLick() {
        if(MainActivity.skillPointSum>upgradeCost){
            miningPoolLvlTxt = findViewById(R.id.miningLvlTxt);
            miningLvl+=1;
            miningPoolLvlTxt.setText("Level: "+miningLvl);
            updateSkillText(true);
            miningPoolBought = true;
        }
        else{
            updateSkillText(false);
            miningPoolBought = false;
        }

    }

    public Upgrade addPermUpgrade() {
        if (wifiBought) {
            Upgrade wifiUpgrade = new Upgrade("Wifi", UpgradeType.PERMANENT, wifiMult);
            return wifiUpgrade;
        } else if (electricityBought) {
            Upgrade electricityUpgrade = new Upgrade("Electricity", UpgradeType.PERMANENT, electricityMult);
            return electricityUpgrade;
        } else if (miningPoolBought) {
            Upgrade  miningUpgrade = new Upgrade("MiningPool", UpgradeType.PERMANENT, miningMult);
            return miningUpgrade;
        }
        else{
            return null;
        }
    }


    public boolean onNextPcClick(View v) {
        if(MainActivity.masterSum>prestigeCost){
            return true;
        }
        else{
            return false;
        }

    }

    public void updateSkillText(boolean canUpgrade){
        if(canUpgrade) {
            MainActivity.skillPointSum = MainActivity.skillPointSum - upgradeCost;
            skillPointTxt = findViewById(R.id.skillPointTxt);
            skillPointTxt.setText("Skill Points: "+MainActivity.skillPointSum);
        }
        else{

        }
    }


}



