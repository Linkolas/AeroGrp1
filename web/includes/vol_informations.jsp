<%-- 
    Document   : footer
    Created on : 19 déc. 2013, 14:43:15
    Author     : nicolas.pendon
--%>

<%@page import="com.domaine.Avion"%>
<%@page import="com.domaine.Instructeur"%>
<%@page import="com.domaine.Vol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Vol vol = (Vol) request.getAttribute("vol");
if(vol == null) {
    out.println("Cliquez sur une séquence de vol <BR/> pour afficher ses informations.");
} else {
%>
    <span style="font-size: 170%;">Vol numéro <%= vol.getNum() %></span>
    <BR/>
    en date du <%= vol.getDate() %>
    <BR/>
    <BR/>
    <TABLE style='margin-left: auto; margin-right: auto; text-align: left; width: 800px;'>
        <TR>
            <TD>
                Temps passé en vol : 
            </TD>
            <TD>
                <%= vol.getTemps() %> heure(s)
            </TD>
            <TD>
                dont comprises dans un forfait : 
            </TD>
            <TD>
                <%= vol.getHeuresForfait() %> heure(s)
            </TD>
        </TR>
        <TR>
            <TD>
                Prix spécial : 
            </TD>
            <TD>
                <%= (vol.getPrixSpecial() < 0 ? "Aucun" : vol.getPrixSpecial()) %>
            </TD>
            <TD>
                Motif : 
            </TD>
            <TD>
                <%= vol.getMotif() %>
            </TD>
        </TR>
    </TABLE>
    <BR/>
    <BR/>
    <%
    Instructeur in = (Instructeur) request.getAttribute("instructeur");
    if(in != null) { 
    %>
    <TABLE style='text-align: left; width: 350px; float: left;'>
        <TR>
            <TD>Instructeur n°<%= in.getNumInstructeur()%></TD>
            <TD>Prix à l'heure habituel : <%= in.getTaux() %> €/h</TD>
        </TR>
        <TR>
            <TD><%= in.getNom() %> <%= in.getPrenom() %></TD>
            <TD>Prix à l'heure final : <%= vol.getTauxInstructeur() %> €/h</TD>
        </TR>
    </TABLE>
    <%
    }
    Avion av = (Avion) request.getAttribute("avion");
    %>
    <TABLE style='text-align: left; width: 350px; float: right;'>
        <TR>
            <TD>Avion n°<%= av.getNum_avion() %> (<%= av.getType_avion() %>)</TD>
            <TD>Prix à l'heure : <%= av.getTaux() %> €/h</TD>
        </TR>
        <TR>
            <TD><%= av.getImmatriculation() %></TD>
            <TD>Réduction horaire : <%= vol.getReductionSemaine() %> €/h</TD>
        </TR>
    </TABLE>
<%
}
%>