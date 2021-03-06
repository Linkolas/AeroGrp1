/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import com.service.ServiceAvion;
import com.service.ServiceInstructeur;
import com.service.ServiceProfil;
import com.service.ServiceVol;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
public class ServletAdminVolsUpdate extends HttpServlet {
    
    String vue;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //On vérifie que l'utilisateur est connecté
        HttpSession session = request.getSession();
        if(!"admin".equals((String) session.getAttribute("role")) ){
            vue = "/ErreurConnexion";
        }
        else{
            vue = "/Membres";
            int numMembre = Integer.parseInt(request.getParameter("membre"));
            int numVol = Integer.parseInt(request.getParameter("numSeqVol"));
            Date date = new Date();
            try {
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                date = formatDate.parse(request.getParameter("date"));
            } catch (ParseException ex) {
                Logger.getLogger(ServletAdminVolsUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            int tempsVol = Integer.parseInt(request.getParameter("tempsVol"));
            int tempsForfait = Integer.parseInt(request.getParameter("tempsForfait"));
            boolean isPrixSpecial = (!"-1".equals(request.getParameter("isPrixSpecial")));
            float prixSpecial = (isPrixSpecial ? Float.parseFloat(request.getParameter("prixSpecial")) : -1);
            String motif = request.getParameter("motif");
            int instructeur = Integer.parseInt(request.getParameter("instructeur"));
            int avion = Integer.parseInt(request.getParameter("avion"));
            
            // "Auto" -> tauxInstructeur, tauxAvion, reducSemaine
            float tauxInstructeur = 0;
            if(instructeur != -1) {
                if("Auto".equals(request.getParameter("tauxInstructeur"))) {
                    tauxInstructeur = ServiceInstructeur.getInstructeur(instructeur).getTaux();
                } else {
                    tauxInstructeur = Float.parseFloat(request.getParameter("tauxInstructeur"));
                }
            }
            float tauxAvion = 0;
            if("Auto".equals(request.getParameter("tauxAvion"))) {
                tauxAvion = ServiceAvion.getAvion(avion).getTaux();
                System.out.println("taux d'avion automatique :"+tauxAvion);
            } else {
                tauxAvion = Float.parseFloat(request.getParameter("tauxAvion"));
            }
            float reducSemaine = 0;
            if("Auto".equals(request.getParameter("reducSemaine"))) {
                reducSemaine = ServiceAvion.getAvion(avion).getReduction();
                System.out.println("reduc semaine automatique :"+tauxAvion);
            } else {
                reducSemaine = Float.parseFloat(request.getParameter("reducSemaine"));
            }
            
            
            if(numVol == -1) {
                ServiceVol.newVol(date, tempsVol, tempsForfait, prixSpecial, tauxAvion, reducSemaine, motif, tauxInstructeur, numMembre, instructeur, avion);
            } else {
                ServiceVol.updVol(numVol, date, tempsVol, tempsForfait, prixSpecial, tauxAvion, reducSemaine, motif, tauxInstructeur, numMembre, instructeur, avion);
            }
        }
        
        this.getServletContext().getRequestDispatcher(vue).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
