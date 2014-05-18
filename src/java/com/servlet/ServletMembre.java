/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.domaine.Membre;
import com.service.ServiceMembre;
import com.service.ServiceProfil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cyril.delanghe
 */
@WebServlet(name = "ServletMembre", urlPatterns = {"/ServletMembre"})

public class ServletMembre extends HttpServlet {


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
        if(!"admin".equals((String) session.getAttribute("role"))) {
            vue = "/ErreurConnexion";
            
        } else {
            vue = "/membres.jsp";
            ServiceMembre conn = new ServiceMembre();
            List<Membre> nomsMembres = conn.toutlesMembres();
            request.setAttribute("nomsMembres", nomsMembres);
            if("1".equals(request.getParameter("modificationProfil")))
                  {
                     String modifMembre = (String) session.getAttribute("numGMembre");
                     ServiceProfil profi = new ServiceProfil();
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
                     profi.updateMembre2(Integer.parseInt(modifMembre), tableauInfos);
                     
                    String passUser = request.getParameter("passwd");
                    String pseudoUser = request.getParameter("user");
                    profi.updateUseradmin(modifMembre, pseudoUser , passUser);
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
