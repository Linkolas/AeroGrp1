/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.domaine;

import java.util.List;

/**
 *
 * @author Nicolas
 */
public class Avion {
    private int num_avion;
    private String type_avion;
    private float taux;
    private float reduction;
    private String immatriculation;
    private List<Forfait> forfaits;
    
    public Avion() {
        num_avion = -1;
    }
    
    public void setForfaits(List<Forfait> vforf) {
        forfaits = vforf;
    }
    
    public List<Forfait> getForfaits() {
        return forfaits;
    }
    
    /**
     * @return the num_avion
     */
    public int getNum_avion() {
        return num_avion;
    }

    /**
     * @param num_avion the num_avion to set
     */
    public void setNum_avion(int num_avion) {
        this.num_avion = num_avion;
    }

    /**
     * @return the type_avion
     */
    public String getType_avion() {
        return type_avion;
    }

    /**
     * @param type_avion the type_avion to set
     */
    public void setType_avion(String type_avion) {
        this.type_avion = type_avion;
    }

    /**
     * @return the taux
     */
    public float getTaux() {
        return taux;
    }

    /**
     * @param taux the taux to set
     */
    public void setTaux(float taux) {
        this.taux = taux;
    }

    /**
     * @return the reduction
     */
    public float getReduction() {
        return reduction;
    }

    /**
     * @param reduction the reduction to set
     */
    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    /**
     * @return the immatriculation
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * @param immatriculation the immatriculation to set
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
}
