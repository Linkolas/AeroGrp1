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
public class DaoVol {
    static Connection laConnexion = null;
    
    static public ResultSet getVols(int membre) {
        return getVols(membre, -1);
    }
    
    static public ResultSet getVols(int membre, int annee) {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query;
            query = "SELECT * "
                   +"FROM seq_vol " 
                   +"WHERE num_membre = ?";
            if(annee != -1) query += " AND YEAR(date_seq_vol) = ?";
            
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1, membre);
            if(annee != -1) instructionSql.setInt(2, annee);
            result = instructionSql.executeQuery();
        } catch(Exception e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public static void close() {
        try {
            laConnexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
