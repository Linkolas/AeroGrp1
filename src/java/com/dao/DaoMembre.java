/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.domaine.Membre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    
    static public ResultSet toutlesMembres(){
        result = null;
        try {
            laConnexion = AccesBDD.getConnexion();
               try { 
                    String query;
                    query = "SELECT * "
                           +"FROM membres, users "
                           +"WHERE users.numMembre = membres.Num_Membre "
                           +"AND role = 'membre' "; 
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
                   +"FROM membres, users " 
                   +"WHERE users.numMembre = membres.Num_Membre "
                   +"AND nom = ? "
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
    
    static public void setMembre(ArrayList memb , String user_name, String user_password){
        try {
            result = null;
            laConnexion = AccesBDD.getConnexion();
                
            String query;
            query = "INSERT INTO membres (Num_Badge, Nom, Prenom, Adresse, Code_Postal, Ville, Tel, Portable, Email, Profession, Date_Naissance, Lieu_Naissance, Carte_Federale, Date_Entree) "
                   +"VALUES (" 
                   +" ? , "//num_badge
                   +" ? , "//nom
                   +" ? , "//prenom
                   +" ? , "//adresse
                   +" ? , "//cp
                   +" ? , "//ville
                   +" ? , "//tel
                   +" ? , "//portable
                   +" ? , "//email
                   +" ? , "//profession
                   +" ? , "//date_naissance
                   +" ? , "//lieu_naissance
                   +" ? , "//carte_federale
                   +" ? ) ";//date_entree
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            
            for(int i = 0; i < memb.size(); i++) {
                
                if(memb.get(i) != null || !"".equals(memb.get(i))) {
                    if(i == 10){
                    Calendar cal = new GregorianCalendar();
                    String str = (String) memb.get(i);
                    int year = Integer.parseInt(str.substring(0,4)); 
                    int month = Integer.parseInt(str.substring(5,7));
                    int date = Integer.parseInt(str.substring(8,10));
                    cal.set(year, month-1, date);
                    java.sql.Date newdate = new java.sql.Date(cal.getTime().getTime());
                    instructionSql.setDate(i+1,newdate);
                    }
                    else instructionSql.setString(i+1, (String) memb.get(i));
                }
                else instructionSql.setString(i+1,null);
            }
            java.sql.Date date2 = new java.sql.Date(new java.util.Date().getTime());
            instructionSql.setDate(14,date2);
            instructionSql.executeUpdate();
            String query2;
            query2 = "SELECT MAX(Num_Membre) FROM membres";
            PreparedStatement instructionSql2 = laConnexion.prepareStatement(query2);
            result = instructionSql2.executeQuery();
            result.next();
            String nummemb = result.getString("MAX(Num_Membre)");
            
            String query3;
            query3 = "INSERT INTO users (name, password, NumMembre, role)"
                   +"VALUES (" 
                   +" ? , "
                   +" ? , "
                   +" ? , "
                   +" ? )";
            PreparedStatement instructionSql3 = laConnexion.prepareStatement(query3);
            instructionSql3.setString(1,user_name);
            instructionSql3.setString(2,user_password);
            instructionSql3.setString(3,nummemb);
            instructionSql3.setString(4,"membre");
            instructionSql3.executeUpdate();
            }
        catch(Exception e) {
                System.out.println(e);
            }
    }
    
    public static void close() {
        try {
            result.close();
            laConnexion.close();
        } catch (SQLException ex) {
            
        }
    }



}
    
    
    
    
    
