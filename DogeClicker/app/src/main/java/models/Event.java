package models;

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


    public static class PC {
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

    public static class Upgrade {
        private String name;
        private UpgradeType type;
        private double multiplier;

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
}
