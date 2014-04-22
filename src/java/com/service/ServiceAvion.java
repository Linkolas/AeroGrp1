/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoAvion;
import com.domaine.Avion;
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
                avion.setForfait1(result.getFloat("forfait1"));
                avion.setForfait2(result.getFloat("forfait2"));
                avion.setForfait3(result.getFloat("forfait3"));
                avion.setHeuresForfait1(result.getInt("heures_forfait1"));
                avion.setHeuresForfait2(result.getInt("heures_forfait2"));
                avion.setHeuresForfait3(result.getInt("heures_forfait3"));
                avion.setReduction(result.getFloat("reduction_semaine"));
                avion.setImmatriculation(result.getString("immatriculation"));
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
            avion.setForfait1(result.getFloat("forfait1"));
            avion.setForfait2(result.getFloat("forfait2"));
            avion.setForfait3(result.getFloat("forfait3"));
            avion.setHeuresForfait1(result.getInt("heures_forfait1"));
            avion.setHeuresForfait2(result.getInt("heures_forfait2"));
            avion.setHeuresForfait3(result.getInt("heures_forfait3"));
            avion.setReduction(result.getFloat("reduction_semaine"));
            avion.setImmatriculation(result.getString("immatriculation"));
            
            DaoAvion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return avion;
    }
}
