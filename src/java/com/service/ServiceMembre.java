/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoMembre;
import com.domaine.Membre;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyril.delanghe
 */
public class ServiceMembre {
    
    public List<Membre> toutlesMembres(){
        List<Membre> lmemb = new ArrayList<Membre>();
        
        try{
            ResultSet result = DaoMembre.toutlesMembres();
            while(result.next()) {   
                Membre memb = new Membre();
                memb.setNum_membre(result.getInt("num_membre"));
                memb.setNom(result.getString("nom"));
                memb.setPrenom(result.getString("prenom"));
                lmemb.add(memb);
            }
        }
        catch(SQLException se){
        }
        DaoMembre.close();
        
        return lmemb;
    }
    
    public List<Membre> toutlesInstructeurs(){
        List<Membre> lmemb = new ArrayList<Membre>();
        
        try{
            ResultSet result = DaoMembre.toutlesInstructeurs();
            while(result.next()) {   
                Membre memb = new Membre();
                memb.setNum_membre(result.getInt("num_membre"));
                memb.setNom(result.getString("nom"));
                memb.setPrenom(result.getString("prenom"));
                lmemb.add(memb);
            }
        }
        catch(SQLException se){
        }
        DaoMembre.close();
        
        return lmemb;
    }
    
}
