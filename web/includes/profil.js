function enableInputs() {
    var nameChamps = 
                 ["badge"            , "Nom"              , "prenom"         , "adresse", "code_postal",
                  "ville"            , "tel"              , "portable"       , "email"  , "prof"       ,
                  "date_naiss"       , "lieu_naiss"       , "carte_fed"      , "user"   , "passwd"];
    for(index = 1; index < nameChamps.length; index++) {
        document.getElementById(nameChamps[index]).disabled = false;
    }
    document.getElementById(nameChamps[13]).disabled = true;
    // change le onClick et le type de submitButton
    document.getElementById("submitButton").innerHTML = '<input type="submit" value="Enregistrer">';
}
function enableInputsAdmin() {
    document.getElementById("badge").disabled = false;
    document.getElementById("Nom").disabled = false;
    document.getElementById("user").disabled = false;
}