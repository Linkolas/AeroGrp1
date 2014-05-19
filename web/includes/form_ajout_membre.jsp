<%-- 
    Document   : form_ajout_membre
    Created on : 19 mai 2014, 11:30:44
    Author     : Satanar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<FORM id="moogle" method="post" onsubmit="javascript:return verif()">
    <table>
        <TR> 
            <TH colspan="2">Informations Membre :  </TH>
        </TR>
 
        <%
            String[] nomsChamps = {"N°Badge* :"          , "Nom* :"              , "Prénom :"         , "Adresse :", "Code Postal :", 
                                   "Ville :"            , "Telephone* :"        , "Portable :"       , "E-mail :" , "Profession :" ,
                                   "Date de naissance* :", "Lieu de naissance :", "Carte fédérale* :"};
            String[] nameChamps = {"badge"            , "Nom"              , "prenom"         , "adresse", "code_postal",
                                   "ville"            , "tel"              , "portable"       , "email"  , "prof"       ,
                                   "date_naiss"       , "lieu_naiss"       , "carte_fed"     };
            int nbChamps = 13;
            
            for(int i=0; i<nbChamps; i++) { 
        %>
        <TR>
            <TD><%= nomsChamps[i] %></TD>
            <TD></TD>
            <TD><input type="text" name="<%= nameChamps[i] %>" id="<%= nameChamps[i] %>" rows=1 cols=80 placeholder="Valeur par défaut" ></TD>
        </TR>
        <%
            }
        %>
        <TR>
            <TH colspan="2">Informations Utilisateur :  </TH>
        </TR>
        <%
            String[] nomsChampsUser = {"Nom d'utilisateur* :", "Mot de passe* :"};
            String[] nameChampsUser = {"User"             , "passwd"};
            int nbChampsUser = 2;
            
            for(int i=0; i<nbChampsUser; i++) { 
        %>
        <TR>
            <TD><%= nomsChampsUser[i] %></TD>
            <TD></TD>
            <TD><input type="text" name="<%= nameChampsUser[i] %>" id="<%= nameChampsUser[i] %>" rows=1 cols=80 placeholder="Valeur par défaut"></TD>
        </TR>
        <%
            }
        %>
    </table>
    <% // Placé dans une DIV pour profil.js %>
    <INPUT type="hidden" name="modificationProfil" value="0"/>
    <INPUT type="hidden" name="AjoutProfil" value="1"/>
    <% 
    //String javas = "javascript:enableInputs();";
    //if("admin".equals((String) session.getAttribute("role"))) {
    //        javas = "javascript:enableInputs();enableInputsAdmin();";
    //} 
    %>
    <div id="submitButton"><input type="submit" value="Enregistrer"></div>
</FORM>