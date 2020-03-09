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

public class EventManager {

    public Event currentEvent;


    public int icon[] = {R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6
            ,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,R.drawable.d11};


    public int randomNumber(int min,int max){
        Random rng = new Random();
        int upperBound = max-min+1;
        return rng.nextInt(upperBound)+min;
    }


    public Event runEvent(){

       int coinEffect = randomNumber(0,9999);
                switch(randomNumber(1,30)) {
                    case 1:
                         currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                         break;
                    case 2:
                        currentEvent = new Event("Cat!", MainActivity.masterSum,"A cat has entered your home! " +
                                "They proceed to steal all of your Doge Coins!",false,false);
                        break;
                    case 3:
                        currentEvent = new Event("Wrong Currency!", 0,"YOU'VE HIT AN INFINITE AMOUNT OF... what? " +
                                "Bit-coins!? Worthless! You've been mining the wrong currency! You get "+coinEffect+" Doge Coins",false,false);
                        break;
                    case 4:
                        currentEvent = new Event("Skill Point!", 1,"The Doge Gods have blessed you! You got a skill point!",true,true);
                        break;
                    case 5:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 6:
                         currentEvent = new Event("Wild Doge!", 10,"A wild doge has " +
                                "entered your home! They took "+10+" Doge Coins!",false,false);
                        break;
                    case 7:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 8:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 9:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 10:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 11:
                        currentEvent = new Event("Wifi Shutdown!", coinEffect,"Your wifi has down down." +
                                " In the process you have lost "+coinEffect+" Doge Coins!",false,false);
                        break;
                    case 12:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 13:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 14:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 15:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 16:
                        currentEvent = new Event("Power Out!", coinEffect,"After a vicious storm " +
                                "your power went out overnight. In the process you have lost "+coinEffect+" Doge Coins!",false,false);
                        break;
                    case 17:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 18:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 19:
                        currentEvent = new Event("Black Hat Hacker!", coinEffect,"A Black Hat Hacker has " +
                            "hacked into your system! You've lost "+ coinEffect+" Doge Coins!",false,false);
                        break;
                    case 20:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 21:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 22:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 23:
                        currentEvent = new Event("Grey Hat Hacker!", coinEffect,"A Grey Hat hacker " +
                                "hacked into your system! Luckily it's Aiden Pearce. He's generous and gives you"+ coinEffect+" Doge Coins!",true,false);
                        break;
                    case 24:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 25:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 26:
                        currentEvent = new Event("White Hat Hacker!", coinEffect,"A White Hat Hacker has " +
                                "hacked into your system! You're grateful for his services but still you gotta pay up. You lose"+ coinEffect+" Doge Coins!",true,false);
                        break;
                    case 27:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                       break;
                    case 28:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;
                    case 29:
                        currentEvent = new Event("Doge Coin Value!", coinEffect,"Doge Coin Value has gone up!" +
                                " You gain"+ coinEffect+" Doge Coins!",true,false);
                        break;
                    case 30:
                        currentEvent = new Event("Wild Doge!", coinEffect,"A wild doge has " +
                                "entered your home! They left you "+coinEffect+" Doge Coins!",true,false);
                        break;

                        default:
                            currentEvent= new Event("You shouldn't be getting this.",0,"The codes wrong bucko",
                                    false,false);
                }
                return currentEvent;
    }





}
