/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.service.ServiceProfil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicolas.pendon
 */
@WebServlet(name = "ServletProfil", urlPatterns = {"/ServletProfil"})
public class ServletProfil extends HttpServlet {

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
        if(session.getAttribute("leLogin") == null) {
            vue = "/ErreurConnexion";
        } else {
            vue = "/profil.jsp";
            ServiceProfil conn = new ServiceProfil();
            String sessionNumMembre = (String) session.getAttribute("numMembre");
              try {
                  
                 if("1".equals(request.getParameter("modificationProfil")))
                  {
                     ArrayList<String> tableauInfos = new ArrayList();
                     tableauInfos.add(request.getParameter("badge"));
                     tableauInfos.add(request.getParameter("nom"));
                     tableauInfos.add(request.getParameter("prenom"));
                     tableauInfos.add(request.getParameter("adresse"));
                     tableauInfos.add(request.getParameter("code_postal"));
                     tableauInfos.add(request.getParameter("ville"));
                     tableauInfos.add(request.getParameter("tel"));
                     tableauInfos.add(request.getParameter("portable"));
                     tableauInfos.add(request.getParameter("email"));
                     tableauInfos.add(request.getParameter("prof"));
                     tableauInfos.add(request.getParameter("date_naiss"));
                     tableauInfos.add(request.getParameter("lieu_naiss"));
                     tableauInfos.add(request.getParameter("carte_fed"));
                     conn.updateMembre2(Integer.parseInt(sessionNumMembre), tableauInfos);
                  }
                  else
                  {
                      
                  }
                    
                    String[] infosMembre = conn.getMembreProfil(Integer.parseInt(sessionNumMembre));   //Recupére l'user dans la BDD s'il existe
                    request.setAttribute("infosMembres", infosMembre);
                } catch (SQLException se) {
                    session.setAttribute("Erreur", "Impossible de se connecter.");
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
