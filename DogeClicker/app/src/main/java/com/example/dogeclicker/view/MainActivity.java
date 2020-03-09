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

    public static double masterSum =0;
    public static double masterMult = 1;

    static int cursorLvl = 0;
    static int ramLvl = 0;
    static int cpuLvl = 0;

    int wifiLvl = 0;
    int electricityLvl = 0;
    int miningLvl = 0;

    static int skillPointSum = 20;
    static int clickAmount = 0;

    ArrayList<Upgrade> upgradeList = new ArrayList<>();

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

    //Permanent Upgrade Page

    TextView skillPointTxt;
    TextView wifiLvlTxt;
    TextView electricityLvlTxt;
    TextView miningPoolLvlTxt;
    TextView pcTypeTxt;
    TextView pcCostTxt;

    public int upgradeCost = 1;
    //double prestigeCost = 1000000000;
    double prestigeCost = 30;


    static int wifiMult = 20;
    static int electricityMult = 30;
    static int miningMult = 40;

    boolean wifiBought = false;
    boolean electricityBought = false;
    boolean miningPoolBought = false;
    boolean chanceBought = false;
    boolean pcBought = false;

    PC currentPC = new PC(PCType.POTATO);


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
        setContentView(R.layout.activity_main);
        generateGameInfo();
    }

    public void changeImage(int ranImageIndex){
        dogeView.findViewById(R.id.dogeView);

        if(clickAmount>=200) {
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
        changeImage(currentEventManager.randomNumber(1,currentEventManager.icon.length));



    }

    public void onCursorClick(View v){
        TextView cpuLvlText = findViewById(R.id.cursorLvl);
        TextView cursorCostTxt = findViewById(R.id.cursorCostTxt);
        ImageButton cpuBtn = findViewById(R.id.cursorBtn);

        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cpuBtn.startAnimation(myAnimation);

        if(masterSum>=cursorCost){
            cursorLvl+=1;
            cpuLvlText.setText("Level:"+cursorLvl);
            updateCoinsSum(masterSum,cursorCost);
            ramBought = false;
            cursorBought = true;
            cpuBought = false;

            cursorCost = cursorCost+((cursorCost+5)/100+20);
            cursorCostTxt.setText("Cost: "+cursorCost);
            upgradeList.add(addBasicUpgrade());

            applyUpgrades();

        }
        else{
            cursorBought = false;
            cantBuyBasicUpgrade();
        }

    }

    public void onCPUClick(View v){
        TextView cpuLvlText = findViewById(R.id.cpuLvl);
        ImageButton cpuBtn = findViewById(R.id.cpuBtn);
        cpuCostTxt = findViewById(R.id.cpuCostTxt);

        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        cpuBtn.startAnimation(myAnimation);

        if(masterSum>=cpuCost){
            cpuLvl+=1;
            cpuLvlText.setText("Level:"+cpuLvl);
            updateCoinsSum(masterSum,cpuCost);
            ramBought = false;
            cursorBought = false;
            cpuBought = true;

            cpuCost = cpuCost+ (updateCost(cpuCost,20));
            cpuCostTxt.setText("Cost: "+cpuCost);
            upgradeList.add(addBasicUpgrade());
            applyUpgrades();

        }
        else{
            cpuBought = false;
            cantBuyBasicUpgrade();
        }

    }
    public void onRAMClick(View v) {
        TextView ramLvlText = findViewById(R.id.ramLvl);
        ImageButton ramBtn = findViewById(R.id.ramBtn);
        ramCostTxt = findViewById(R.id.ramCostTxt);
        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        ramBtn.startAnimation(myAnimation);
        if (masterSum >= ramCost) {
            ramLvl += 1;
            ramLvlText.setText("Level:"+ramLvl);
            updateCoinsSum(masterSum,ramCost);
            cpuBought = false;
            cursorBought=false;
            ramBought = true;
            ramCost = ramCost+ updateCost(ramCost,35);
            ramCostTxt.setText("Cost: "+ramCost);
            upgradeList.add(addBasicUpgrade());
            applyUpgrades();
        } else {
            ramBought=false;
            cantBuyBasicUpgrade();
        }

    }



    public void onUpgradeClick(View v){
        Button upgrade = findViewById(R.id.permUpgradeBtn);
        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        upgrade.startAnimation(myAnimation);
        setContentView(R.layout.perm_upgrade_page);
        generateUpdateInfo();
    }

    //OVERALL UPGRADE LOGIC

    public void applyUpgrades(){
        for(int i=0;i<upgradeList.size();i++){
            masterMult += upgradeList.get(i).getMultiplier();
            masterMultTxt.setText("Multiplier: x"+masterMult);
        }
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
        if(skillPointSum>=upgradeCost){
            wifiLvlTxt = findViewById(R.id.wifiTxt);
            wifiLvl+=1;
            wifiLvlTxt.setText("Level: "+wifiLvl);
            updateSkillText(true);
            wifiBought = true;
            electricityBought = false;
            miningPoolBought = false;

            upgradeList.add(addPermUpgrade());
            applyUpgrades();
        }
        else{
            cantBuyPermUpgrade();
            updateSkillText(false);
            wifiBought = false;
        }
    }


    public void onElectricityClick(View v) {
        if(skillPointSum>=upgradeCost){
            electricityLvlTxt = findViewById(R.id.electricityLvlTxt);
            electricityLvl+=1;
            electricityLvlTxt.setText("Level: "+electricityLvl);
            updateSkillText(true);
            electricityBought = true;
            wifiBought = false;
            miningPoolBought = false;

            upgradeList.add(addPermUpgrade());
            applyUpgrades();
        }
        else{
            cantBuyPermUpgrade();
            updateSkillText(false);
            electricityBought = false;
        }

    }

    public void onMiningPoolCLick(View v) {
        if(skillPointSum>=upgradeCost){
            miningPoolLvlTxt = findViewById(R.id.miningLvlTxt);
            miningLvl+=1;
            miningPoolLvlTxt.setText("Level: "+miningLvl);
            updateSkillText(true);
            wifiBought = false;
            electricityBought = false;
            miningPoolBought = true;

            upgradeList.add(addPermUpgrade());
            applyUpgrades();
        }
        else{
            cantBuyPermUpgrade();
            updateSkillText(false);
            miningPoolBought = false;
        }

    }

    public void onChanceClick(View v) {
        if (skillPointSum >= upgradeCost) {
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
    }//end onChanceClick

    public void onNextPcClick(View v) {
        if (masterSum >= prestigeCost) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("You've prestiged!");
            builder.setMessage("Your game has reset but now you have a better build and start off with a bigger multiplier." +
                    " Your Permanent Upgrades have also been kept!");
            builder.show();
            skillPointSum++;
            masterMult = 0;
            masterSum = 0;

            for(int i=0;i<upgradeList.size();i++){
                if(upgradeList.get(i).getType()==UpgradeType.BASIC){
                    upgradeList.remove(i);
                }
            }

            applyUpgrades();
            out.println(upgradeList.toString());

//            if(currentPC==PCType.POTATO){
//                masterMult+=0;
//            }
//            else if(currentPC==PCType.DINOSAUR){
//                masterMult+=50;
//            }
//            else if(currentPC==PCType.DESKTOP){
//                masterMult+=150;
//            }
//            else if(currentPC==PCType.GAMING){
//                masterMult+=200;
//            }
//            else if(currentPC==PCType.MININGRIG){
//                masterMult+=500;
//            }


            //1,000,000,000 potato - dino
            //5,000,000,000 dinosaur - desk
            //10,000,000,000 desktop - game
            //15,000,000,000 gaming - mining
            //20,000,000,000 miningrig - dogeCoins
            //25,000,000,000  1,000,000,000 DogeCoins
            if(currentPC.getPcType()== PCType.POTATO) {
                builder.setTitle("The Cake is a Lie");
                builder.setMessage("Throw away that cybernetic potato. You've got a Dinosaur of a computer now.");
                builder.show();
                currentPC.setPcType(PCType.DINOSAUR);
                masterMult = masterMult+ 50;
                //prestigeCost = 5000000000.0;
                prestigeCost = 15000;
            }
            else if(currentPC.getPcType() == PCType.DINOSAUR){
                builder.setTitle("Ok Boomer");
                builder.setMessage("A desktop is fine... if you were a boomer. Keep playing to get better.");
                builder.show();
                currentPC.setPcType(PCType.DESKTOP);
                masterMult = masterMult+ 150;
                prestigeCost =100000.0;
            }
            else if(currentPC.getPcType() == PCType.DESKTOP){
                builder.setTitle("Rise up Gamers");
                builder.setMessage("It's Gamer time, you got a Gaming computer now!");
                builder.show();
                currentPC.setPcType(PCType.GAMING);
                masterMult = masterMult+ 200;

                prestigeCost = 10000000;

            }
            else if(currentPC.getPcType() == PCType.GAMING){
                builder.setTitle("*Minecraft Noises*");
                builder.setMessage("You've gone up to the best rig!");
                builder.show();
                currentPC.setPcType(PCType.MININGRIG);
                masterMult = masterMult+ 500;

                prestigeCost = 50000;
            }
            else if(currentPC.getPcType() == PCType.MININGRIG){
                builder.setTitle("Best Build!");
                builder.setMessage("You've got the best possible rig! Take 1,000,000 Doge coins instead!");
                builder.show();
                masterSum+=100000000;
            }

        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("STOP! YOU HAVE VIOLATED THE LAW");
            builder.setMessage("You can't prestige yet!");
            builder.show();
        }
        generateUpdateInfo();
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
                MainActivity.skillPointSum = MainActivity.skillPointSum - upgradeCost;
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



