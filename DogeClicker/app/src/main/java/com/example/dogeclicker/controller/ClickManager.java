package com.example.dogeclicker.controller;

import com.example.dogeclicker.models.Event;
import com.example.dogeclicker.models.Upgrade;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ClickManager {

    public float coinSum = 0;
    public int skillPointSum = 0;
    public float masterMultiplyer = 0f;
    public Event.PC currentPC;
    public Event currentEvent;
    public ArrayList<Upgrade> upgrades = new ArrayList<>();

    public void run(){

    }

    public int coinCounter(){

        return 0;
    }

    public void addUpgrade(){

    }


    public boolean removeUpgrade(){

        return true;
    }


    public int skillPointCounter(){
        return skillPointSum;
    }





    public float runEvent(){
        Random rng = new Random();

        rng.nextInt(10);
        int coinEffect = rng.nextInt(999999);
        Event currentEvent= new Event("Test",0,"Test",false);
                switch(rng.nextInt(5)) {

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
                        break;
                    case 7:
                        break;
                }


                return currentEvent.getEffect();
    }

    public float click(){
        return 0f;
    }

    public float autoClick(){
        return 0f;
    }








}
