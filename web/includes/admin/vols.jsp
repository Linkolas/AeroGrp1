<%-- 
    Document   : vols
    Created on : 17 mai 2014, 19:35:52
    Author     : Nicolas
--%>

<%@page import="com.domaine.Vol"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table style="width: 870px;">
    <tr>
        <td style='width: 150px; height: 89px; text-align: center;'>
            Trier par date<BR/>
            <SELECT id="annee" name='annee' size='1' onChange="triVols();">
                <OPTION value='*'>Année</OPTION>
                <% 
                    int annee = Calendar.getInstance().get(Calendar.YEAR);
                    for(int i = (annee +2); i > 2005 ; i--) { 
                %>
                    <OPTION><%= i %></OPTION>
                <%
                    }
                %>
            </SELECT>
            <SELECT id="mois" name="mois" size="1" onChange="triVols();">
                <OPTION value="*">Mois</TOUS>
                <% 
                    for(int i=1; i<13; i++) {
                %>
                    <OPTION><%= (i<10 ? "0"+i : i) %></OPTION>
                <%
                    }
                %>
            </SELECT>
        </td>
        <td rowspan=2 style='border-left: 1px black solid; text-align: center;' id="affichage">
            
             <jsp:include page="/includes/vol_informations.jsp"/>
            
        </td>
    </tr>
    <tr>
        <td style='border-top: 1px black solid;'>
            <SELECT id="vols" name="vols" size="24" style="width: 150px; height: 275px;" onChange="selectVol(this.value); adminVol(this.value);">
                <% 
                    List<Vol> vols = (ArrayList<Vol>) request.getAttribute("listeVols");
                    for(Vol vol : vols) {
                %>
                    <OPTION value="<%= vol.getNum() %>"><%= vol %></OPTION>-->
                <%
                   }
                %>
            </SELECT>
            <input id="addVol" type="button" value="Ajouter"/>
            <input id="delVol" type="button" value="Suppr."/>
        </td>
    </tr>
</table>