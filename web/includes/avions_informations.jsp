<%-- 
    Document   : avions_informations
    Created on : 2 mai 2014, 21:39:58
    Author     : Quentin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.domaine.Avion"%>
<%@page import="com.domaine.Instructeur"%>
<%@page import="com.domaine.Vol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
Avion avion = (Avion) request.getAttribute("avion");
ArrayList infosAvions  = (ArrayList<String>) request.getAttribute("infosAvions");

if(avion == null) {
    out.println("Cliquez sur un avion <BR/> pour afficher ses informations.");
} else {
%>
    <span style="font-size: 170%;">Avion numéro <%= avion.getNum_avion()%></span>
    
    <FORM id="doodle" method="post">
    <table>
        <TR> 
            <TH colspan="2">Informations avion :  </TH>
        </TR>
        
        <%
            
          //String[] infosAvions  = (String[]) request.getAttribute("infosAvions");
            
        %>
        
        
        <%
            String[] nomsChamps = {"Immatriculation :"          , "Type :"              , "Taux :"         , "Reduction semaine :"};
            String[] nameChamps = {"immat"                      , "type"                , "taux"           , "reduc"};
            int nbChamps = 4;
            
            for(int i=0; i<nbChamps; i++) { 
        %>
        <TR>
            <TD><%= nomsChamps[i] %></TD>
            <TD></TD>
            <TD><input type="text" name="<%= nameChamps[i] %>" id="<%= nameChamps[i] %>" rows=1 cols=80 placeholder="<% if(!(infosAvions.get(i)== null))
            { 
                out.println(infosAvions.get(i));
            } 
            else { 
                out.println("Valeur par défaut");
                    
                 }
            %>" DISABLED></TD>
        </TR>
        <%
            }
        %>
        
    </table>
    <% // Placé dans une DIV pour profil.js %>
    <INPUT type="hidden" name="modificationProfil" value="1"/>
    <div id="submitButton"><input type="button" value="Modifier" onClick="javascript:enableInputs();"></div>
</FORM>
    
<%
}
%>
