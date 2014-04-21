<%-- 
    Document   : Connexion
    Created on : 28 nov. 2013, 16:59:50
    Author     : quentin.vauthier
--%>

<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        
    </head>
    <body>
        <form method="post" action="Connexion">
                <legend>Connexion</legend>
                

                Login <input type="text" id="login" name="login" value="" size="20" maxlength="60" />
                <br />

                Mot de passe <input type="password" id="motdepasse" name="passwd" value="" size="20" maxlength="20" />
                <br />


                <input type="submit" value="Connexion"/>
                <br />
                
        <p>Ceci est une page générée depuis une JSP.</p>
            <p>
                <%
                String attribut = (String) request.getAttribute("leLogin");
                out.println(attribut);
                
                %>
            </p>
            
        </form>
    </body>
</html>
