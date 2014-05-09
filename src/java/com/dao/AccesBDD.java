/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import static com.dao.AccesBDD.laConnexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nicolas.pendon
 */
public class AccesBDD {
    static Connection laConnexion = null;
    static ResultSet result       = null;
    static final String URL    = "jdbc:postgresql://192.168.12.101:5432/aero2";
    static final String USER   = "michel";
    static final String PASSWD = "michel42";
    
    static public Connection getConnexion() {
        laConnexion = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
        } catch (ClassNotFoundException ex) {
            System.out.println("/! Impossible de charger le pilote !");
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : "+ ex.getMessage());
        }
        
        return laConnexion;
    }
    
    public static void close() {
        try {
            result.close();
            laConnexion.close();
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : "+ ex.getMessage());
        }
    }
}
