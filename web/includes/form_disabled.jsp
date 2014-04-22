<%-- 
    Document   : form_disabled
    Created on : 19 déc. 2013, 17:07:10
    Author     : nicolas.pendon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<FORM id="moogle" method="post">
    <table>
        <TR> 
            <TH colspan="2">Informations Membre :  </TH>
        </TR>
        
        <%
            
            String[] num_membre = (String[]) request.getAttribute("infosMembres");
            
        %>
        
        
        <%
            String[] nomsChamps = {"N°Badge :"          , "Nom :"              , "Prénom :"         , "Adresse :", "Code Postal :", 
                                   "Ville :"            , "Telephone :"        , "Portable :"       , "E-mail :" , "Profession :" ,
                                   "Date de naissance :", "Lieu de naissance :", "Carte fédérale :"};
            String[] nameChamps = {"badge"            , "nom"              , "prenom"         , "adresse", "code_postal",
                                   "ville"            , "tel"              , "portable"       , "email"  , "prof"       ,
                                   "date_naiss"       , "lieu_naiss"       , "carte_fed"     };
            int nbChamps = 13;
            
            for(int i=0; i<nbChamps; i++) { 
        %>
        <TR>
            <TD><%= nomsChamps[i] %></TD>
            <TD></TD>
            <TD><input type="text" name="<%= nameChamps[i] %>" id="<%= nameChamps[i] %>" rows=1 cols=80 placeholder="<% if(!(num_membre[i+1]== null))
            { 
                out.println(num_membre[i+1]);
            } 
            else { 
                out.println("Valeur par défaut");
                    
                 }
            %>" DISABLED></TD>
        </TR>
        <%
            }
        %>
        <TR> 
            <TH colspan="2">Informations Utilisateur :  </TH>
        </TR>
        <%
            String[] nomsChampsUser = {"Nom d'utilisateur :", "Mot de passe :", "Adresse e-mail :"};
            String[] nameChampsUser = {"user"             , "passwd"      , "mail"};
            int nbChampsUser = 3;
            
            for(int i=0; i<nbChampsUser; i++) { 
        %>
        <TR>
            <TD><%= nomsChampsUser[i] %></TD>
            <TD></TD>
            <TD><input type="text" name="<%= nameChampsUser[i] %>" id="<%= nameChampsUser[i] %>" rows=1 cols=80 placeholder="Valeur par défaut" DISABLED></TD>
        </TR>
        <%
            }
        %>
    </table>
    <% // Placé dans une DIV pour profil.js %>
    <INPUT type="hidden" name="modificationProfil" value="1"/>
    <div id="submitButton"><input type="button" value="Modifier" onClick="javascript:enableInputs();"></div>
</FORM>