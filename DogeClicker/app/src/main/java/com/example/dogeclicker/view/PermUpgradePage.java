package com.example.dogeclicker.view;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dogeclicker.R;

public class PermUpgradePage extends AppCompatActivity {

    static int skillPointSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perm_upgrade_page);

    }

    public void onWifiClick(View v){

    }

    public void onElectricityClick(View v){

    }

    public void onMiningPoolCLick(View v){

    }
    public void onNextPcClick(View v){

    }


    public int skillPointCounter(){
        return skillPointSum;
    }
}
