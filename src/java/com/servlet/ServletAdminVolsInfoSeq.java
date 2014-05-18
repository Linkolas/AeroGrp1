/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import com.domaine.Avion;
import com.domaine.Instructeur;
import com.domaine.Vol;
import com.service.ServiceAvion;
import com.service.ServiceInstructeur;
import com.service.ServiceVol;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
public class ServletAdminVolsInfoSeq extends HttpServlet {
    
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
        if(!"admin".equals((String) session.getAttribute("role"))) {
            vue = "/includes/connexion.jsp";
            
        } else {
            vue = "/includes/admin/vol_informations.jsp";
            String strNum = request.getParameter("membre");
            String numseq = request.getParameter("numseq");
            if(numseq != null) {
                Vol vol = ServiceVol.getVol(Integer.parseInt(numseq));
                Avion avion = ServiceAvion.getAvion(vol.getNumAvion());
                Instructeur instructeur = null;
                if(vol.getNumInstructeur() >= 0) {
                    instructeur = ServiceInstructeur.getInstructeur(vol.getNumInstructeur());
                }
                List<Instructeur> ins = ServiceInstructeur.getListeInstructeurs();
                List<Avion> avions = ServiceAvion.getListeAvions();
                
                request.setAttribute("vol", vol);
                request.setAttribute("avion", avion);
                if(vol.getNumInstructeur() != 0) {
                    request.setAttribute("instructeur", instructeur);
                }
                
                request.setAttribute("avions", avions);
                request.setAttribute("instructeurs", ins);
                request.setAttribute("membre", strNum);
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
