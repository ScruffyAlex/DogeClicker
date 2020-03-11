package com.example.dogeclicker.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogeclicker.R;
import com.example.dogeclicker.controller.EventManager;
import com.example.dogeclicker.models.Event;
import com.example.dogeclicker.models.PC;
import com.example.dogeclicker.models.PCType;
import com.example.dogeclicker.models.Upgrade;
import com.example.dogeclicker.models.UpgradeType;

import java.util.ArrayList;

import static java.lang.System.out;

//total/100 * percentage number


public class MainActivity extends AppCompatActivity {

    EventManager currentEventManager = new EventManager();
    PC currentPC = new PC(PCType.POTATO);
    ArrayList<Upgrade> upgradeList = new ArrayList<>();


    public static double masterSum =0;
    public static double masterMult = 1;

    static int cursorLvl = 0;
    static int ramLvl = 0;
    static int cpuLvl = 0;

    int wifiLvl = 0;
    int electricityLvl = 0;
    int miningLvl = 0;

    static int skillPointSum = 3;
    static int clickAmount = 0;

    public int cursorCost = 15;
    public int cpuCost = 150;
    public int ramCost = 1500;

    boolean cursorBought = false;
    boolean cpuBought = false;
    boolean ramBought = false;

    ImageView dogeView;
    TextView ramCostTxt;
    TextView cpuCostTxt;
    TextView cursorCostTxt;

    TextView cursorLvlText;
    TextView ramLvlText;
    TextView cpuLvlText;
    TextView masterSumTxt;
    TextView masterMultTxt;

    //Permanent Upgrade Page views & Variables

    TextView skillPointTxt;
    TextView wifiLvlTxt;
    TextView electricityLvlTxt;
    TextView miningPoolLvlTxt;
    TextView pcTypeTxt;
    TextView pcCostTxt;

    public int permUpgradeCost = 1;
    double prestigeCost = 50000;


    static int wifiMult = 20;
    static int electricityMult = 30;
    static int miningMult = 40;

    boolean wifiBought = false;
    boolean electricityBought = false;
    boolean miningPoolBought = false;




    //VIEW LOGIC

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
        ImageButton backBtn = findViewById(R.id.backBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        backBtn.startAnimation(myAnimation);
        setContentView(R.layout.activity_main);
        generateGameInfo();
    }

    public void changeImage(int ranImageIndex){
        dogeView.findViewById(R.id.dogeView);
        if(clickAmount>=75) {
            dogeView.setImageResource(currentEventManager.icon[ranImageIndex]);
            clickAmount=0;}
        else{

        }

    }

    public void generateGameInfo(){
        cursorLvlText = findViewById(R.id.cursorLvl);
        cpuLvlText = findViewById(R.id.cpuLvl);
        ramLvlText = findViewById(R.id.ramLvl);
        masterSumTxt = findViewById(R.id.masterSumTxt);
        masterMultTxt = findViewById(R.id.masterMultiplierTxt);

        ramCostTxt = findViewById(R.id.ramCostTxt);
        cpuCostTxt = findViewById(R.id.cpuCostTxt);
        cursorCostTxt = findViewById(R.id.cursorCostTxt);

        cursorLvlText.setText("Level: "+cursorLvl);
        cpuLvlText.setText("Level: "+cpuLvl);
        ramLvlText.setText("Level: "+ramLvl);
        masterSumTxt.setText("Coins:"+masterSum);
        masterMultTxt.setText("Multiplier: x"+masterMult);

        ramCostTxt.setText("Cost: "+ramCost);
        cpuCostTxt.setText("Cost: "+cpuCost);
        cursorCostTxt.setText("Cost: "+cursorCost);
    }

    public void generateUpdateInfo(){
        skillPointTxt = findViewById(R.id.skillPointTxt);
        wifiLvlTxt = findViewById(R.id.wifiTxt);
        electricityLvlTxt = findViewById(R.id.electricityLvlTxt);
        miningPoolLvlTxt = findViewById(R.id.miningLvlTxt);
        pcTypeTxt = findViewById(R.id.pcCostTxt);
        pcCostTxt = findViewById(R.id.pcTypeTxt);

        skillPointTxt.setText("Skill Points: "+MainActivity.skillPointSum);
        wifiLvlTxt.setText("Level: "+wifiLvl);
        electricityLvlTxt.setText("Level: "+electricityLvl);
        miningPoolLvlTxt.setText("Level: "+miningLvl);
        pcCostTxt.setText("Cost: "+prestigeCost);

        pcTypeTxt.setText("Type: "+currentPC.getPcType());
    }
    //END VIEW CHANGING LOGIC




