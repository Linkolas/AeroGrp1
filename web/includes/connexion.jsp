<%-- 
    Document   : connexion
    Created on : 27 mars 2014, 16:10:01
    Author     : nicolas.pendon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%                 
String attribut = (String) session.getAttribute("leLogin");

if(attribut != null) {
    out.println("Bienvenue " + attribut);
%>
    <form method='post' action='Index'>
        <input type='hidden' value='deconnection' name='action'/>
        <input type='submit' value='Deconnection'/>
    </form>
<%
} else {
%>
    <form method="post" action="Index">
        <input type='hidden' value='connexion' name='action'/>
        <TABLE>
            <TR>
                <TD>Utilisateur</TD>
                <TD><input type="text" id="login" name="login" value="" size="15" maxlength="60" /></TD>
            </TR>
            <TR>
                <TD>Mot de passe</TD>
                <TD><input type="password" id="motdepasse" name="passwd" value="" size="15" maxlength="20" /></TD>
            </TR>
        </TABLE>
        <input type="submit" value="Connexion"/>
    </form>
<%
}
%>
