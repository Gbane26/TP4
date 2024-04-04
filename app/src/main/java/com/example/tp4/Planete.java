package com.example.tp4;

import java.io.Serializable;

public class Planete implements Serializable {
    private String nom;
    private int distance;
    private int image;
    private String description;

    Planete (String nom, int distance, int image, String description) {
        this.nom = nom;
        this.distance = distance;
        this.image = image;
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public void setDescription(String description) {this.description = description;}

    public String getNom() {
        return nom;
    }

    public int getDistance() {
        return distance;
    }

    public int getImage() {
        return image;
    }
    public String getDescription() {return description;}
}
