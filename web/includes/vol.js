function triVols() {
    annee = document.getElementById("annee").value;
    mois  = document.getElementById("mois").value;
    
    select= document.getElementById("vols");
    nbOptions = select.options.length;
    for(i=0; i<nbOptions; i++) {
        option = select.options[i];
        anneeOpt = option.text.substring(0,4);
        moisOpt  = option.text.substring(5,7);
        
        /* ANNEE */
        if(annee === anneeOpt || isNaN(annee)) {
            option.style.display = "";
        } else {
            option.style.display = "none";
        }
        
        /* MOIS */
        if(mois !== moisOpt && !isNaN(mois)) {
            option.style.display = "none";
        }
    }
}

function selectVol(numSeq) {
    
}