<%-- 
    Document   : footer
    Created on : 19 déc. 2013, 14:43:15
    Author     : nicolas.pendon
--%>

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
<TABLE>
    <TR>
        <TD>
            Temps passé en vol : <%= vol.getTemps() %>
        </TD>
        <TD>
            Prix à l'heure : <%= vol.getTaux() %>
        </TD>
    </TR>
    <TR>
        <TD>
            dont comprises dans un forfait : <%= vol.getHeuresForfait() %>
        </TD>
        <TD>
            Réduction à l'heure : <%= vol.getReductionSemaine() %>
        </TD>
    </TR>
    <TR>
        <TD>
            Prix spécial : <%= (vol.getPrixSpecial() < 0 ? "Aucun" : vol.getPrixSpecial()) %>
        </TD>
        <TD>
            Motif : <%= vol.getMotif() %>
        </TD>
    </TR>
    <TR>
        <TD>
            Instructeur n° : <%= vol.getNumInstructeur() %>
        </TD>
        <TD>
            Prix à l'heure : <%= vol.getTauxInstructeur() %>
        </TD>
    </TR>
</TABLE>
<%
}
%>