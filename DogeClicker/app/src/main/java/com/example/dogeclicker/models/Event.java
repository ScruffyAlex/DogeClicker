package com.example.dogeclicker.models;

public class Event {
    private String name;
    private double effect;
    private String promptOfEvent;
    private boolean goodEvent;
    private boolean isSkillPointEffect;

    public Event(String name, double effect, String promptOfEvent, boolean goodEvent,boolean isSkillPointEffect) {
        setName(name);
        setEffect(effect);
        setPromptOfEvent(promptOfEvent);
        setGoodEvent(goodEvent);
        setAsSkillPointEffect(isSkillPointEffect);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEffect() {
        return effect;
    }

    public void setEffect(double effect) {
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

    public boolean isSkillPointEffect() {
        return isSkillPointEffect;
    }

    public void setAsSkillPointEffect(boolean skillPointEffect) {
        isSkillPointEffect = skillPointEffect;
    }



}
