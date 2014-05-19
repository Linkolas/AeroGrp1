/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
            
            String query = "SELECT * FROM comptes WHERE Num_Membre = ? ORDER BY Date_Operation DESC, Num_Compte DESC;";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setInt(1, nummembre);
            
            result = requete.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public static void newCompte(Date date, float valeur, String comment, int membre, int sequence) {
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "INSERT INTO comptes (Date_Operation, Operation_Compte, Commentaire, Num_Membre, Num_Seq) VALUES ( ? , ? , ? , ? , ? );";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setDate(1, new java.sql.Date(date.getTime()));
            requete.setFloat(2, valeur);
            requete.setString(3, comment);
            requete.setInt(4, membre);
            requete.setInt(5, sequence);
            
            requete.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void updCompte(int numCompte, Date date, float valeur, String comment, int membre, int sequence) {
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "UPDATE comptes SET Date_Operation = ? , Operation_Compte = ? , Commentaire = ? , Num_Membre = ? , Num_Seq = ? WHERE Num_Compte = ?;";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setDate(1, new java.sql.Date(date.getTime()));
            requete.setFloat(2, valeur);
            requete.setString(3, comment);
            requete.setInt(4, membre);
            requete.setInt(5, sequence);
            requete.setInt(6, numCompte);
            
            requete.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void updCompte(int numCompte, Date date, float valeur, String comment) {
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "UPDATE comptes SET Date_Operation = ? , Operation_Compte = ? , Commentaire = ? WHERE Num_Compte = ?;";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setDate(1, new java.sql.Date(date.getTime()));
            requete.setFloat(2, valeur);
            requete.setString(3, comment);
            requete.setInt(4, numCompte);
            
            requete.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void close() {
        try {
            laConnexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCompte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
