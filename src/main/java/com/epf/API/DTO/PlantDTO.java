package com.epf.API.DTO;

public class PlantDTO {
    private int idPlant;
    private String name;
    private int health;
    private int damage;
    private int damagepersec;
    private int cost;
    private int sunpersec;
    private String effect;
    private String pathimage;

    public PlantDTO(){}

    public PlantDTO(int idPlant, String name, int health, int damage, int damagepersec, int cost, int sunpersec, String effect, String pathimage) {
        this.idPlant = idPlant;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.damagepersec = damagepersec;
        this.cost = cost;
        this.sunpersec = sunpersec;
        this.effect = effect;
        this.pathimage = pathimage;
    }

    public int getId() {
        return idPlant;
    }

    public void setId(int id) {
        this.idPlant = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamagepersec(int damagepersec) {
        this.damagepersec = damagepersec;
    }

    public int getDamagepersec() {
        return damagepersec;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSunpersec() {
        return sunpersec;
    }

    public void setSunpersec(int sunpersec) {
        this.sunpersec = sunpersec;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getPathimage() {
        return pathimage;
    }

    public void setPathimage(String pathimage) {
        this.pathimage = pathimage;
    }
}

