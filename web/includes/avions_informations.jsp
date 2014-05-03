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
Avion avion = (Avion) request.getAttribute("avion");

if(avion == null) {
    out.println("Cliquez sur un avion <BR/> pour afficher ses informations.");
} else {
%>
    <span style="font-size: 170%;">Avion numéro <%= avion.getNum_avion()%></span>
    <BR/>
    immatriculé : <%=  avion.getImmatriculation() %>
    <BR/>
    <BR/>
    <TABLE style='margin-left: auto; margin-right: auto; text-align: left; width: 800px;'>
        <TR>
            <TD>
                Type d'avion : 
            </TD>
            <TD>
                <%= avion.getType_avion() %> heure(s)
            </TD>
            <TD>
                dont comprises dans un forfait : 
            </TD>
            <TD>
               
            </TD>
        </TR>
        <TR>
            <TD>
                Prix spécial : 
            </TD>
            <TD>
                
            </TD>
            <TD>
                Motif : 
            </TD>
            <TD>
                
            </TD>
        </TR>
    </TABLE>
    <BR/>
    <BR/>
    
<%
}
%>
