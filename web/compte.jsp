<%-- 
    Document   : compte
    Created on : 3 avr. 2014, 17:32:18
    Author     : franck.cros
--%>

<%@page import="java.util.List"%>
<%@page import="com.domaine.OperationCompte"%>
<%@page import="com.service.ServiceConnexion"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet type="text/css" href="includes/global.css">
        <title>Gestion du compte</title>
    </head>
    <body>
          <DIV class="global">
            <!-- HEADER : -->
            <jsp:include page ="includes/header.jsp"/>

            <!-- Barre de navigation -->
            <jsp:include page ="includes/menu_gauche.jsp"/>
            
            <!-- Contenu de la page -->
            <div class="contenu">
                
                <% 
                    if(session.getAttribute("leLogin") == null) { 
                %>
                        <jsp:include page ="includes/connexion.jsp"/>
                <%   
                    } else {
                     
                    }
                %>
                
                <div class ="table">
                    
                <table>
                    <caption>Opérations du compte : </caption>
                    
                    <tr>
                        <th>Num Compte </th>
                        <th>Date </th>
                        <th>Opération Compte </th>
                        <th>Commentaire </th>
                        <th>Num Seq </th>
                       
                    </tr>
                    
                    <%
                    
                    ServiceConnexion sc = new ServiceConnexion();
                    
                    List<OperationCompte> listOpe = sc.getComptes(1);
                    
                    for(int i=0; i< listOpe.size(); i++)
                    {
                       
                    %>
                    
                    <tr>
                        <td> <%= listOpe.get(i).getNumOperation() %> </td>
                        <td> <%= listOpe.get(i).getDateOperation()  %></td>
                        <td> <%= listOpe.get(i).getValeurOperation()  %></td>
                        <td> <%= listOpe.get(i).getCommentaire() %></td>
                        <td> <%= listOpe.get(i).getNumSeq()  %></td>
                        
                    </tr>
                    
                    <%
                         
                    }      
                    %>
                    
                </table>
                    
                    
                    <select name="date"  >
                        
                        <% 
                        
                          Calendar c = Calendar.getInstance();
                          int year = c.get(Calendar.YEAR);
                          
                          for(int i=2010;i<year+2;i++)
                          {
                        %>
                         <option> <%= i %> </option>
                         <%
                          }   
                         %>
  
                    </select>
                
                
                </div>
                
                
            </div>

            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </DIV>
    </body>
</html>
