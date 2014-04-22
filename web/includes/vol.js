function triVols() {
    annee = document.getElementById("annee").value;
    mois  = document.getElementById("mois").value;
    
    select= document.getElementById("vols");
    nbOptions = select.options.length;
    for(i=0; i<nbOptions; i++) {
        option = select.options[i];
        anneeOpt = option.text.substring(0,4);
        moisOpt  = option.text.substring(5,7);
        
        display = "";
        
        /* ANNEE */
        if(annee !== anneeOpt && !isNaN(annee)) {
            display = "none";
        }
        
        /* MOIS */
        if(mois !== moisOpt && !isNaN(mois)) {
            display = "none";
        }
        
        option.style.display = display;
    }
}

function selectVol(numSeq) {
    ajax("InfosSeqVol?numseq="+numSeq, "affichage", "Chargement de la sequence de vol...");
}