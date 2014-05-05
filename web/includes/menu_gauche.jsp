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
    <% 
    int ecart = 280;
    if("admin".equals((String) session.getAttribute("role"))) {
        ecart -= 180; %>
    <input style="margin-top: 15px;" type="button" value="Gérer membres"  name="Membre"  onclick="self.location.href='<%= relatif %>Membres';"/>
    <input style="margin-top: 15px;" type="button" value="Gérer instructeurs"  name="Instructeur"  onclick="self.location.href='<%= relatif %>Instructeurs';"/>
    <input style="margin-top: 15px;" type="button" value="Gérer admins"  name="Admin"  onclick="self.location.href='<%= relatif %>Admins';"/>
    <input style="margin-top: 15px;" type="button" value="Gérer avions"  name="Avion"  onclick="self.location.href='<%= relatif %>Avions';"/>
    <% } %>
    <input style="margin-top:<%= ecart %>px;" type="button" value="Contact" name="Contact" onclick="self.location.href='<%= relatif %>contact.jsp';" />
</div>