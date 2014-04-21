<%-- 
    Document   : affichage_a
    Created on : 28 nov. 2013, 17:19:14
    Author     : nicolas.pendon
--%>

<%@page import="com.domaine.Membre"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="includes/global.css"/>
        <title>Affichage des membres de l'aéroclub</title>
    </head>
    <body>
        <DIV class="global">
            <!-- HEADER : -->
            <jsp:include page ="includes/header.jsp"/>
            
            <!-- Barre de navigation -->
            <jsp:include page ="includes/menu_gauche.jsp"/>

            <!-- Contenu de la page -->
            <div class="contenu">
                <table>
                    <tr>
                        <td style='width: 150px; height: 89px; text-align: center;'>
                            Trier par<BR/>
                            Noms de famille<BR/>
                            <FORM>
                                <SELECT name='lettre' size='1'>
                                    <OPTION value='*' selected>Tous</OPTION>
                                    <OPTION value='a'>A</OPTION>
                                    <OPTION value='b'>B</OPTION>
                                    <OPTION value='c'>C</OPTION>
                                    <OPTION value='d'>D</OPTION>
                                    <OPTION value='e'>E</OPTION>
                                    <OPTION value='f'>F</OPTION>
                                    <OPTION value='g'>G</OPTION>
                                    <OPTION value='h'>H</OPTION>
                                    <OPTION value='i'>I</OPTION>
                                    <OPTION value='j'>J</OPTION>
                                    <OPTION value='k'>K</OPTION>
                                    <OPTION value='l'>L</OPTION>
                                    <OPTION value='m'>M</OPTION>
                                    <OPTION value='n'>N</OPTION>
                                    <OPTION value='o'>O</OPTION>
                                    <OPTION value='p'>P</OPTION>
                                    <OPTION value='q'>Q</OPTION>
                                    <OPTION value='r'>R</OPTION>
                                    <OPTION value='s'>S</OPTION>
                                    <OPTION value='t'>T</OPTION>
                                    <OPTION value='u'>U</OPTION>
                                    <OPTION value='v'>V</OPTION>
                                    <OPTION value='w'>W</OPTION>
                                    <OPTION value='x'>X</OPTION>
                                    <OPTION value='y'>Y</OPTION>
                                    <OPTION value='z'>Z</OPTION>
                                </SELECT>
                                <INPUT TYPE="submit" VALUE="Envoyer la requête" onClick="javascript:Envoyer();"/>
                            </FORM>
                        </td>
                        <td rowspan=2 style='border-left: 1px black solid;'>
                            
                            Informations concernant la personne sélectionnée
                            
                        </td>
                    </tr>
                    <tr>
                        <td style='width: 150px; height: 400px; border-top: 1px black solid;'>
                            <FORM>
                                <SELECT size="24" style="width: 150px; height: 395px;">
                                    <% 
                                    List<Membre> nomsMembres = (ArrayList<Membre>) request.getAttribute("nomsMembres");
                                    for(Membre membrre : nomsMembres) { %>
                                    <OPTION><%= membrre.getNom() %></OPTION>
                                 <% } %>
                                </SELECT>
                            </FORM>
                        </td>
                    </tr>
                </table>
            </div>

            <!-- FOOTER : -->
            <jsp:include page ="includes/footer.jsp"/>
        </DIV>
    </body>
</html>
