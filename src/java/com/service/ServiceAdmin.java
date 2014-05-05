/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoAdmin;
import com.domaine.Membre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyril.delanghe
 */
public class ServiceAdmin {
    
    public List<Membre> toutlesAdmins(){
        List<Membre> lmemb = new ArrayList<Membre>();
        
        try{
            ResultSet result = DaoAdmin.toutlesAdmins();
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
        DaoAdmin.close();
        
        return lmemb;
    }
    
}