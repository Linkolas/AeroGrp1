/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cyril.delanghe
 */
public class DaoMembre {
    
    static Connection laConnexion = null;
    static ResultSet result       = null;
    static final String URL    = "jdbc:mysql://90.18.150.223:3306/aerogrp1";
    static final String USER   = "test";
    static final String PASSWD = "test";
    
    static {
        try {
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
        } 
        catch(SQLException se) {
            
        }
    }
    
    static public ResultSet toutlesMembres(){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
               try { 
                    String query;
                    query = "SELECT * "
                           +"FROM membres "; 
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
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
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
    
    
    
    
    
