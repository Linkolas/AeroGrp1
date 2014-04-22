<%-- 
    Document   : menu_gauche
    Created on : 5 déc. 2013, 17:27:39
    Author     : franck.cros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="menuGauche">
    <%
        String path = request.getRequestURL().toString();
        String[] paths = path.split("/");
        String relatif = (paths[paths.length-3].equals("WebApp") ? "../" : "");
    %>
    <input style="margin-top: 15px;" type="button" value="Accueil" name="Accueil" onclick="self.location.href='<%= relatif %>index.jsp';"  />
    <input style="margin-top: 15px;" type="button" value="Profil"  name="Profil"  onclick="self.location.href='<%= relatif %>Profil';"  />
    <input style="margin-top: 15px;" type="button" value="Compte"  name="Compte"  onclick="self.location.href='<%= relatif %>Compte';"  />
    <input style="margin-top: 15px;" type="button" value="Vols"    name="Vols"    onclick="self.location.href='<%= relatif %>Vols';"    />
    <input style="margin-top: 15px;" type="button" value="Administration"  name="Membre"  onclick="self.location.href='<%= relatif %>Membres';"/>
    
    <input style="margin-top:230px;" type="button" value="Contact" name="Contact" onclick="self.location.href='<%= relatif %>contact.jsp';" />
</div>