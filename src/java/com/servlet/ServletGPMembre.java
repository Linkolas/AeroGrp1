/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.service.ServiceProfil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cyril.delanghe
 */
public class ServletGPMembre extends HttpServlet {


    String vue;
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //On vérifie que l'utilisateur est connecté
        HttpSession session = request.getSession();
        if(!"admin".equals((String) session.getAttribute("role")) ){
            vue = "/ErreurConnexion";
        }
        else{
            try {
                vue = "/includes/form_disabled.jsp";
                String numMembre = request.getParameter("membre");
                ServiceProfil conn = new ServiceProfil();
                String[] infosMembres = conn.getMembreProfil(Integer.parseInt(numMembre));
                String login = conn.getMembreLogin(Integer.parseInt(numMembre));
                String[] infosUsers = {login , "***********"};
                request.setAttribute("infosMembres", infosMembres);
                request.setAttribute("infosUsers", infosUsers);
            } catch (SQLException ex) {
                Logger.getLogger(ServletGPMembre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.getServletContext().getRequestDispatcher(vue).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
