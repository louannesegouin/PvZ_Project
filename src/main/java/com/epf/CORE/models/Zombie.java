package com.epf.CORE.models;

public class Zombie {
    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private int attaque_par_seconde;
    private int degat_attaque;
    private int vitesse_de_deplacement;
    private String chemin_image;
    private int id_map;

    public Zombie(int id_zombie, String nom, int point_de_vie, int attaque_par_seconde, int degat_attaque, int vitesse_de_deplacement, String chemin_image, int id_map) {
        this.id_zombie = id_zombie;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }

    public Zombie(Zombie zombie) {
        this.id_zombie = zombie.id_zombie;
        this.nom = zombie.nom;
        this.point_de_vie = zombie.point_de_vie;
        this.attaque_par_seconde = zombie.attaque_par_seconde;
        this.degat_attaque = zombie.degat_attaque;
        this.vitesse_de_deplacement = zombie.vitesse_de_deplacement;
        this.chemin_image = zombie.chemin_image;
        this.id_map = zombie.id_map;
    }

    public Zombie() {
        // Initialize fields with default values
        this.id_zombie = 0;
        this.nom = "";
        this.point_de_vie = 0;
        this.attaque_par_seconde = 0;
        this.degat_attaque = 0;
        this.vitesse_de_deplacement = 0;
        this.chemin_image = "";
        this.id_map = 0;
    }


    public int getId_zombie() {
        return id_zombie;
    }

    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        if (point_de_vie < 0) {
            throw new IllegalArgumentException("Les points de vie ne peuvent pas être négatifs");
        }
        this.point_de_vie = point_de_vie;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        if (degat_attaque < 0) {
            throw new IllegalArgumentException("Les dégâts ne peuvent pas être négatifs");
        }
        this.degat_attaque = degat_attaque;
    }

    public int getAttaque_par_seconde(){
        return attaque_par_seconde;
    }

    public void setAttaque_par_seconde(int attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getVitesse_de_deplacement(){
        return vitesse_de_deplacement;
    }

    public void setVitesse_de_deplacement(int vitesse_de_deplacement) {
        if (vitesse_de_deplacement < 0) {
            throw new IllegalArgumentException("La vitesse ne peut pas être négative");
        }
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public int getId_map() {
        return id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }
}
