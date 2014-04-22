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
    
   static public ResultSet updateMembre2(Integer num_membre, ArrayList<String> memb){
        result = null;
        try {
            laConnexion = AccesBDD.getConnexion();
            ArrayList nom = new ArrayList();
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
            
            String query = "";
            String set = "";
            for(int i = 0; i < memb.size(); i++) {
                
                if(!"".equals(memb.get(i))) {
                set +=",";
                query += nom.get(i) + " = ? " + set;
                System.out.println(query); 
                
               }
            }
            //query = "UPDATE membre"
                    //+"SET nom = ?, prenom = ?, adresse = ?, code_postal = ?, ville = ?, tel = ?, portable = ?, email = ?, profession = ?, date_naissance = ?, lieu_naissance = ?, carte_federal = ?"
                  //  +"FROM membres WHERE num_membre=?";
            //PreparedStatement instructionSql = laConnexion.prepareStatement(query);
            //System.out.println(memb);
           /* for(int i = 0; i < memb.size(); i++)
            {
                if(memb.get(i) != null && !"".equals(memb.get(i)) ) {
                    System.out.println("donnée à l'indice " + i + " = " + memb.get(i));
                }
            } /* 
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
            instructionSql.setInt(13,num_membre);*/
            //result = instructionSql.executeQuery();
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
