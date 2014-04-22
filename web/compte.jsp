<%-- 
    Document   : compte
    Created on : 3 avr. 2014, 17:32:18
    Author     : franck.cros
--%>

<%@page import="com.domaine.Compte"%>
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
        <script><jsp:include page="includes/ajax.js"/></script>
        <script><jsp:include page="includes/compte.js"/></script>
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
                %>
                        Opérations sur le compte n°<%= Integer.parseInt((String) session.getAttribute("numMembre")) %>
                        <BR/>
                        <BR/>
                        Trier par date :
                        <SELECT id="annee" name="annee" size="1" onChange="triOperationsCompte()">
                            <OPTION value="*">Année</OPTION>
                            <% 
                            Calendar c = Calendar.getInstance();
                            int annee = c.get(Calendar.YEAR);
                            for(int i = (annee +2); i > 2005 ; i--) {
                            %>
                                <option><%= i %></option>
                            <%
                            }   
                            %>
                        </SELECT>
                        <SELECT id="mois" name="mois" size="1" onChange="triOperationsCompte();">
                            <OPTION value="*">Mois</TOUS>
                            <% 
                                for(int i=1; i<13; i++) {
                            %>
                            <OPTION><%= (i<10 ? "0"+i : i) %></OPTION>
                            <%
                                }
                            %>
                        </SELECT>
                        <BR/><BR/>
                        <table id="compte">
                            <tr>
                                <th>N°Operation</th>
                                <th>Date</th>
                                <th>Montant</th>
                                <th style="width: 400px;">Commentaire</th>
                                <th>N°Séquence</th>
                            </tr>
                            <%
                            Compte compte = (Compte) request.getAttribute("compte");
                            float total = 0;
                            for(OperationCompte ope : compte.getOperations()) {
                                total += ope.getValeurOperation();
                            %>
                                <TR>
                                    <TD><%= ope.getNumOperation() %></TD>
                                    <TD><%= ope.getDateOperation() %></TD>
                                    <TD style="text-align: <%= (ope.getValeurOperation() < 0 ? "right" : "left") %>;"><%= ope.getValeurOperation() %></TD>
                                    <TD><%= ope.getCommentaire() %></TD>
                                    <TD><%= ope.getNumSeq() %></TD>
                                </TR>
                            <% 
                            }
                            %>
                        </table>
                        <BR/>
                        <BR/>
                        TOTAL SUR LE COMPTE : <%= total %> €
                <%
                    }
                %>
            </div>

            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </DIV>
    </body>
</html>
