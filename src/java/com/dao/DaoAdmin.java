/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cyril.delanghe
 */
public class DaoAdmin {
    
    static Connection laConnexion = null;
    static ResultSet result       = null;
    
    static public ResultSet toutlesAdmins(){
        result = null;
        try {
            laConnexion = AccesBDD.getConnexion();
               try { 
                    String query;
                    query = "SELECT * "
                           +"FROM membres, users "
                           +"WHERE users.numMembre = membres.Num_Membre "
                           +"AND role = 'admin' "; 
                    PreparedStatement instructionSql = laConnexion.prepareStatement(query);
                    result = instructionSql.executeQuery();
                    return result;
               }
               catch(Exception e) {
                       System.out.println(e);
               }
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    static public ResultSet getMembre(String nom_membre, String pre_membre){
        result = null;
        try {
            laConnexion = AccesBDD.getConnexion();
                
            String query;
            query = "SELECT * "
                   +"FROM membres " 
                   +"WHERE nom = ? "
                   +"AND prenom = ? ";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setString(1,nom_membre);
            instructionSql.setString(1,pre_membre);
            result = instructionSql.executeQuery();
            return result;
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    public static void close() {
        try {
            result.close();
            laConnexion.close();
        } catch (SQLException ex) {
            
        }
    }



}
    
    
    
    