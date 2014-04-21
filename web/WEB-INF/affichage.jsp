<%-- 
    Document   : affichage
    Created on : 28 nov. 2013, 17:16:43
    Author     : nicolas.pendon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affichage des vols</title>
    </head>
    
    <body onload="vols();" background="../imageA.png" style="background-repeat:no-repeat; background-size:cover;">
        
        <div style="height:75px;border:solid 2px black;" >
              <jsp:include page ="../header.jsp"/>
        </div>
            
        <br/>
        
        <div style="position:relative;width:130px;height:500px;float:left;border:solid 2px black;">
            <jsp:include page ="../menu_gauche.jsp"/> 
        </div>
        
        <div style="text-align: center;position:relative;margin-left:150px;height:500px; border:solid 2px black;background-color: rgba(255, 255, 255, 0.5);">
            
            
                <font  size="6" >
                Liste des vols : 
                </font>
                
                
                <br> 
                

                
                <table border="2" style="margin-right: 20px; margin-left: 20px;">
                <thead>
                    <tr>
                        <th>Numéro vol </th>
                        <th>Date </th>
                        <th>Durée </th>
                        <th>heures forfait</th>
                        <th>prix special </th>
                        <th> taux</th>
                        <th> reduction semaine</th>
                        <th> motif</th>
                        <th> taux instructeur</th>
                        <th> forfait initiation</th>
                        <th> numero membre</th>
                        <th> numéro instructeur</th>
                        <th> numéro avion</th>
                    </tr>
                </thead>
                <tbody>
                    
                
                <th> <%= session.getAttribute("lesVols") %> </th>
                    
                    
                </tbody>
                
        
        </div>
        
    </body>
</html>
