<%-- 
    Document   : compte
    Created on : 3 avr. 2014, 17:32:18
    Author     : franck.cros
--%>

<%@page import="com.domaine.Compte"%>
<%@page import="java.util.List"%>
<%@page import="com.domaine.OperationCompte"%>
<%@page import="com.service.ServiceConnexion"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                <% 
                    if(!"admin".equals((String) session.getAttribute("role"))) { 
                %>
                        <jsp:include page ="includes/connexion.jsp"/>
                <%   
                    } else {
                %>
                <FORM name="opecompte" action="AdminCompteUpdate">
                        Opérations sur le compte n°<%= Integer.parseInt((String) request.getAttribute("membre")) %>
                        <BR/>
                        <BR/>
                        Trier par date :
                        <SELECT id="annee" name="annee" size="1" onChange="triOperationsCompteAdmin()">
                            <OPTION value="*">Année</OPTION>
                            <% 
                            Calendar c = Calendar.getInstance();
                            int annee = c.get(Calendar.YEAR);
                            for(int i = (annee +2); i > 2005 ; i--) {
                            %>
                                <option><%= i %></option>
                            <%
                            }   
                            %>
                        </SELECT>
                        <SELECT id="mois" name="mois" size="1" onChange="triOperationsCompteAdmin();">
                            <OPTION value="*">Mois</TOUS>
                            <% 
                                for(int i=1; i<13; i++) {
                            %>
                            <OPTION><%= (i<10 ? "0"+i : i) %></OPTION>
                            <%
                                }
                            %>
                        </SELECT>
                        <BR/><BR/>
                        <table id="compte" style="width: 800px;">
                            <tr>
                                <th style="width: 100px;">N°Operation</th>
                                <th style="width: 150px;">Date</th>
                                <th style="width: 150px;">Montant</th>
                                <th style="width: 200px;">Commentaire</th>
                                <th style="width: 100px;">N°Séquence</th>
                                <th style="width: 100px;">Suppr.</TH>
                            </tr>
                            <TR>
                                <TD>(Nouveau)</TD>
                                <TD><INPUT TYPE="text" name="newDateOpe" size="10"/></TD>
                                <TD><INPUT TYPE="text" name="newValOpe"  size="8" /></TD>
                                <TD><INPUT TYPE="text" name="newCommentOpe" size="30"/></TD>
                                <TD>0</TD>
                                <TD> </TD>
                            </TR>
                            <%
                            Compte compte = (Compte) request.getAttribute("compte");
                            float total = 0;
                            for(OperationCompte ope : compte.getOperations()) {
                                total += ope.getValeurOperation();
                                boolean haveSeqVol = false;
                                if(ope.getNumSeq() != 0) {
                                    haveSeqVol = true;
                                }
                            %>
                                <TR>
                                    <TD><%= ope.getNumOperation() %></TD>
                                    <TD><span style="display: none;"><%= ope.getDateOperation() %></span>
                                        <INPUT TYPE="text" name="DateOpe<%= ope.getNumOperation() %>" VALUE="<%= ope.getDateOperation() %>" size="10"
                                               <%= (haveSeqVol ? "DISABLED" : "") %>/>
                                    </TD>
                                    <TD style="text-align: <%= (ope.getValeurOperation() < 0 ? "right" : "left") %>;">
                                        <INPUT TYPE="text" name="ValOpe<%= ope.getNumOperation() %>" VALUE="<%= ope.getValeurOperation() %>" size="8"
                                               <%= (haveSeqVol ? "DISABLED" : "") %>/>
                                    </TD>
                                    <TD>
                                        <INPUT TYPE="text" name="CommentOpe<%= ope.getNumOperation() %>" VALUE="<%= ope.getCommentaire() %>" size="30"
                                               <%= (haveSeqVol ? "DISABLED" : "") %>/>
                                    </TD>
                                    <TD><%= ope.getNumSeq() %></TD>
                                    <TD>
                                        <% if (!haveSeqVol) { %>
                                            <INPUT TYPE="button" value="Suppr." onClick="deleteCompteOpe(<%= ope.getNumOperation() %>)"/>
                                        <% } %>
                                    </TD>
                                </TR>
                            <% 
                            }
                            %>
                        </table>
                        <BR/>
                        <BR/>
                        TOTAL SUR LE COMPTE : <%= total %> €
                        <BR/>
                        <BR/>
                        <INPUT TYPE="submit" value="Enregistrer">
                        <INPUT TYPE="hidden" name="membre" value="<%= request.getAttribute("membre") %>"/>
                </FORM>
                <%
                    }
                %>