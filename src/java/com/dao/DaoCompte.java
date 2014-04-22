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
public class DaoCompte {
    static Connection laConnexion = null;
    
    public static ResultSet getCompte(int nummembre) {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * FROM comptes WHERE Num_Membre = ?";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setInt(1, nummembre);
            
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
            Logger.getLogger(DaoCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
