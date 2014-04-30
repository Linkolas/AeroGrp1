package com.servlet;
import com.service.ServiceConnexion;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 
 * Cette servlet est appelée en cas de connexion ou de déconnexion, elle stocke
 * ou supprime la session puis renvoie sur la page d'accueil.
 */
public class ServletConnexion extends HttpServlet {
    public static final String VUE = "/index.jsp";
    //public static final String ATT_SESSION_USER = "login";
       
    @Override
    public void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
    
    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        HttpSession session = request.getSession();
        
        // CONNEXION
        if ("connexion".equals(request.getParameter("action"))) {
            
            String paramLogin  = request.getParameter("login") ;            //Vient de la requête POST
            String paramPasswd = request.getParameter("passwd");            //Vient de la requête POST
            
            if(paramLogin != null && paramPasswd != null) {
                
                ServiceConnexion conn = new ServiceConnexion();
                
                try {
                    String[] user = conn.getUser(paramLogin, paramPasswd);   //Recupére l'user dans la BDD s'il existe
                    String name = user[1];
                    String nummembre = user[2];
                    String role = user[3];
                    session.setAttribute("leLogin", name);
                    session.setAttribute("numMembre", nummembre);
                    session.setAttribute("role", role);
                } catch (SQLException se) {
                    session.setAttribute("Erreur", "Impossible de se connecter.");
                }
                
            } else {
                session.setAttribute("Erreur", "Vous n'avez pas renseigné le login et/ou le pass.");
            }
            
        // DECONNECTION
        } else if ("deconnection".equals(request.getParameter("action"))){
            session.invalidate();
        }
        
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}