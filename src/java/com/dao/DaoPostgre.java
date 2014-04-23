package com.dao;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoPostgre {
    static Connection laConnexion = null;
    static ResultSet result       = null;
    static final String URL    = "jdbc:mysql://90.18.150.223:3306/aerogrp1";
    static final String USER   = "test";
    static final String PASSWD = "test";
    
    static {
        try {
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
        } catch(SQLException se) {
            
        }
    }
    
    static public ResultSet getUser(String user, String password) {
            
        result = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
            
            String query ="SELECT name, nummembre, role FROM users WHERE name= ? AND password= ?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setString(1,user);
            instructionSql.setString(2,password);
            result = instructionSql.executeQuery();
            //Statement instructionSql = laConnexion.createStatement(); 
            //result = instructionSql.executeQuery("SELECT name FROM users WHERE name= 'test'");
            //instructionSql.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        return result;
    }
    
    static public ResultSet getLastResult() {
        return result;
    }
    
    static private Connection getBDD() {
        try {
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
            System.out.println("Connexion effective !");  


            try {
                laConnexion = DriverManager.getConnection(URL, USER, PASSWD);     
            } catch (SQLException e) {
                
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return laConnexion;   
    }
   
    static public ResultSet getInfosUser(String name){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query = "SELECT * FROM users WHERE name=?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setString(1,name);
            result = instructionSql.executeQuery();
            return result;
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    static public ResultSet getMembre2(Integer num_membre){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query;
            query = "SELECT * "
                    +"FROM membres " 
                    +"WHERE num_membre=? ";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1,num_membre);
            result = instructionSql.executeQuery();
            return result;
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    static public ResultSet updateMembre2(Integer num_membre, ArrayList<String> memb){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query;
            query = "UPDATE membre"
                    +"SET nom = ?, prenom = ?, adresse = ?, code_postal = ?, ville = ?, tel = ?, portable = ?, email = ?, profession = ?, date_naissance = ?, lieu_naissance = ?, carte_federal = ?"
                    +"FROM membres WHERE num_membre=?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setString(1,memb.get(1));
            instructionSql.setString(2,memb.get(2));
            instructionSql.setString(3,memb.get(3));
            instructionSql.setString(4,memb.get(4));
            instructionSql.setString(5,memb.get(5));
            instructionSql.setString(6,memb.get(6));
            instructionSql.setString(7,memb.get(7));
            instructionSql.setString(8,memb.get(8));
            instructionSql.setString(9,memb.get(9));
            instructionSql.setString(10,memb.get(10));
            instructionSql.setString(11,memb.get(11));
            instructionSql.setString(12,memb.get(12));
            instructionSql.setInt(13,num_membre);
            result = instructionSql.executeQuery();
            return result;
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    static public ResultSet getComptes(Integer num_membre){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
            }
        catch(Exception e) {
                System.out.println(e.getMessage());
            }  
        
            try {
            String query;
            query = "SELECT * "
                    +" FROM comptes"
                    +" WHERE num_membre =?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1,num_membre);
            result = instructionSql.executeQuery();
            
            }
            
             catch(Exception e) {
                System.out.println(e.getMessage());
            }  
       
        return result;
    }
    
    static public ResultSet getSeqVol(Integer num_membre){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query;
            query = "SELECT * "
                    +"FROM seq_vol " 
                    +"WHERE num_membre=? ";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1,num_membre);
            result = instructionSql.executeQuery();
            return result;
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    static public ResultSet getInstructeur(String name){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query;
            query = "SELECT num_instructeur, nom, prenom, num_civil, taux_instructeur, adresse, code_postal, ville, tel, portable, fax, commentaire, num_badge, email"
                    +"FROM users, instructeurs WHERE instructeurs.num_instructeur=users.nummembre AND name=?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setString(1,name);
            result = instructionSql.executeQuery();
            return result;
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    static public ResultSet getAvion(Integer num_avion){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query;
            query = "SELECT * "
                    +"FROM avions "
                    +"WHERE num_avion=?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1,num_avion);
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
