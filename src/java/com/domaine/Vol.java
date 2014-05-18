/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaine;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author nicolas.pendon
 */
public class Vol {
    private int numsequence;
    private Date datesequence;
    private int temps;
    private int heures_forfait;
    private float prix_special;
    private float taux;
    private float reduction_semaine;
    private String motif;
    private float taux_instructeur;
    private int forfait_initiation;
    private int num_membre;
    private int num_instructeur;
    private int num_avion;
    
    public Vol() {
        this(-1, new Date());
    }
    
    public Vol(int num, Date date) {
        numsequence = num;
        datesequence = date;
        motif = "";
        prix_special = -1;
        num_avion = -1;
    }
    
    public void setNum(int num) {
        numsequence = num;
    }
    
    public void setDate(Date date) {
        datesequence = date;
    }
    
    public void setNumMembre(int num) {
        num_membre = num;
    }
    
    public int getNum() {
        return numsequence;
    }
    
    public Date getDate() {
        return datesequence;
    }
    
    public int getNumMembre() {
        return num_membre;
    }

    /**
     * @return the temps
     */
    public int getTemps() {
        return temps;
    }

    /**
     * @param temps the temps to set
     */
    public void setTemps(int temps) {
        this.temps = temps;
    }

    /**
     * @return the heures_forfait
     */
    public int getHeuresForfait() {
        return heures_forfait;
    }

    /**
     * @param heures_forfait the heures_forfait to set
     */
    public void setHeuresForfait(int heures_forfait) {
        this.heures_forfait = heures_forfait;
    }

    /**
     * @return the prix_special
     */
    public float getPrixSpecial() {
        return prix_special;
    }

    /**
     * @param prix_special the prix_special to set
     */
    public void setPrixSpecial(float prix_special) {
        this.prix_special = prix_special;
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
     * @return the reduction_semaine
     */
    public float getReductionSemaine() {
        return reduction_semaine;
    }

    /**
     * @param reduction_semaine the reduction_semaine to set
     */
    public void setReductionSemaine(float reduction_semaine) {
        this.reduction_semaine = reduction_semaine;
    }

    /**
     * @return the motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * @param motif the motif to set
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * @return the taux_instructeur
     */
    public float getTauxInstructeur() {
        return taux_instructeur;
    }

    /**
     * @param taux_instructeur the taux_instructeur to set
     */
    public void setTauxInstructeur(float taux_instructeur) {
        this.taux_instructeur = taux_instructeur;
    }

    /**
     * @return the forfait_initiation
     */
    public int getForfaitInitiation() {
        return forfait_initiation;
    }

    /**
     * @param forfait_initiation the forfait_initiation to set
     */
    public void setForfaitInitiation(int forfait_initiation) {
        this.forfait_initiation = forfait_initiation;
    }

    /**
     * @return the num_instructeur
     */
    public int getNumInstructeur() {
        return num_instructeur;
    }

    /**
     * @param num_instructeur the num_instructeur to set
     */
    public void setNumInstructeur(int num_instructeur) {
        this.num_instructeur = num_instructeur;
    }

    /**
     * @return the num_avion
     */
    public int getNumAvion() {
        return num_avion;
    }

    /**
     * @param num_avion the num_avion to set
     */
    public void setNumAvion(int num_avion) {
        this.num_avion = num_avion;
    }
    
    @Override
    public String toString() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(datesequence);
        int year = cal.get(Calendar.YEAR);
        int month= cal.get(Calendar.MONTH) +1; // +1 car démarre à Janvier = 0 (incohérence dans la classe Calendar ?!)
        int day  = cal.get(Calendar.DAY_OF_MONTH);
        String date = year + "-" + (month < 10 ? "0" : "") + month + "-" + (day < 10 ? "0" : "") + day;
        return date + " #" + numsequence;
    }
}
