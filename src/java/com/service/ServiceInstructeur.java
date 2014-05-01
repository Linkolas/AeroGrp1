/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.DaoInstructeur;
import com.domaine.Instructeur;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicolas.pendon
 */
public class ServiceInstructeur {
    
    static public List<Instructeur> getListeInstructeurs() {
        //System.out.println("/! MEMBRE = " + membre);
        List<Instructeur> instructeurs = new ArrayList<Instructeur>();
        
        try {
            ResultSet result = DaoInstructeur.getInstructeurs();
            while(result.next()) {
                Instructeur instructeur = new Instructeur();
                instructeur.setNumInstructeur(result.getInt("num_membre"));
                instructeur.setNom(result.getString("nom"));
                instructeur.setPrenom(result.getString("prenom"));
                instructeur.setNumCivilite(result.getInt("num_civil"));
                instructeur.setTaux(result.getFloat("taux_instructeur"));
                instructeur.setAdresse(result.getString("adresse"));
                instructeur.setCodePostal(result.getString("code_postal"));
                instructeur.setVille(result.getString("ville"));
                instructeur.setTelFixe(result.getString("tel"));
                instructeur.setTelPortable(result.getString("portable"));
                instructeur.setTelFax(result.getString("fax"));
                instructeur.setCommentaire(result.getString("commentaire"));
                instructeur.setNumBadge(result.getString("num_badge"));
                instructeur.setEmail(result.getString("email"));
                instructeurs.add(instructeur);
            }
            
            DaoInstructeur.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstructeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return instructeurs;
    }
    
    static public Instructeur getInstructeur(int numinst) {
        Instructeur instructeur = new Instructeur();
        
        try {
            
            ResultSet result = DaoInstructeur.getInstructeur(numinst);
            result.next();
            
            instructeur.setNumInstructeur(result.getInt("num_membre"));
            instructeur.setNom(result.getString("nom"));
            instructeur.setPrenom(result.getString("prenom"));
            instructeur.setNumCivilite(result.getInt("num_civil"));
            instructeur.setTaux(result.getFloat("taux_instructeur"));
            instructeur.setAdresse(result.getString("adresse"));
            instructeur.setCodePostal(result.getString("code_postal"));
            instructeur.setVille(result.getString("ville"));
            instructeur.setTelFixe(result.getString("tel"));
            instructeur.setTelPortable(result.getString("portable"));
            instructeur.setTelFax(result.getString("fax"));
            instructeur.setCommentaire(result.getString("commentaire"));
            instructeur.setNumBadge(result.getString("num_badge"));
            instructeur.setEmail(result.getString("email"));
            
            DaoInstructeur.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceInstructeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return instructeur;
    }
}
