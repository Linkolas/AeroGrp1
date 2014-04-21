<%-- 
    Document   : connexion
    Created on : 21 nov. 2013, 15:31:22
    Author     : quentin.vauthier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="includes/global.css"/>
        <title>Connexion</title>
    </head>
    <body>
        <DIV class="global">
            <!-- HEADER : -->
            <jsp:include page ="includes/header.jsp"/>
            
            <!-- Barre de navigation -->
            <jsp:include page ="includes/menu_gauche.jsp"/>
            
            <!-- Contenu de la page -->
            <DIV class="contenu">
                <jsp:include page ="includes/connexion.jsp"/>
            </DIV>
            
            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </div>
    </body>
</html>
