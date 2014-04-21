<%-- 
    Document   : index
    Created on : 21 nov. 2013, 15:20:25
    Author     : nicolas.pendon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="includes/global.css"/>
        <title>Index</title>
    </head>
    <body  background="imageA.png" style="background-repeat:no-repeat; background-size:cover;">
        
        <DIV class="global">
            <!-- HEADER : -->
            <jsp:include page ="includes/header.jsp"/>
            
            <!-- Barre de navigation -->
            <jsp:include page ="includes/menu_gauche.jsp"/>
            
            <!-- Contenu de la page -->
            <DIV class="contenu" id="index">
                <!-- Informations de connexion -->
                <div id="index-co">  
                    <jsp:include page ="includes/connexion.jsp"/>
                </div>
                
                <!-- Twitter -->
                <div id="index-tweeter" >
                    
                </div>
                
                <!-- Titres des infos -->
                <div id="index-info" > 

                </div>
                
                <!-- Contenu de l'info sélectionnée -->
                <div id="info-select" >
                    
                </div>
            </DIV>
            
            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </div>

    </body>
</html>
