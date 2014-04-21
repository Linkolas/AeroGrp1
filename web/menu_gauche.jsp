<%-- 
    Document   : menu_gauche
    Created on : 5 déc. 2013, 17:27:39
    Author     : franck.cros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="menuGauche"> 
    <input style="margin-top: 15px;" type="button" value="Profil"  name="profil"  onclick="self.location.href='profil.jsp';"  />
    <input style="margin-top: 15px;" type="button" value="Compte"  name="Compte"  onclick="self.location.href='compte.jsp';"  />
    <input style="margin-top: 15px;" type="button" value="Vols"    name="Vols"    onclick="self.location.href='vols.jsp';"    />
    <input style="margin-top: 15px;" type="button" value="Membre"  name="Membre"  onclick="self.location.href='membre_m.jsp';"/>
    <input style="margin-top:280px;" type="button" value="Contact" name="Contact" onclick="self.location.href='contact.jsp';" />
</div>