    //MAIN GAME BUTTON CLICK LOGIC
    public void onDogeCoinClick(View v){
        ImageButton dogeBtn = findViewById(R.id.dogeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        masterSumTxt = findViewById(R.id.masterSumTxt);
        masterMultTxt = findViewById(R.id.masterMultiplierTxt);
        dogeView = findViewById(R.id.dogeView);
        dogeBtn.startAnimation(myAnimation);

        masterSum = masterSum + (1*masterMult);
        masterSumTxt.setText("Coins: "+masterSum);

        masterMultTxt.setText("Multiplier: x"+masterMult);
        clickAmount++;
        changeImage(currentEventManager.randomNumber(1,currentEventManager.icon.length-1));
    }

    public void onCursorClick(View v){
        if(clickAmount==0) {
        handleUpgradeBeforeClick();
        }
        else {
            TextView cpuLvlText = findViewById(R.id.cursorLvl);
            TextView cursorCostTxt = findViewById(R.id.cursorCostTxt);
            ImageButton cpuBtn = findViewById(R.id.cursorBtn);

            Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
            cpuBtn.startAnimation(myAnimation);

            if (masterSum >= cursorCost) {
                cursorLvl += 1;
                cpuLvlText.setText("Level:" + cursorLvl);
                updateCoinsSum(masterSum, cursorCost);
                ramBought = false;
                cursorBought = true;
                cpuBought = false;

                cursorCost = cursorCost + ((cursorCost + 5) / 100 + 20);
                cursorCostTxt.setText("Cost: " + cursorCost);
                upgradeList.add(addBasicUpgrade());

                applyUpgrades();

            } else {
                cursorBought = false;
                cantBuyBasicUpgrade();
            }
        }

    }

    public void onCPUClick(View v){

        if(clickAmount==0) {
            handleUpgradeBeforeClick();
        }
        else {
            TextView cpuLvlText = findViewById(R.id.cpuLvl);
            ImageButton cpuBtn = findViewById(R.id.cpuBtn);
            cpuCostTxt = findViewById(R.id.cpuCostTxt);

            Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
            cpuBtn.startAnimation(myAnimation);

            if (masterSum >= cpuCost) {
                cpuLvl += 1;
                cpuLvlText.setText("Level:" + cpuLvl);
                updateCoinsSum(masterSum, cpuCost);
                ramBought = false;
                cursorBought = false;
                cpuBought = true;

                cpuCost = cpuCost + (updateCost(cpuCost, 20));
                cpuCostTxt.setText("Cost: " + cpuCost);
                upgradeList.add(addBasicUpgrade());
                applyUpgrades();

            } else {
                cpuBought = false;
                cantBuyBasicUpgrade();
            }
        }

    }
    public void onRAMClick(View v) {

        if(clickAmount==0) {
            handleUpgradeBeforeClick();
        }
        else {
            TextView ramLvlText = findViewById(R.id.ramLvl);
            ImageButton ramBtn = findViewById(R.id.ramBtn);
            ramCostTxt = findViewById(R.id.ramCostTxt);
            Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
            ramBtn.startAnimation(myAnimation);
            if (masterSum >= ramCost) {
                ramLvl += 1;
                ramLvlText.setText("Level:" + ramLvl);
                updateCoinsSum(masterSum, ramCost);
                cpuBought = false;
                cursorBought = false;
                ramBought = true;
                ramCost = ramCost + updateCost(ramCost, 35);
                ramCostTxt.setText("Cost: " + ramCost);
                upgradeList.add(addBasicUpgrade());
                applyUpgrades();
            } else {
                ramBought = false;
                cantBuyBasicUpgrade();
            }
        }

    }



    public void onUpgradeClick(View v){
        ImageButton upgrade = findViewById(R.id.permUpgradeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        upgrade.startAnimation(myAnimation);
        setContentView(R.layout.perm_upgrade_page);
        generateUpdateInfo();
        upgrade.startAnimation(myAnimation);
    }

    //OVERALL UPGRADE LOGIC

    public void applyUpgrades(){
        try {
            for (int i = 0; i < upgradeList.size(); i++) {
                masterMult =0;
                masterMult += upgradeList.get(i).getMultiplier();
                masterMultTxt.setText("Multiplier: x" + masterMult);
            }
        }
        catch(NullPointerException npe){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("HALT!");
            builder.setMessage("You should try getting coins before upgrading.");
            builder.show();
        }
    }

    public void handleUpgradeBeforeClick(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("HALT");
        builder.setMessage("You should get some coins before applying upgrades.");
        builder.show();
    }

    //END OVERALL UPGRADE LOGIC

    //BASIC UPGRADE LOGIC
    public Upgrade addBasicUpgrade() {
            if (cursorBought) {
                Upgrade cursorUpgrade = new Upgrade("Cursor", UpgradeType.BASIC, 1 * cursorLvl);
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

    //END BASIC UPGRADE LOGIC

    //OVERALL UPDATE LOGIC
    public void updateCoinsSum(double coinSum, double cost){
        masterSum = coinSum-cost;
        masterSumTxt.setText("Coins:"+ masterSum);
    }

    public int updateCost(int currentCost,int percentToIncreaseBy){
        int finalCost;
        finalCost=currentCost/100*percentToIncreaseBy;
        return finalCost;
    }

    //END OVERALL UPDATE LOGIC

    //START PERM UPGRADE CLICK LOGIC
    public void onWifiClick(View v) {
        ImageButton wifiBtn = findViewById(R.id.wifiBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if(masterSum==0) {
            handleUpgradeBeforeClick();
        }
        else {
            if (skillPointSum >= permUpgradeCost) {
                wifiLvlTxt = findViewById(R.id.wifiTxt);
                wifiLvl += 1;
                wifiLvlTxt.setText("Level: " + wifiLvl);
                updateSkillText(true);
                wifiBought = true;
                electricityBought = false;
                miningPoolBought = false;

                upgradeList.add(addPermUpgrade());
                applyUpgrades();
            } else {
                cantBuyPermUpgrade();
                updateSkillText(false);
                wifiBought = false;
            }
        }
        wifiBtn.startAnimation(myAnimation);
    }

    public void onElectricityClick(View v) {
        ImageButton electricBtn = findViewById(R.id.elecBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if(masterSum==0) {
            handleUpgradeBeforeClick();
        }
        else {
            if (skillPointSum >= permUpgradeCost) {
                electricityLvlTxt = findViewById(R.id.electricityLvlTxt);
                electricityLvl += 1;
                electricityLvlTxt.setText("Level: " + electricityLvl);
                updateSkillText(true);
                electricityBought = true;
                wifiBought = false;
                miningPoolBought = false;

                upgradeList.add(addPermUpgrade());
                applyUpgrades();
            } else {
                cantBuyPermUpgrade();
                updateSkillText(false);
                electricityBought = false;
            }
        }
        electricBtn.startAnimation(myAnimation);
    }

    public void onMiningPoolCLick(View v) {
        ImageButton mineBtn = findViewById(R.id.miningBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if(masterSum==0) {
          handleUpgradeBeforeClick();
        }
        else {
            if (skillPointSum >= permUpgradeCost) {
                miningPoolLvlTxt = findViewById(R.id.miningLvlTxt);
                miningLvl += 1;
                miningPoolLvlTxt.setText("Level: " + miningLvl);
                updateSkillText(true);
                wifiBought = false;
                electricityBought = false;
                miningPoolBought = true;

                upgradeList.add(addPermUpgrade());
                applyUpgrades();
            } else {
                cantBuyPermUpgrade();
                updateSkillText(false);
                miningPoolBought = false;
            }
        }
        mineBtn.startAnimation(myAnimation);
    }

    public void onChanceClick(View v) {
        ImageButton chanceBtn = findViewById(R.id.eventBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if (skillPointSum >= permUpgradeCost) {
            skillPointSum--;
            Event currentEvent = currentEventManager.runEvent();
            if(currentEvent.isSkillPointEffect()){
                if(currentEvent.isGoodEvent()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(currentEvent.getName());
                    builder.setMessage(currentEvent.getPromptOfEvent());
                    builder.show();
                    skillPointSum+=currentEvent.getEffect();
                    skillPointTxt.setText("Skill Points: " + MainActivity.skillPointSum);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(currentEvent.getName());
                    builder.setMessage(currentEvent.getPromptOfEvent());
                    builder.show();
                    skillPointTxt.setText("Skill Points: " + MainActivity.skillPointSum);
                }
            }
            else{
                if(currentEvent.isGoodEvent()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(currentEvent.getName());
                    builder.setMessage(currentEvent.getPromptOfEvent());
                    builder.show();
                    masterSum+=currentEvent.getEffect();
                    skillPointTxt.setText("Skill Points: " + MainActivity.skillPointSum);
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(currentEvent.getName());
                    builder.setMessage(currentEvent.getPromptOfEvent());
                    builder.show();
                    updateCoinsSum(masterSum,currentEvent.getEffect());
                    skillPointTxt.setText("Skill Points: " + MainActivity.skillPointSum);
                }
            }
        }
        else{
            cantBuyPermUpgrade();
        }
        chanceBtn.startAnimation(myAnimation);
    }//end onChanceClick

    public void onNextPcClick(View v) {
        ImageButton pcBtn = findViewById(R.id.typeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        if (masterSum >= prestigeCost) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("You've prestiged!");
            builder.setMessage("Your game has reset but now you have a better build and start off with a bigger multiplier." +
                    " Your Permanent Upgrades have also been kept!");
            builder.show();
            skillPointSum++;
            masterMult = 0;
            masterSum = 0;
            cpuLvl = 0;
            ramLvl = 0;
            cursorLvl = 0;
            cursorCost = 15;
            cpuCost = 150;
            ramCost = 1500;

            for(int i=0;i<upgradeList.size();i++){
                if(upgradeList.get(i).getType()==UpgradeType.BASIC){
                    upgradeList.remove(i);
                    i--;
                }
            }

            applyUpgrades();
            out.println(upgradeList.toString());

            if(currentPC.getPcType()== PCType.POTATO) {
                builder.setTitle("The Cake is a Lie");
                builder.setMessage("Throw away that cybernetic potato. You've got a Dinosaur of a computer now. You also got a base multiplier of "+50);
                builder.show();
                currentPC.setPcType(PCType.DINOSAUR);
                masterMult = masterMult+ 50;
                //prestigeCost = 5000000000.0;
                prestigeCost = 100000;
            }
            else if(currentPC.getPcType() == PCType.DINOSAUR){
                builder.setTitle("Ok Boomer");
                builder.setMessage("A desktop is fine... if you were a boomer. Keep playing to get better. You also got a base multiplier of "+150);
                builder.show();
                currentPC.setPcType(PCType.DESKTOP);
                masterMult = masterMult+ 150;
                prestigeCost =150000.0;
            }
            else if(currentPC.getPcType() == PCType.DESKTOP){
                builder.setTitle("Rise up Gamers");
                builder.setMessage("It's Gamer time, you got a Gaming computer now! You also got a base multiplier of"+ 200);
                builder.show();
                currentPC.setPcType(PCType.GAMING);
                masterMult = masterMult+ 200;

                prestigeCost = 20000000;

            }
            else if(currentPC.getPcType() == PCType.GAMING){
                builder.setTitle("*Minecraft Noises*");
                builder.setMessage("You've gone up to the best rig! You also got a base multiplier of "+500);
                builder.show();
                currentPC.setPcType(PCType.MININGRIG);
                masterMult = masterMult+ 500;

                prestigeCost = 50000;
            }
            else if(currentPC.getPcType() == PCType.MININGRIG){
                builder.setTitle("Best Build!");
                builder.setMessage("You've got the best possible rig! Take 1,000,000 Doge Coins and 3 skill points instead!");
                builder.show();
                masterSum+=100000000;
                skillPointSum+=3;
            }

        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("STOP! YOU HAVE VIOLATED THE LAW");
            builder.setMessage("You can't prestige yet!");
            builder.show();
        }
        generateUpdateInfo();
        pcBtn.startAnimation(myAnimation);
    }

    //END PERM UPGRADE CLICK LOGIC

        public Upgrade addPermUpgrade(){
            if (wifiBought) {
                Upgrade wifiUpgrade = new Upgrade("Wifi", UpgradeType.PERMANENT, wifiMult);
                return wifiUpgrade;
            } else if (electricityBought) {
                Upgrade electricityUpgrade = new Upgrade("Electricity", UpgradeType.PERMANENT, electricityMult);
                return electricityUpgrade;
            } else if (miningPoolBought) {
                Upgrade miningUpgrade = new Upgrade("MiningPool", UpgradeType.PERMANENT, miningMult);
                return miningUpgrade;
            } else {
                return null;
            }
        }

        public void updateSkillText (boolean canUpgrade){
            if (canUpgrade) {
                MainActivity.skillPointSum = MainActivity.skillPointSum - permUpgradeCost;
                skillPointTxt = findViewById(R.id.skillPointTxt);
                skillPointTxt.setText("Skill Points: " + MainActivity.skillPointSum);
            } else {

            }
        }
        public void cantBuyBasicUpgrade(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("STOP! YOU HAVE VIOLATED THE LAW");
            builder.setMessage("STOP! YOU VIOLATED THE LAW! PAY THE COURT A FINE OR SERVE YOUR SENTENCE, YOUR STOLEN GOODS ARE NOW FORFEIT." +
                    " (You don't have enough coins)");
            builder.show();
        }

        public void cantBuyPermUpgrade(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("STOP! YOU HAVE VIOLATED THE LAW");
            builder.setMessage("STOP! YOU VIOLATED THE LAW! PAY THE COURT A FINE OR SERVE YOUR SENTENCE, YOUR STOLEN GOODS ARE NOW FORFEIT." +
                    " (You don't have enough skill points)");
            builder.show();
        }
    }



