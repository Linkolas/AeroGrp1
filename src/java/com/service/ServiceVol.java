/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoVol;
import com.domaine.Vol;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas.pendon
 */
public class ServiceVol {
    
    static public List<Vol> getListeVols(int membre) {
        //System.out.println("/! ANNEE NON PASSEE EN PARAMETRE");
        return getListeVols(membre, -1);
    }
    
    static public List<Vol> getListeVols(int membre, int annee) {
        //System.out.println("/! MEMBRE = " + membre);
        List<Vol> vols = new ArrayList<Vol>();
        
        try {
            ResultSet result = DaoVol.getVols(membre, annee);
            while(result.next()) {
                Vol vol = new Vol();
                vol.setNum(result.getInt("num_seq"));
                vol.setDate(result.getDate("date_seq_vol"));
                vol.setTemps(result.getInt("temps"));
                vol.setHeuresForfait(result.getInt("heures_forfait"));
                vol.setPrixSpecial(result.getFloat("prix_special"));
                vol.setTaux(result.getFloat("taux"));
                vol.setReductionSemaine(result.getFloat("reduction_semaine"));
                vol.setMotif(result.getString("motif"));
                vol.setTauxInstructeur(result.getFloat("taux_instructeur"));
                vol.setForfaitInitiation(result.getInt("forfait_initiation"));
                vol.setNumMembre(result.getInt("num_membre"));
                vol.setNumInstructeur(result.getInt("num_instructeur"));
                vol.setNumAvion(result.getInt("num_avion"));
                vols.add(vol);
            }
            
            DaoVol.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vols;
    }
    
    static public Vol getVol(int numseq) {
        Vol vol = new Vol();
        
        try {
            
            ResultSet result = DaoVol.getSeqVol(numseq);
            if(result.next()) {

                vol.setNum(result.getInt("num_seq"));
                vol.setDate(result.getDate("date_seq_vol"));
                vol.setTemps(result.getInt("temps"));
                vol.setHeuresForfait(result.getInt("heures_forfait"));
                vol.setPrixSpecial(result.getFloat("prix_special"));
                vol.setTaux(result.getFloat("taux"));
                vol.setReductionSemaine(result.getFloat("reduction_semaine"));
                vol.setMotif(result.getString("motif"));
                vol.setTauxInstructeur(result.getFloat("taux_instructeur"));
                vol.setForfaitInitiation(result.getInt("forfait_initiation"));
                vol.setNumMembre(result.getInt("num_membre"));
                vol.setNumInstructeur(result.getInt("num_instructeur"));
                vol.setNumAvion(result.getInt("num_avion"));

            }
            
            DaoVol.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vol;
    }
    
    static public void deleteVol(int num) {
        
        DaoVol.deleteVol(num);
        DaoVol.close();
    }
    
    static public void newVol(Date date, int heures, int heuresForfait, float prixSpe, float tauxAvion, float reduc, String motif, float tauxInstr, int numMembre, int numInstr, int numAvion) {
        
        DaoVol.newVol(date, heures, heuresForfait, prixSpe, tauxAvion, reduc, motif, tauxInstr, numMembre, numInstr, numAvion);
    }
    
    static public void updVol(int numSeq, Date date, int heures, int heuresForfait, float prixSpe, float tauxAvion, float reduc, String motif, float tauxInstr, int numMembre, int numInstr, int numAvion) {
        
        DaoVol.updVol(numSeq, date, heures, heuresForfait, prixSpe, tauxAvion, reduc, motif, tauxInstr, numMembre, numInstr, numAvion);
    }
}
