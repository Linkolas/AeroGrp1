/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoVol;
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
                vols.add(vol);
            }
            
            DaoVol.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVol.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vols;
    }
    
}
