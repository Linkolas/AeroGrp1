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
public class DaoVol {
    static Connection laConnexion = null;
    
    static public ResultSet getVols(int membre) {
        return getVols(membre, -1);
    }
    
    static public ResultSet getVols(int membre, int annee) {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * "
                          +"FROM seq_vol " 
                          +"WHERE num_membre = ?";
            if(annee != -1) query += " AND YEAR(date_seq_vol) = ?";
            
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1, membre);
            if(annee != -1) instructionSql.setInt(2, annee);
            result = instructionSql.executeQuery();
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    public static ResultSet getSeqVol(int numseq) {
        ResultSet result = null;
        
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "SELECT * FROM seq_vol WHERE Num_Seq = ?";
            PreparedStatement requete = laConnexion.prepareStatement(query);
            requete.setInt(1, numseq);
            
            result = requete.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    static public void deleteVol(int num) {
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "DELETE FROM seq_vol WHERE Num_Seq = ?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1, num);
            
            instructionSql.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
 
    }
    
    public static void newVol(Date date, int heures, int heuresForfait, float prixSpe, float tauxAvion, float reduc, String motif, float tauxInstr, int numMembre, int numInstr, int numAvion) {
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "INSERT INTO seq_vol (Date_Seq_Vol, Temps, Heures_Forfait, Prix_Special, Taux, Reduction_Semaine, Motif, Taux_Instructeur, Num_Membre, Num_Instructeur, Num_Avion) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setDate(1, new java.sql.Date(date.getTime()));
            instructionSql.setInt(2, heures);
            instructionSql.setInt(3, heuresForfait);
            instructionSql.setFloat(4, prixSpe);
            instructionSql.setFloat(5, tauxAvion);
            instructionSql.setFloat(6, reduc);
            instructionSql.setString(7, motif);
            instructionSql.setFloat(8, tauxInstr);
            instructionSql.setInt(9, numMembre);
            instructionSql.setInt(10, numInstr);
            instructionSql.setInt(11, numAvion);
            
            instructionSql.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void updVol(int numSeq, Date date, int heures, int heuresForfait, float prixSpe, float tauxAvion, float reduc, String motif, float tauxInstr, int numMembre, int numInstr, int numAvion) {
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query = "UPDATE seq_vol SET Date_Seq_Vol = ? , Temps = ? , Heures_Forfait = ? , Prix_Special = ? , Taux = ? , Reduction_Semaine = ? , Motif = ? , Taux_Instructeur = ? , Num_Membre = ? , Num_Instructeur = ? , Num_Avion = ? ";
            query += "WHERE Num_Seq = ?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setDate(1, new java.sql.Date(date.getTime()));
            instructionSql.setInt(2, heures);
            instructionSql.setInt(3, heuresForfait);
            instructionSql.setFloat(4, prixSpe);
            instructionSql.setFloat(5, tauxAvion);
            instructionSql.setFloat(6, reduc);
            instructionSql.setString(7, motif);
            instructionSql.setFloat(8, tauxInstr);
            instructionSql.setInt(9, numMembre);
            instructionSql.setInt(10, numInstr);
            instructionSql.setInt(11, numAvion);
            instructionSql.setInt(12, numSeq);
            
            instructionSql.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void close() {
        try {
            laConnexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
