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
            Prix à l'heure : 
        </TD>
        <TD>
            <%= vol.getTaux() %> €/h
        </TD>
        <TD>
            Réduction à l'heure : 
        </TD>
        <TD>
            <%= vol.getReductionSemaine() %> €/h
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
    <TR>
        <TD>
            Instructeur n° : 
        </TD>
        <TD>
            <%= vol.getNumInstructeur() %>
        </TD>
        <TD>
            Prix à l'heure : 
        </TD>
        <TD>
            <%= vol.getTauxInstructeur() %> €/h
        </TD>
    </TR>
</TABLE>
<%
}
%>