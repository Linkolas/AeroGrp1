/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.domaine;

/**
 *
 * @author Nicolas
 */
public class Forfait {
    private String typeAvion;
    private int numero;
    private float prix;
    private int heures;

    /**
     * @return the typeAvion
     */
    public String getTypeAvion() {
        return typeAvion;
    }

    /**
     * @param typeAvion the typeAvion to set
     */
    public void setTypeAvion(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }

    /**
     * @return the heures
     */
    public int getHeures() {
        return heures;
    }

    /**
     * @param heures the heures to set
     */
    public void setHeures(int heures) {
        this.heures = heures;
    }
}
