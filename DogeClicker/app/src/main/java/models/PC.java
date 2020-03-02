package models;

import java.util.ArrayList;

public class PC {
    private PCType pcType;
    private int prestiegeLevel;
    private ArrayList<Upgrade> pcUpgrades = new ArrayList<>();


    public PCType getPcType() {
        return pcType;
    }

    public void setPcType(PCType pcType) {
        this.pcType = pcType;
    }

    public int getPrestiegeLevel() {
        return prestiegeLevel;
    }

    public void setPrestiegeLevel(int prestiegeLevel) {
        this.prestiegeLevel = prestiegeLevel;
    }

    public ArrayList<Upgrade> getPcUpgrades() {
        return pcUpgrades;
    }

    public void setPcUpgrades(ArrayList<Upgrade> pcUpgrades) {
        this.pcUpgrades = pcUpgrades;
    }
}
