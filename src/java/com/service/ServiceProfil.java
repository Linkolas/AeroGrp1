/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoProfil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        
        //DaoProfil.close();
        
        return retour ;
    }
    
    public void updateMembre2(Integer prmNumMembre, ArrayList prmMemb) {
        boolean bool = false;
         for(int i = 0; i < prmMemb.size(); i++)
         {
            if(prmMemb.get(i) == "") {
                prmMemb.set(i, null);
                
                
            } else if (i==10) {
                    
                    Calendar cal = new GregorianCalendar();
                    String str = (String) prmMemb.get(10);
                    int year = Integer.parseInt(str.substring(0,4)); 
                    int month = Integer.parseInt(str.substring(5,7));
                    int date = Integer.parseInt(str.substring(8,10));
                    cal.set(year, month-1, date);
                    java.sql.Date newDate = new java.sql.Date(cal.getTime().getTime());
                    prmMemb.set(10, newDate);
                }
            }
           
           for(int i = 0; i < prmMemb.size(); i++) 
           {
               if(prmMemb.get(i) != null) {
                bool = true;
               }
           }
           if(bool == true) {
            DaoProfil.updateMembre2(prmNumMembre, prmMemb);
            //DaoProfil.close();    
           }
           
    }
    
    public void updateUser(String nomUser, String passwdUser) {
        
        if(!"".equals(passwdUser)) {
           String passwdEncode = ServiceConnexion.encode(passwdUser);
           DaoProfil.updateUser (nomUser, passwdEncode);
        }
        //DaoProfil.close(); 
        
    }
       
        
                


        
}
