function enableInputs() {
    var nameChamps = 
                 ["immat"            , "type"             , "taux"           , "reduc"];
    for(index = 1; index < nameChamps.length; index++) {
        document.getElementById(nameChamps[index]).disabled = false;
    }
    // change le onClick et le type de submitButton
    document.getElementById("submitButton").innerHTML = '<input type="submit" value="Enregistrer">';
}


