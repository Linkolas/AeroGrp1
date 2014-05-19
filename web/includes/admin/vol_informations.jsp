<%-- 
    Document   : footer
    Created on : 19 déc. 2013, 14:43:15
    Author     : nicolas.pendon
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.domaine.Avion"%>
<%@page import="com.domaine.Instructeur"%>
<%@page import="com.domaine.Vol"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Vol vol = (Vol) request.getAttribute("vol");
if(vol == null) {
    out.println("Cliquez sur une séquence de vol <BR/> pour afficher ses informations.");
} else {
%>

<FORM name="sequenceVol" action="UpdateVol" method="POST">
    <span style="font-size: 170%;">Vol numéro <%= (vol.getNum() < 0 ? "(Nouveau)" : vol.getNum()) %></span>
    <BR/>
    <%
    Date date = vol.getDate();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dateStr = simpleDateFormat.format(date);;
    %>
    
    en date du <INPUT TYPE="text" name="date" value="<%= dateStr %>"/>
    <BR/>
    <BR/>
    <TABLE style='margin-left: auto; margin-right: auto; text-align: left;'>
        <TR>
            <TD>
                Temps passé en vol : 
            </TD>
            <TD>
                <INPUT TYPE="text" name="tempsVol" VALUE="<%= vol.getTemps() %>" size="3"/> heure(s)
            </TD>
            <TD>
                dont comprises dans un forfait : 
            </TD>
            <TD>
                <INPUT TYPE="text" name="tempsForfait" VALUE="<%= vol.getHeuresForfait() %>" size="3"/> heure(s)
            </TD>
        </TR>
        <TR>
            <TD>
                Prix spécial : 
            </TD>
            <TD>
                <SELECT name="isPrixSpecial">
                    <OPTION<%= (vol.getPrixSpecial() < 0  ? " SELECTED" : "") %> value="-1">Aucun</OPTION>
                    <OPTION<%= (vol.getPrixSpecial() >= 0 ? " SELECTED" : "") %> value= "1">Définit à</OPTION>
                </SELECT>
                <BR/>
                <INPUT TYPE="text" value="<%= (vol.getPrixSpecial() >= 0 ? vol.getPrixSpecial() : "") %>" name="prixSpecial" size="6"/>€
            </TD>
            <TD>
                Motif : 
            </TD>
            <TD>
                <INPUT TYPE="text" name="motif" value="<%= vol.getMotif() %>"/>
            </TD>
        </TR>
    </TABLE>
    <BR/>
    <BR/>
    <%
    Instructeur in = (Instructeur) request.getAttribute("instructeur");
    %>
    <TABLE style='text-align: left; width: 350px; float: left;'>
        <TR>
            <TD>Instructeur n°
                <SELECT name="instructeur">
                    <OPTION value="-1">Aucun</OPTION>
                    <%
                    List<Instructeur> instructeurs = (List<Instructeur>) request.getAttribute("instructeurs");
                    String select;
                    for(Instructeur instruc : instructeurs) {
                        select = "";
                        if(in != null) {
                            if(in.getNumInstructeur() == instruc.getNumInstructeur()) {
                                select = "SELECTED";
                            }
                        } %>
                    <OPTION VALUE="<%= instruc.getNumInstructeur() %>" <%= select %>><%= ((String) (instruc.getNumInstructeur()+" ("+instruc.getPrenom()+" "+instruc.getNom()+")")) %></OPTION>
                    <%
                    }
                    %>
                </SELECT>
            </TD>
        </TR>
        <TR>
            <TD>Prix à l'heure retenu : <INPUT TYPE="text" name="tauxInstructeur" value="<%= (vol.getTauxInstructeur() > 0 ? vol.getTauxInstructeur() : "Auto") %>" size="5"/>€/h</TD>
        </TR>
    </TABLE>
    <%
    Avion av = (Avion) request.getAttribute("avion");
    %>
    <TABLE style='text-align: left; width: 350px; float: right;'>
        <TR>
            <TD>Avion n°
                <SELECT name="avion">
                    <%
                    List<Avion> avions = (List<Avion>) request.getAttribute("avions");
                    for(Avion avion : avions) {
                        select = "";
                        if(avion != null) {
                            if(av.getNum_avion() == avion.getNum_avion()) {
                                select = "SELECTED";
                            }
                        } %>
                    <OPTION VALUE="<%= avion.getNum_avion() %>" <%= select %>><%= ((String) (avion.getNum_avion()+" ("+avion.getType_avion()+")")) %></OPTION>
                    <%
                    }
                    %>
                </SELECT>
            </TD>
        </TR>
        <TR>
            <TD>Prix à l'heure : <INPUT TYPE="text" name="tauxAvion" value="<%= (av.getNum_avion() >= 0 ? vol.getTaux() : "Auto") %>" size="5"/>€/h</TD>
        </TR>
        <TR>
            <TD>Reduction horaire : <INPUT TYPE="text" name="reducSemaine" value="<%= (av.getNum_avion() >= 0 ? vol.getReductionSemaine(): "Auto") %>" size="5"/>€/h</TD>
        </TR>
    </TABLE>
    <INPUT TYPE="hidden" name="numSeqVol" value="<%= (av != null ? vol.getNum() : "-1") %>"/>
    <INPUT TYPE="hidden" name="membre"    value="<%= request.getAttribute("membre") %>"/>
    <div style="clear: both;"></div>
    <BR/>
    <BR/>
    <% if(av.getNum_avion() >= 0) { 
    %>
        Coût total :
        <TABLE style="margin-left: auto; margin-right: auto; width: 500px;">
            <TR>
                <TD>Avion</TD>
                <TD><%= vol.getTaux()-vol.getReductionSemaine() %> €/h</TD>
            </TR>
            <%
            if(in != null) {
            %>
            <TR>
                <TD>Instructeur</TD>
                <TD><%= vol.getTauxInstructeur() %> €/h</TD>
            </TR>
            <%
            }
            %>
            <TR>
                <TD>Heures de vol</TD>
                <TD><%= vol.getTemps() %></TD>
            </TR>
        </TABLE>
        <%
        if(vol.getPrixSpecial() < 0) {
            float total = vol.getTaux()-vol.getReductionSemaine();
            if(in != null) total += vol.getTauxInstructeur();
            total *= vol.getTemps()-vol.getHeuresForfait();
            out.println("TOTAL : "+total+" €");
        } else {
            out.println("TOTAL : "+vol.getPrixSpecial()+" € (prix spécial)");
        }
    } %>
    <BR/>
    <BR/>
    <INPUT TYPE="submit" value="Enregistrer"/>
</FORM>
<%
}
%>