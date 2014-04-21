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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author quentin.vauthier
 */
public class DaoProfil {
    
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
    
    
    static public ResultSet getMembreProfils(Integer num_membre){
        result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query;
            query = "SELECT num_badge, nom, prenom, adresse, code_postal, ville, tel, portable, email, profession, date_naissance, lieu_naissance, carte_federale "
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
    
    static public ResultSet updateMembre2(Integer num_membre, Map memb){
        result = null;
        int i=1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");
            laConnexion = DriverManager.getConnection(URL, USER, PASSWD);
                
            String query;
            query = "UPDATE membre"
                    +"SET nom = ?, prenom = ?, adresse = ?, code_postal = ?, ville = ?, tel = ?, portable = ?, email = ?, profession = ?, date_naissance = ?, lieu_naissance = ?, carte_federal = ?"
                    +"FROM membres WHERE num_membre=?";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            for(Iterator it = memb.entrySet().iterator(); it.hasNext();) {
                Entry<Integer, String> entry = (Entry<Integer, String>) it.next();  
                //Integer cle = entry.getKey();
                //String valeur = entry.getValue();
                //System.out.println(memb.get(i));
                instructionSql.set(i, (String) memb.get(i)); //Boucle pas possible
                i +=1;
            }

            instructionSql.setInt(13,num_membre);
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
            //result.close();
            laConnexion.close();
        } catch (SQLException ex) {
            
        }
    }
    
    
}
