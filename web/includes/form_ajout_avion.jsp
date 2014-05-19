<%-- 
    Document   : form_ajout_avion
    Created on : 19 mai 2014, 20:57:30
    Author     : Quentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


    <span style="font-size: 170%;">Nouvel Avion : </span>
    
    <FORM id="doodle" method="post" onsubmit="javascript:return checkimmat()">
    <table>
        <TR> 
            <TH colspan="2">Informations avion :  </TH>
        </TR>
        
        
        
        
        <%
            String[] nomsChamps = {"Immatriculation :"          , "Type :"              , "Taux :"         , "Reduction semaine :"};
            String[] nameChamps = {"immat"                      , "type"                , "taux"           , "reduc"};
            int nbChamps = 4;
            
            for(int i=0; i<nbChamps; i++) { 
        %>
        <TR>
            <TD><%= nomsChamps[i] %></TD>
            <TD></TD>
            <TD><input type="text" name="<%= nameChamps[i] %>" id="<%= nameChamps[i] %>" rows=1 cols=80 placeholder="Valeur par défaut" REQUIRED></TD>
        </TR>
        <% 
            }
        %>
        
    </table>
    <INPUT type="hidden" name="ajoutavion" value="1"/>
    <div id="submitButton"><input type="submit" value="Enregistrer"></div>
</FORM>
