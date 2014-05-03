<%-- 
    Document   : avions
    Created on : 2 mai 2014, 21:24:36
    Author     : Quentin
--%>

<%@page import="com.domaine.Avion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="includes/global.css"/>
        <script><jsp:include page="includes/ajax.js"/></script>
        <script><jsp:include page="includes/vol.js"/></script>
        <title>Vols</title>
    </head>
    <body>
        <DIV class="global">
            <!-- HEADER : -->
            <jsp:include page ="includes/header.jsp"/>
            
            <!-- Barre de navigation -->
            <jsp:include page ="includes/menu_gauche.jsp"/>
            
            <!-- Contenu de la page -->
            <DIV class="contenu">
                <table style="width: 1000px;">
                    <tr>
                        <td style='width: 150px; height: 89px; text-align: center;'>
                            Choissisez un avion pour le modifier
                        </td>
                        <td rowspan=2 style='border-left: 1px black solid; text-align: center;' id="affichage">
                            
                            <jsp:include page="includes/avions_informations.jsp"/>
                            
                        </td>
                    </tr>
                    <tr>
                        <td style='width: 150px; height: 400px; border-top: 1px black solid;'>
                             <SELECT id="vols" name="vols" size="24" style="width: 150px; height: 395px;" onChange="selectAvion(this.value);">
                                <% 
                                    List<Avion> avions = (ArrayList<Avion>) request.getAttribute("listeAvions");
                                    for(Avion avion : avions) {
                                %>
                                <OPTION value="<%= avion.getNum_avion()%>"><%= avion.getImmatriculation() %></OPTION>
                                <%
                                    }
                                %>
                            </SELECT>
                        </td>
                    </tr>
                </table>
            </DIV>
            
            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </div>
    </body>
</html>
