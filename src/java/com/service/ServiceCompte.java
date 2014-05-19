/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoCompte;
import com.dao.DaoVol;
import com.domaine.Compte;
import com.domaine.OperationCompte;
import com.domaine.Vol;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas.pendon
 */
public class ServiceCompte {
    
    static public Compte getCompte(int nummem) {
        Compte compte = new Compte();
        
        try {
            
            ResultSet result = DaoCompte.getCompte(nummem);
            while(result.next()) {
                OperationCompte ope = new OperationCompte();
                ope.setDateOperation(result.getDate("date_operation"));
                ope.setCommentaire(result.getString("commentaire"));
                ope.setAutocreation(result.getBoolean("autocreation"));
                ope.setNumOperation(result.getInt("num_compte"));
                ope.setNumSeq(result.getInt("num_seq"));
                ope.setValeurOperation(result.getFloat("operation_compte"));
                compte.addOperation(ope);
            }
            DaoCompte.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return compte;
    }
    
    static public void newCompte(Date date, float valeur, String comment, int membre, int sequence) {
        DaoCompte.newCompte(date, valeur, comment, membre, sequence);
    }
    
    static public void updCompte(int numCompte, Date date, float valeur, String comment, int membre, int sequence) {
        DaoCompte.updCompte(numCompte, date, valeur, comment, membre, sequence);
    }
    
    static public void updCompte(int numCompte, Date date, float valeur, String comment) {
        DaoCompte.updCompte(numCompte, date, valeur, comment);
    }
    
    static public int getNumCompteSeq(int numseq) {
        int numOpe = -1;
        
        try {
            
            ResultSet result = DaoCompte.getCompteSeq(numseq);
            if(result.next()) {
                numOpe = result.getInt("Num_Compte");
            }
            DaoCompte.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return numOpe;
    }
    
    static public void delCompteSeq(int numseq) {
        DaoCompte.delCompteVol(numseq);
    }
}
