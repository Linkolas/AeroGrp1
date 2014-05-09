/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import static com.dao.DaoPostgre.result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author quentin.vauthier
 */
public class DaoProfil {
    
    static Connection laConnexion = null;
    
    static public ResultSet getMembreProfils(Integer num_membre){
        result = null;
        try {
            laConnexion = AccesBDD.getConnexion();
                
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
    
    static public ResultSet getMembreLogin(Integer nummembre){
        result = null;
        try {
            laConnexion = AccesBDD.getConnexion();
            
            String query;
            query = "SELECT name "
                    +"FROM users " 
                    +"WHERE nummembre=? ";
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setInt(1,nummembre);
            result = instructionSql.executeQuery();
            }
        catch(Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
   static public void updateMembre2(Integer num_membre, ArrayList memb){
       
        try {
            laConnexion = AccesBDD.getConnexion();
            ArrayList nom = new ArrayList();
            nom.add("num_badge");
            nom.add("nom");
            nom.add("prenom");
            nom.add("adresse");
            nom.add("code_postal");
            nom.add("ville");
            nom.add("tel");
            nom.add("portable");
            nom.add("email");
            nom.add("profession");
            nom.add("date_naissance");
            nom.add("lieu_naissance");
            nom.add("carte_federal");
            
            String query = "UPDATE membres SET ";
            String set = "";
            for(int i = 0; i < memb.size()-1; i++) {
                
                if(memb.get(i) != null) {
                    if(!"".equals(set)) {    
                        set +=", ";
                    }
                set += nom.get(i) + " = ? ";
               }
            }
            query += set;
            query += "WHERE Num_Membre = ?";
            System.out.println(query); 
            int index =1;
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            for(int i = 0; i < memb.size()-1; i++)
            {
                if(memb.get(i) != null) {
                    if (memb.get(i).getClass() == String.class) {
                        instructionSql.setString(index, (String) memb.get(i));
                    } else {
                        instructionSql.setDate(index, (java.sql.Date) memb.get(i));
                    }
                    index +=1;
                }
            }
            
            instructionSql.setInt(index, num_membre);
            instructionSql.executeUpdate();
            
            }
        catch(Exception e) {
                System.out.println(e);
            }
    }
   
    static public void updateUser (String nomUser, String passwdUser) {
       try {
           
           
           
           String query = "UPDATE users SET password = ? WHERE name = ?" ;
            PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            instructionSql.setString(1,passwdUser);
            instructionSql.setString(2,nomUser);
            instructionSql.executeUpdate();
            //098f6bcd4621d373cade4e832627b4f6
           
           
       } catch(Exception e) {
                System.out.println(e);
            }   
       
   }
    
        public static void close() {
        try {
            //result.close();
            laConnexion.close();
        } catch (SQLException ex) {
            
        }
    }
    
    
}
