package com.example.tp4;

import java.io.Serializable;

public class Planete implements Serializable {
    private String nom;
    private int distance;
    private int image;

    Planete (String nom, int distance, int image) {
        this.nom = nom;
        this.distance = distance;
        this.image = image;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getNom() {
        return nom;
    }

    public int getDistance() {
        return distance;
    }

    public int getImage() {
        return image;
    }
}
