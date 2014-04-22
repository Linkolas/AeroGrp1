<%-- 
    Document   : menu_admin
    Created on : 22 avr. 2014, 18:35:22
    Author     : Satanar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <input style="margin-left: auto; margin-right: auto;" type="button" value="Profil"      name="admin_profil"  onclick="ajax('includes/form_disabled.jsp','resultat','Je charge le membrre!')"  />
    <input style="margin-left: auto; margin-right: auto;" type="button" value="Compte"      name="admin_compte"  onclick="ajax(''                          ,'resultat','Chargement des opéarations du compte')"  />
    <input style="margin-left: auto; margin-right: auto;" type="button" value="Vols"        name="admin_vols"    onclick="ajax('InfoSeqVol'                ,'resultat','Chargement des vols')"    />