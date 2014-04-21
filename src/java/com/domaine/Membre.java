/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domaine;

import java.util.Date;

/**
 *
 * @author cyril.delanghe
 */
public class Membre {

    public Membre(int num_membre, String nom, String prenom, String adresse, String code_postal, String ville, String tel, String portable, String email, String commentaire, Date date_vm, Date validite_vm, Date date_sep, Date validite_sep, String num_badge, String profession, Date date_naissance, String lieu_naissance, String carte_federale, Date date_attestation, Date date_theorique_bb, Date date_theorique_ppla, String numero_bb, Date date_entree, boolean membre_actif, boolean membre_inscrit, int num_civil, int num_qualif) {
        this.num_membre = num_membre;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.ville = ville;
        this.tel = tel;
        this.portable = portable;
        this.email = email;
        this.commentaire = commentaire;
        this.date_vm = date_vm;
        this.validite_vm = validite_vm;
        this.date_sep = date_sep;
        this.validite_sep = validite_sep;
        this.num_badge = num_badge;
        this.profession = profession;
        this.date_naissance = date_naissance;
        this.lieu_naissance = lieu_naissance;
        this.carte_federale = carte_federale;
        this.date_attestation = date_attestation;
        this.date_theorique_bb = date_theorique_bb;
        this.date_theorique_ppla = date_theorique_ppla;
        this.numero_bb = numero_bb;
        this.date_entree = date_entree;
        this.membre_actif = membre_actif;
        this.membre_inscrit = membre_inscrit;
        this.num_civil = num_civil;
        this.num_qualif = num_qualif;
    }

    public Membre() {
    }
    
    private int num_membre;
    private String nom;
    private String prenom;
    private String adresse;
    private String code_postal;
    private String ville;
    private String tel;
    private String portable;
    private String email;
    private String commentaire;
    private Date date_vm;
    private Date validite_vm;
    private Date date_sep;
    private Date validite_sep;
    private String num_badge;
    private String profession;
    private Date date_naissance;
    private String lieu_naissance;
    private String carte_federale;
    private Date date_attestation;
    private Date date_theorique_bb;
    private Date date_theorique_ppla;
    private String numero_bb;
    private Date date_entree;
    private boolean membre_actif;
    private boolean membre_inscrit;
    private int num_civil;
    private int num_qualif;

    public int getNum_membre() {
        return num_membre;
    }

    public void setNum_membre(int num_membre) {
        this.num_membre = num_membre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDate_vm() {
        return date_vm;
    }

    public void setDate_vm(Date date_vm) {
        this.date_vm = date_vm;
    }

    public Date getValidite_vm() {
        return validite_vm;
    }

    public void setValidite_vm(Date validite_vm) {
        this.validite_vm = validite_vm;
    }

    public Date getDate_sep() {
        return date_sep;
    }

    public void setDate_sep(Date date_sep) {
        this.date_sep = date_sep;
    }

    public Date getValidite_sep() {
        return validite_sep;
    }

    public void setValidite_sep(Date validite_sep) {
        this.validite_sep = validite_sep;
    }

    public String getNum_badge() {
        return num_badge;
    }

    public void setNum_badge(String num_badge) {
        this.num_badge = num_badge;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getLieu_naissance() {
        return lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
    }

    public String getCarte_federale() {
        return carte_federale;
    }

    public void setCarte_federale(String carte_federale) {
        this.carte_federale = carte_federale;
    }

    public Date getDate_attestation() {
        return date_attestation;
    }

    public void setDate_attestation(Date date_attestation) {
        this.date_attestation = date_attestation;
    }

    public Date getDate_theorique_bb() {
        return date_theorique_bb;
    }

    public void setDate_theorique_bb(Date date_theorique_bb) {
        this.date_theorique_bb = date_theorique_bb;
    }

    public Date getDate_theorique_ppla() {
        return date_theorique_ppla;
    }

    public void setDate_theorique_ppla(Date date_theorique_ppla) {
        this.date_theorique_ppla = date_theorique_ppla;
    }

    public String getNumero_bb() {
        return numero_bb;
    }

    public void setNumero_bb(String numero_bb) {
        this.numero_bb = numero_bb;
    }

    public Date getDate_entree() {
        return date_entree;
    }

    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }

    public boolean isMembre_actif() {
        return membre_actif;
    }

    public void setMembre_actif(boolean membre_actif) {
        this.membre_actif = membre_actif;
    }

    public boolean isMembre_inscrit() {
        return membre_inscrit;
    }

    public void setMembre_inscrit(boolean membre_inscrit) {
        this.membre_inscrit = membre_inscrit;
    }

    public int getNum_civil() {
        return num_civil;
    }

    public void setNum_civil(int num_civil) {
        this.num_civil = num_civil;
    }

    public int getNum_qualif() {
        return num_qualif;
    }

    public void setNum_qualif(int num_qualif) {
        this.num_qualif = num_qualif;
    }
}
