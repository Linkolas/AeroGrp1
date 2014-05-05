/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas.pendon
 */
public class DaoAvion {
    static Connection laConnexion = null;
    
    static public ResultSet getAvions() {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * "
                          +"FROM avions";
            
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            result = instructionSql.executeQuery();
            
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public static ResultSet getAvion(int numavion) {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * FROM avions WHERE Num_Avion = ?";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setInt(1, numavion);
            
            result = requete.executeQuery();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    static public void updateAvion(String prmImmat, ArrayList prmAvion){
       
        try {
            laConnexion = AccesBDD.getConnexion();
            ArrayList nom = new ArrayList();
            nom.add("Type_Avion");
            nom.add("Taux");
            nom.add("Reduction_semaine");
            
            
            String query = "UPDATE avions SET ";
            String set = "";
            for(int i = 0; i < prmAvion.size()-1; i++) {
                
                if(prmAvion.get(i) != null) {
                    if(!"".equals(set)) {    
                        set +=", ";
                    }
                set += nom.get(i) + " = ? ";
               }
            }
            query += set;
            query += "WHERE Immatriculation = ?";
            System.out.println(query); 
            int index =1;
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            for(int i = 0; i < prmAvion.size()-1; i++)
            {
                if(prmAvion.get(i) != null) {
                    if (prmAvion.get(i).getClass() == String.class) {
                        instructionSql.setString(index, (String) prmAvion.get(i));
                    }
                    index +=1;
                }
            }
            
            instructionSql.setString(index, prmImmat);
            instructionSql.executeUpdate();
            
            }
        catch(Exception e) {
                System.out.println(e);
            }
    }
    
    
    
    public static void close() {
        try {
            laConnexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
