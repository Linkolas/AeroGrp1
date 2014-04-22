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

function selectMembre(numSeq) {
    ajax("InfosMembre?numseq="+numSeq, "affichage", "Chargement de la sequence de vol...");
}