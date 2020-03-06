package com.example.dogeclicker.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dogeclicker.R;

import org.w3c.dom.Text;

public class PermUpgradePage extends AppCompatActivity {

   public int upgradeCost = 1;
   public int prestigeCost = 99999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perm_upgrade_page);



    }

    public boolean onWifiClick(View v) {
        if(MainActivity.masterSum>upgradeCost){
            return true;
        }
        else{
            return false;
        }
    }

    public void onElectricityClick(View v) {

    }

    public void onMiningPoolCLick(View v) {

    }

    public void onNextPcClick(View v) {

    }
}



