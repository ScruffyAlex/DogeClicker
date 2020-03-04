package com.example.dogeclicker.models;

import java.util.ArrayList;

public class PC {
    private PCType pcType;
    private int prestigeLevel;
    private ArrayList<Upgrade> pcUpgrades = new ArrayList<>();

    public PC(PCType pcType, int prestigeLevel, ArrayList<Upgrade> pcUpgrades) {
        this.pcType = pcType;
        this.prestigeLevel = prestigeLevel;
        this.pcUpgrades = pcUpgrades;
    }

    public PCType getPcType() {
        return pcType;
    }

    public void setPcType(PCType pcType) {
        this.pcType = pcType;
    }

    public int getPrestigeLevel() {
        return prestigeLevel;
    }

    public void setPrestigeLevel(int prestigeLevel) {
        this.prestigeLevel = prestigeLevel;
    }

    public ArrayList<Upgrade> getPcUpgrades() {
        return pcUpgrades;
    }

    public void setPcUpgrades(ArrayList<Upgrade> pcUpgrades) {
        this.pcUpgrades = pcUpgrades;
    }
}
