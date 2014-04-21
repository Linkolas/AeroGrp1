/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoProfil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 *
 * @author quentin.vauthier
 */
public class ServiceProfil {
    
    public String[] getMembreProfil(Integer prmNumMembre) throws SQLException {
        
        String[] retour = new String[40];
        
        try {
            ResultSet result = DaoProfil.getMembreProfils(prmNumMembre);
        
            result.next();
            int i = 1;
            while(i < 32) {   
                retour[i] = result.getString(i);
                i += 1;
            }
            
            
        } catch (SQLException se) {
               //retour.add(1,"TEST !!");
               //retour.add(2,"PASS !!");
        }
        
        DaoProfil.close();
        
        return retour ;
    }
    
    public void updateMembre2(Integer prmNumMembre, Map prmMemb) {
        
            ResultSet result = DaoProfil.updateMembre2(prmNumMembre, prmMemb);
            
            DaoProfil.close();
    }
      
    
}
