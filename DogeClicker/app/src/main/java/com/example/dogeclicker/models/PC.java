package com.example.dogeclicker.models;

import java.util.ArrayList;

public class PC {
    private PCType pcType;
    private int prestigeLevel;
    private ArrayList<Upgrade> pcUpgrades = new ArrayList<>();

    public PC(PCType pcType) {
        setPcType(pcType);
    }

    public PCType getPcType() {
        return pcType;
    }

    public void setPcType(PCType pcType) {
        this.pcType = pcType;
    }

}
