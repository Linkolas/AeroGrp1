/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas.pendon
 */
public class DaoInstructeur {
    static Connection laConnexion = null;
    
    static public ResultSet getInstructeurs() {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * "
                          +"FROM instructeurs";
            
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            result = instructionSql.executeQuery();
            
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public static ResultSet getInstructeur(int numinst) {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * FROM instructeurs WHERE Num_Instructeur = ?";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setInt(1, numinst);
            
            result = requete.executeQuery();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public static void close() {
        try {
            laConnexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstructeur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}