function triMembres() {
    lettre = document.getElementById("lettre").value;
    
    select= document.getElementById("nom");
    nbOptions = select.options.length;
    for(i=0; i<nbOptions; i++) {
        option = select.options[i];
        lettreOpt = option.text.substring(0,1);
        
        if(lettre === lettreOpt || lettre === "*") {
            option.style.display = "";
        } else {
            option.style.display = "none";
        }
    }
}

function choixMembre() {
    numMem = document.getElementById("nom").value;
    
    document.getElementById("admin_profil").setAttribute("onClick", "ajax('AdminProfil?membre="+numMem+"', 'resultat');");
    document.getElementById("admin_compte").setAttribute("onClick", "ajax('AdminCompte?membre="+numMem+"', 'resultat');");
    document.getElementById("admin_vols").setAttribute("onClick", "ajax('AdminVols?membre="+numMem+"', 'resultat');");
}
