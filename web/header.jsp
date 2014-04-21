<%-- 
    Document   : header
    Created on : 12 déc. 2013, 14:35:23
    Author     : franck.cros
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header"> 
    <%
        String path = request.getRequestURL().toString();
        String[] paths = path.split("/");
        String relatif = (paths[paths.length-3].equals("WebApp") ? "../" : "");
    %>
    <div style="height: 70px; float: left;">
        <img src="<%= relatif %>blasonMerville.gif"/>
    </div>
    
    <div style="height: 70px; float: right;">
        <img src="<%= relatif %>blasonMerville.gif"/>
    </div>
    
    <font  size="6"> 
        Aéro-Club de Merville <BR/>
        Application web de gestion 
    </font>
    
</div>