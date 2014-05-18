function enableInputs() {
    var nameChamps = 
                 ["immat"            , "type"             , "taux"           , "reduc"];
    for(index = 1; index < nameChamps.length; index++) {
        document.getElementById(nameChamps[index]).disabled = false;
    }
    // change le onClick et le type de submitButton
    document.getElementById("submitButton").innerHTML = '<input type="submit" value="Enregistrer">';
}

function selectAvion(numAvion) {
    ajax("AvionsInfos?numavion="+numAvion, "affichage", "Chargement de l'avion...");
    document.getElementById("delete").setAttribute("onClick", "deleteAvion("+ numAvion +");");
}

function deleteAvion(numAvion) {
    if(confirm("Voulez-vous vraiment supprimer l'avion n°"+ numAvion + "?")) {
        self.location.href= "DeleteAvion?numAvion="+numAvion;
    }
}
