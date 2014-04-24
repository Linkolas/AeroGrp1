/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import static com.dao.DaoMembre.result;
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
    static ResultSet result       = null;
    
    static public ResultSet getInstructeurs() {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * "
                         + "FROM membres, users, taux_instructeur "
                         + "WHERE membre.Num_Membre = users.numMembre "
                         + "AND users.numMembre = taux_instructeur.Num_Membre";
            
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
            
            String query = "SELECT * "
                         + "FROM membres, users, taux_instructeurs "
                         + "WHERE membres.Num_Membre = users.numMembre "
                         + "AND users.numMembre = taux_instructeurs.Num_Membre "
                         + "AND membres.Num_Membre = ?";
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
