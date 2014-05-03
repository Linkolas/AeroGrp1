<%-- 
    Document   : avions_informations
    Created on : 2 mai 2014, 21:39:58
    Author     : Quentin
--%>

<%@page import="com.domaine.Avion"%>
<%@page import="com.domaine.Instructeur"%>
<%@page import="com.domaine.Vol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
Vol vol = (Vol) request.getAttribute("vol");

if(vol == null) {
    out.println("Cliquez sur un avion <BR/> pour afficher ses informations.");
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
            <TD colspan='2'><%= in.getNom() %> <%= in.getPrenom() %></TD>
        </TR>
        <TR>
            <TD colspan='2'>Prix à l'heure retenu : <%= vol.getTauxInstructeur() %> €/h</TD>
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
        <TR>
            <TD colspan='2'>Prix à l'heure retenu : <%= vol.getTaux()-vol.getReductionSemaine() %> €/h</TD>
        </TR>
    </TABLE>
    <div style="clear: both;"></div>
    <BR/>
    <BR/>
    Coût total :
    <TABLE style="margin-left: auto; margin-right: auto; width: 500px;">
        <TR>
            <TD>Avion</TD>
            <TD><%= vol.getTaux()-vol.getReductionSemaine() %> €/h</TD>
        </TR>
        <%
        if(in != null) {
        %>
        <TR>
            <TD>Instructeur</TD>
            <TD><%= vol.getTauxInstructeur() %> €/h</TD>
        </TR>
        <%
        }
        %>
        <TR>
            <TD>Heures de vol</TD>
            <TD><%= vol.getTemps() %></TD>
        </TR>
    </TABLE>
    <%
    if(vol.getPrixSpecial() < 0) {
        float total = vol.getTaux()-vol.getReductionSemaine();
        if(in != null) total += vol.getTauxInstructeur();
        total *= vol.getTemps();
        out.println("TOTAL : "+total+" €");
    } else {
        out.println("TOTAL : "+vol.getPrixSpecial()+" € (prix spécial)");
    }
    %>
<%
}
%>
