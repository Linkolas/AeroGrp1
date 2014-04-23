<%-- 
    Document   : affichage_a
    Created on : 28 nov. 2013, 17:19:14
    Author     : nicolas.pendon
--%>

<%@page import="com.domaine.Membre"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="includes/global.css"/>
        <script><jsp:include page="includes/ajax.js"/></script>
        <script><jsp:include page="includes/membre.js"/></script>
        <title>Affichage des membres de l'aéroclub</title>
    </head>
    <body>
        <DIV class="global">
            <!-- HEADER : -->
            <jsp:include page ="includes/header.jsp"/>
            
            <!-- Barre de navigation -->
            <jsp:include page ="includes/menu_gauche.jsp"/>

            <!-- Contenu de la page -->
            <div class="contenu">
                <table>
                    <tr>
                        <td style='width: 150px; height: 89px; text-align: center;'>
                            Trier par<BR/>
                            Noms de famille<BR/>
                            <SELECT id ="lettre" name='lettre' size='1' onChange="triMembres();">
                                <OPTION value='*' selected>Tous</OPTION>
                                <OPTION>A</OPTION>
                                <OPTION>B</OPTION>
                                <OPTION>C</OPTION>
                                <OPTION>D</OPTION>
                                <OPTION>E</OPTION>
                                <OPTION>F</OPTION>
                                <OPTION>G</OPTION>
                                <OPTION>H</OPTION>
                                <OPTION>I</OPTION>
                                <OPTION>J</OPTION>
                                <OPTION>K</OPTION>
                                <OPTION>L</OPTION>
                                <OPTION>M</OPTION>
                                <OPTION>N</OPTION>
                                <OPTION>O</OPTION>
                                <OPTION>P</OPTION>
                                <OPTION>Q</OPTION>
                                <OPTION>R</OPTION>
                                <OPTION>S</OPTION>
                                <OPTION>T</OPTION>
                                <OPTION>U</OPTION>
                                <OPTION>V</OPTION>
                                <OPTION>W</OPTION>
                                <OPTION>X</OPTION>
                                <OPTION>Y</OPTION>
                                <OPTION>Z</OPTION>
                            </SELECT>
                        </td>
                        <td style='border-left: 1px black solid;'>
                            <jsp:include page ="includes/menu_admin.jsp"/>
                        </td>
                    </tr>
                    <tr>
                        <td style='width: 150px; height: 400px; border-top: 1px black solid;'>
                            <SELECT id="nom" name="nom" size="24" style="width: 150px; height: 395px;" onclick="choixMembre();">
                                <% 
                                    String role = (String) request.getAttribute("role");
                                List<Membre> nomsMembres = (ArrayList<Membre>) request.getAttribute("nomsMembres");
                                for(Membre membrre : nomsMembres) { %>
                                <OPTION value="<%= role +" "+membrre.getNum_membre() %>"><%= membrre.getNom() +" "+ membrre.getPrenom() %></OPTION>
                             <% } %>
                            </SELECT>
                        </td>
                        <td style='border-left: 1px black solid; border-top: 1px black solid;' id="resultat">
                            Ici c'est le résultat
                        </td>
                    </tr>
                </table>
            </div>

            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </DIV>
    </body>
</html>
