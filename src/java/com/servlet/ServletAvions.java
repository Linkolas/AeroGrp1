/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlet;

import com.domaine.Avion;
import com.service.ServiceAvion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Quentin
 */
public class ServletAvions extends HttpServlet {
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
                vue = "/ErreurConnexion";
      
            } else {
                ServiceAvion conn = new ServiceAvion();
                vue = "/avions.jsp";
                String strNum = (String) session.getAttribute("numMembre");
                List<Avion> avions = ServiceAvion.getListeAvions();
                request.setAttribute("taille", avions.size());
                request.setAttribute("listeAvions", avions);
               
                if("1".equals(request.getParameter("modificationProfil")))
                  {
                     ArrayList tableauInfos = new ArrayList();
                     tableauInfos.add(request.getParameter("type"));
                     if(request.getParameter("taux") != "") {
                         tableauInfos.add(Float.parseFloat(request.getParameter("taux")));
                     } else {
                         tableauInfos.add(null);
                     }
                     if(request.getParameter("reduc") != "") {
                        tableauInfos.add(Float.parseFloat(request.getParameter("reduc")));
                     } else {
                         tableauInfos.add(null);
                     }
                     conn.updateAvion((String) session.getAttribute("immat"), tableauInfos);
                     System.out.println(session.getAttribute("immat"));

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
