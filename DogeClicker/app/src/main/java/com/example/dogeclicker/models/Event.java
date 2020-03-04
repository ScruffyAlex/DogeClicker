package com.example.dogeclicker.models;

import java.util.ArrayList;

public class Event {
    private String name;
    private int effect;
    private String promptOfEvent;
    private boolean goodEvent;

    public Event(String name, int effect, String promptOfEvent, boolean goodEvent) {
        setName(name);
        setEffect(effect);
        setPromptOfEvent(promptOfEvent);
        setGoodEvent(goodEvent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public String getPromptOfEvent() {
        return promptOfEvent;
    }

    public void setPromptOfEvent(String promptOfEvent) {
        this.promptOfEvent = promptOfEvent;
    }

    public boolean isGoodEvent() {
        return goodEvent;
    }

    public void setGoodEvent(boolean goodEvent) {
        this.goodEvent = goodEvent;
    }

    public int addAmount(){
        return 0;
    }

    }

