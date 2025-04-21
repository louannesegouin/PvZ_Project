package com.epf.CORE.models;

public class Map {
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    public Map(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public Map(){
        this.id_map = 0;
        this.ligne = 0;
        this.colonne = 0;
        this.chemin_image = "";
    }

    public int getId_Map() {
        return id_map;
    }

    public void setId_Map(int id_map) {
        this.id_map = id_map;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
