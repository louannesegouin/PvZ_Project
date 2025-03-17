package com.epf.CORE;

public class Plant {
    private Long id;
    private String name;
    private int health;
    private int damagerpersec;
    private int damage;
    private int cost;
    private int sunpersec;
    private String effect;
    private String pathimage;

    public Plant() {
    }

    public Plant(Long id, String name, int health, int damage, int cost, int sunpersec, String effect, String pathimage) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.cost = cost;
        this.sunpersec = sunpersec;
        this.effect = effect;
        this.pathimage = pathimage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDamagerpersec(int damagerpersec) {
        this.damagerpersec = damagerpersec;
    }

    public int getDamagerpersec() {
        return damagerpersec;
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
    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", damage per second=" + damagerpersec +
                ", damage=" + damage +
                ", cost=" + cost +
                ", sun per second=" + sunpersec +
                ", effect='" + effect + '\'' +
                ", path image='" + pathimage + '\'' +
                '}';
    }
}
