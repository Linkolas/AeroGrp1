/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import com.domaine.Compte;
import com.domaine.OperationCompte;
import com.service.ServiceAvion;
import com.service.ServiceCompte;
import com.service.ServiceInstructeur;
import com.service.ServiceVol;
import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletAdminCompteUpdate extends HttpServlet {
    
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
            
            // recup de la liste des opérations du membre.
            Compte compte = ServiceCompte.getCompte(numMembre);
            // pour chaque opé, on récupère le numcompte.
            int numOpe;
            Date dateOpe;
            float valOpe;
            String commentOpe;
            
            for(OperationCompte ope : compte.getOperations()) {
                if(ope.getNumSeq() == 0) {
                    numOpe = ope.getNumOperation();
                    
                    dateOpe = ope.getDateOperation();
                    try {
                        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                        dateOpe = formatDate.parse(request.getParameter("DateOpe"+numOpe));
                    } catch (ParseException ex) {
                        Logger.getLogger(ServletAdminVolsUpdate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    valOpe = Float.parseFloat(request.getParameter("ValOpe"+numOpe));
                    commentOpe = request.getParameter("CommentOpe"+numOpe);
                    
                    if(ope.getDateOperation().getTime() != dateOpe.getTime() || valOpe != ope.getValeurOperation() || !commentOpe.equals(ope.getCommentaire())) {
                        
                        ServiceCompte.updCompte(numOpe, dateOpe, valOpe, commentOpe);
                        
                    }
                }
            }
            
            if(!"".equals(request.getParameter("newValOpe"))) {
                
                valOpe = Float.parseFloat(request.getParameter("newValOpe"));
                dateOpe = new Date();
                if(!"".equals(request.getParameter("newDateOpe"))) {
                    try {
                        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
                        dateOpe = formatDate.parse(request.getParameter("newDateOpe"));
                    } catch (ParseException ex) {
                        Logger.getLogger(ServletAdminVolsUpdate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                commentOpe = request.getParameter("newCommentOpe");
                
                ServiceCompte.newCompte(dateOpe, valOpe, commentOpe, numMembre, 0);
            }
            // on récup new vol et insère.
            
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
