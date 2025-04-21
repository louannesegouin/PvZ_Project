package com.epf.API.DTO;

public class MapDTO {
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    // Constructeurs, getters et setters
    public MapDTO(){}

    public MapDTO(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public int getId() {
        return id_map;
    }

    public void setId(int id) {
        this.id_map = id;
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

