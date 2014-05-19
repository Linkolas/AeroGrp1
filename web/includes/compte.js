function triOperationsCompte() {
    annee = document.getElementById("annee").value;
    mois  = document.getElementById("mois").value;
    
    table = document.getElementById("compte");
    nbRows= table.tBodies[0].rows.length;
    for(i=0; i<nbRows; i++) {
        row = table.rows[i+1];
        anneeRow = row.cells[1].innerHTML.substring(0,4);
        moisRow  = row.cells[1].innerHTML.substring(5,7);
        
        display = "";
        
        /* ANNEE */
        if(annee !== anneeRow && !isNaN(annee)) {
            display = "none";
        }
        
        /* MOIS */
        if(mois !== moisRow && !isNaN(mois)) {
            display = "none";
        }
        
        row.style.display = display;
    }
}

function triOperationsCompteAdmin() {
    annee = document.getElementById("annee").value;
    mois  = document.getElementById("mois").value;
    
    table = document.getElementById("compte");
    nbRows= table.tBodies[0].rows.length;
    for(i=0; i<nbRows; i++) {
        row = table.rows[i+1];
        anneeRow = row.cells[1].firstChild.innerHTML.substring(0,4);
        moisRow  = row.cells[1].firstChild.innerHTML.substring(5,7);
        
        display = "";
        
        /* ANNEE */
        if(annee !== anneeRow && !isNaN(annee)) {
            display = "none";
        }
        
        /* MOIS */
        if(mois !== moisRow && !isNaN(mois)) {
            display = "none";
        }
        
        row.style.display = display;
    }
}

function deleteCompteOpe(num) {
    if(confirm("Voulez-vous vraiment supprimer l'opération n°"+ num + " ?")) {
        self.location.href = "AdminCompteDelOpe?numope="+num;
    }
}