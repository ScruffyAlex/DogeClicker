package com.example.dogeclicker.controller;

import android.widget.ImageView;

import com.example.dogeclicker.R;
import com.example.dogeclicker.models.Event;
import com.example.dogeclicker.models.PC;
import com.example.dogeclicker.models.Upgrade;
import com.example.dogeclicker.view.MainActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ClickManager {

    static int skillPointSum = 0;
    public float coinSum = 0;
    public float masterMultiplyer = 0f;
    public PC currentPC;
    public Event currentEvent;
    public ArrayList<Upgrade> upgrades = new ArrayList<>();



    public int icon[] = {R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6
            ,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,R.drawable.d11};


    public int randomNumber(int min,int max){
        Random rng = new Random();
        int upperBound = max-min+1;
        return rng.nextInt(upperBound)+min;
    }


    public boolean removeUpgrade(){
        if(upgrades.size()>0){
            upgrades.remove(0);
            return true;
        }
        else{
            return false;
        }
    }

    public float runEvent(){

        int coinEffect = randomNumber(0,999999);
        Event currentEvent= new Event("Test",0,"Test",false);
                switch(randomNumber(1,30)) {
                    case 1:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true);
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They took "+coinEffect+" Doge Coins!",false);
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        currentEvent = new Event("Wifi Shutdown!", coinEffect,"Your wifi has down down." +
                                " In the process you have lost "+coinEffect+" Doge Coins!",false);
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        currentEvent = new Event("Power Out!", coinEffect,"After a vicious storm " +
                                "your power went out overnight. In the process you have lost "+coinEffect+" Doge Coins!",false);
                        break;
                    case 17:
                        break;
                    case 18:
                        break;
                    case 19:
                        currentEvent = new Event("Black Hat Hacker!", coinEffect,"A Black Hat Hacker has " +
                            "hacked into your system! You've lost "+ coinEffect+" Doge Coins!",false);
                        break;
                    case 20:
                        break;
                    case 21:
                        break;
                    case 22:
                        break;
                    case 23:
                        currentEvent = new Event("Grey Hat Hacker!", coinEffect,"A Grey Hat hacker " +
                                "hacked into your system! Luckily it's Aiden Pearce. He's generous and gives you"+ coinEffect+" Doge Coins!",true);
                        break;
                    case 24:
                        break;
                    case 25:
                        break;
                    case 26:
                        currentEvent = new Event("White Hat Hacker!", coinEffect,"A White Hat Hacker has " +
                                "hacked into your system! You're grateful for his services but still you gotta pay up. You lose"+ coinEffect+" Doge Coins!",true);
                        break;
                    case 27:
                        break;
                    case 28:
                        break;
                    case 29:
                        currentEvent = new Event("Doge Coin Value!", coinEffect,"Doge Coin Value has gone up!" +
                                "You gain"+ coinEffect+" Doge Coins!",true);
                        break;
                    case 30:
                        break;
                }
                return currentEvent.getEffect();
    }





}
