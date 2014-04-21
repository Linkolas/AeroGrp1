<%-- 
    Document   : profil
    Created on : 28 nov. 2013, 15:37:37
    Author     : quentin.vauthier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet type="text/css" href="includes/global.css">
        <script><jsp:include page="includes/ajax.js"/></script>
        <script><jsp:include page="includes/profil.js"/></script>
        <title>Gestion de profil</title>
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
                %>
                        <div class="membreForm" style="margin-top: 40px; margin-bottom: 40px;" id="reponse">
                            <jsp:include page="includes/form_disabled.jsp"/>
                        </div>
                <%   
                    }
                %>
            </div>

            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </DIV>
    </body>
</html>