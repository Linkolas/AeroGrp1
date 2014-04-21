package com.dao;

import javax.swing.*;
import java.sql.*;

public class Derby {
  static private Connection getBDD() {
    Connection laConnexion=null;
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      System.out.println("Driver O.K.");
      String url = "jdbc:derby:Z:\\derby\\prgrmm\\base_idologis";
      Connection conn = DriverManager.getConnection(url);
      System.out.println("Connexion effective !");  

      
      try {
          laConnexion = DriverManager.getConnection(url);
         /* int i = 0;
          while (rs.next()){
              System.out.println("Code Postal " + rs.getString(2) );
              System.out.println("Nom " + rs.getString(3));
              //ou rs.getString("nom");
              i++;
            }*/
           return laConnexion;       
        }
            catch (SQLException e) {
                //e.printStackTrace();
        } 
        
    }   
    catch (Exception e) {
            e.printStackTrace();
        }
  
  
     return laConnexion;   
    }
    
    static public void ajouterSecteur(String paramCode ,String paramLibelle)
    {
        try {
        PreparedStatement vInstructionSql = getBDD().prepareStatement("INSERT INTO Secteur(code,libelle) VALUES(?,?)");
         vInstructionSql.setString( 1, paramCode );
         vInstructionSql.setString( 2, paramLibelle );

          vInstructionSql.executeUpdate();
          vInstructionSql.close();
        }
        catch (SQLException e) {
            if(e.getErrorCode() == 30000)
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Ce libellé ou ce code existe déjà, Kupo.", "Erreur de saisie",JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(),"Erreur SQL : " + e.getErrorCode(), "Erreur imporbable",JOptionPane.ERROR_MESSAGE);
                } 
            
        }
        
    }
}   