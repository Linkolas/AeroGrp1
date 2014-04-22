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
                ope.setDateOperation(result.getDate("date_opération"));
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
}
