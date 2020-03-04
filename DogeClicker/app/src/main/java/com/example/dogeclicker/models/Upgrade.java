package com.example.dogeclicker.models;

import com.example.dogeclicker.models.UpgradeType;

public class Upgrade {
    private String name;
    private UpgradeType type;
    private double multiplier;

    public Upgrade(String name, UpgradeType type, double multiplier) {
        this.name = name;
        this.type = type;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpgradeType getType() {
        return type;
    }

    public void setType(UpgradeType type) {
        this.type = type;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString(){
     return "uwu";
    }
}
