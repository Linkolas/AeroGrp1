<%-- 
    Document   : membre_informations_compte
    Created on : 1 mai 2014, 21:04:08
    Author     : SombraVerdad
--%>

<%@page import="com.domaine.OperationCompte"%>
<%@page import="com.domaine.Compte"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
 Compte compte = (Compte) request.getAttribute("compte");
 if(compte == null) {
    out.println("Cliquez sur un Membre <BR/> ");
} else {

 for(OperationCompte ope : compte.getOperations()) {
                                
                            %>
                                <TR>
                                    <TD><%= ope.getNumOperation() %></TD>
                                    <TD><%= ope.getDateOperation() %></TD>
                                    <TD style="text-align: <%= (ope.getValeurOperation() < 0 ? "right" : "left") %>;"><%= ope.getValeurOperation() %></TD>
                                    <TD><%= ope.getCommentaire() %></TD>
                                    <TD><%= ope.getNumSeq() %></TD>
                                </TR>
                            <% 
                            }
 }
                            %>