/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoAvion;
import com.dao.DaoForfait;
import com.domaine.Avion;
import com.domaine.Forfait;
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
public class ServiceAvion {
    
    static public List<Avion> getListeAvions() {
        //System.out.println("/! MEMBRE = " + membre);
        List<Avion> avions = new ArrayList<Avion>();
        
        try {
            ResultSet result = DaoAvion.getAvions();
            while(result.next()) {
                Avion avion = new Avion();
                avion.setNum_avion(result.getInt("num_avion"));
                avion.setType_avion(result.getString("type_avion"));
                avion.setTaux(result.getFloat("taux"));
                avion.setReduction(result.getFloat("reduction_semaine"));
                avion.setImmatriculation(result.getString("immatriculation"));
                
                ResultSet rsForfaits = DaoForfait.getForfaits(result.getString("type_avion"));
                ArrayList<Forfait> forfaits = new ArrayList<Forfait>();
                while(rsForfaits.next()) {
                    Forfait forf = new Forfait();
                    forf.setTypeAvion(rsForfaits.getString("type_avion"));
                    forf.setPrix(rsForfaits.getFloat("prix"));
                    forf.setNumero(rsForfaits.getInt("numero"));
                    forf.setHeures(rsForfaits.getInt("heures_forfait"));
                    forfaits.add(forf);
                }
                
                avion.setForfaits(forfaits);
                avions.add(avion);
            }
            
            DaoAvion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return avions;
    }
    static public Avion getAvion(int numavion) {
        Avion avion = new Avion();
        
        try {
            
            ResultSet result = DaoAvion.getAvion(numavion);
            result.next();
            
            avion.setNum_avion(result.getInt("num_avion"));
            avion.setType_avion(result.getString("type_avion"));
            avion.setTaux(result.getFloat("taux"));
            
            ResultSet rsForfaits = DaoForfait.getForfaits(result.getString("type_avion"));
            ArrayList<Forfait> forfaits = new ArrayList<Forfait>();
            while(rsForfaits.next()) {
                Forfait forf = new Forfait();
                forf.setTypeAvion(rsForfaits.getString("type_avion"));
                forf.setPrix(rsForfaits.getFloat("prix"));
                forf.setNumero(rsForfaits.getInt("numero"));
                forf.setHeures(rsForfaits.getInt("heures_forfait"));
                forfaits.add(forf);
            }
            
            avion.setForfaits(forfaits);
            
            avion.setReduction(result.getFloat("reduction_semaine"));
            avion.setImmatriculation(result.getString("immatriculation"));
            
            DaoAvion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return avion;
    }
}
