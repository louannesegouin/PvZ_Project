package com.epf.CORE;

public class Zombie {
    private Long id;
    private String name;
    private int health;
    private int damagepersec;
    private int damage;
    private int speed;
    private String pathimage;
    private String idmap;

    public Zombie() {
    }

    public Zombie(Long id, String name, int health, int damagepersec, int damage, int speed, String pathimage, String idmap) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damagepersec = damagepersec;
        this.damage = damage;
        this.speed = speed;
        this.pathimage = pathimage;
        this.idmap = idmap;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamagepersec(){
        return damagepersec;
    }

    public void setDamagepersec(int damagepersec) {
        this.damagepersec = damagepersec;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getPathimage() {
        return pathimage;
    }

    public void setPathimage(String pathimage) {
        this.pathimage = pathimage;
    }

    public String getIdmap() {
        return idmap;
    }

    public void setIdmap(String idmap) {
        this.idmap = idmap;
    }

    @Override
    public String toString() {
        return "Zombie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", damage per second=" + damagepersec +
                ", damage=" + damage +
                ", speed=" + speed +
                ", path image='" + pathimage + '\'' +
                ", id map='" + idmap + '\'' +
                '}';
    }
}
