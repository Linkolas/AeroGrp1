<%-- 
    Document   : vols
    Created on : 3 avr. 2014, 17:03:48
    Author     : nicolas.pendon
--%>

<%@page import="com.domaine.Vol"%>
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
                <table>
                    <tr>
                        <td style='width: 150px; height: 89px; text-align: center;'>
                            Trier par date<BR/>
                            <SELECT name='annee' size='1' onChange="selectAnnee(this.value);">
                                <OPTION value='*'>Tous</OPTION>
                                <% 
                                    int annee = Calendar.getInstance().get(Calendar.YEAR);
                                    for(int i = (annee +2); i > 2005 ; i--) { 
                                %>
                                <OPTION<% if(request.getParameter("annee") != null && Integer.parseInt(request.getParameter("annee")) == i) out.println(" SELECTED"); %>><%= i %></OPTION>
                                <%
                                    }
                                %>
                            </SELECT>
                            <SELECT name="mois" size="1" onChange="selectMois(this.value);">
                                <OPTION value="*">Tous</TOUS>
                                <% 
                                    for(int i=1; i<13; i++) {
                                %>
                                <OPTION><%= i %></OPTION>
                                <%
                                    }
                                %>
                            </SELECT>
                        </td>
                        <td rowspan=2 style='border-left: 1px black solid;'>
                            
                            Informations concernant la personne sélectionnée
                            
                        </td>
                    </tr>
                    <tr>
                        <td style='width: 150px; height: 400px; border-top: 1px black solid;'>
                            <FORM>
                                <SELECT size="24" style="width: 150px; height: 395px;" onChange="selectVol(this.value);">
                                    <% 
                                        List<Vol> vols = (ArrayList<Vol>) request.getAttribute("listeVols");
                                        for(Vol vol : vols) {
                                    %>
                                    <OPTION value="<%= vol.getNum() %>"><%= vol %></OPTION>
                                    <%
                                        }
                                    %>
                                </SELECT>
                            </FORM>
                        </td>
                    </tr>
                </table>
            </DIV>
            
            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </div>
    </body>
</html>
