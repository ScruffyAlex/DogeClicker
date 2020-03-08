package com.example.dogeclicker.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dogeclicker.R;
import com.example.dogeclicker.models.PCType;
import com.example.dogeclicker.models.Upgrade;
import com.example.dogeclicker.models.UpgradeType;

public class PermUpgradePage extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perm_upgrade_page);


    }

    public boolean onWifiClick(View v) {
        if(MainActivity.skillPointSum>upgradeCost){
            wifiLvlTxt = findViewById(R.id.wifiLvl);
            wifiLvl+=1;
            wifiLvlTxt.setText("Level: "+wifiLvl);
            updateSkillText(true);
            return wifiBought = true;
        }
        else{
            updateSkillText(false);
            return wifiBought = false;
        }
    }

    public boolean onElectricityClick(View v) {
        if(MainActivity.skillPointSum>upgradeCost){
            electricityLvlTxt = findViewById(R.id.electricityLvl);
            electricityLvl+=1;
            electricityLvlTxt.setText("Level: "+electricityLvl);
            updateSkillText(true);
            return electricityBought = true;
        }
        else{
            updateSkillText(false);
            return electricityBought = false;
        }

    }

    public boolean onMiningPoolCLick(View v) {
        if(MainActivity.skillPointSum>upgradeCost){
            miningPoolLvlTxt = findViewById(R.id.miningLvl);
            miningLvl+=1;
            miningPoolLvlTxt.setText("Level: "+miningLvl);
            updateSkillText(true);
            return  miningPoolBought = true;
        }
        else{
            updateSkillText(false);
            return miningPoolBought = false;
        }

    }

    public Upgrade addUpgrade() {
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



