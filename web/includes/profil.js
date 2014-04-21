function enableInputs() {
    var nameChamps = 
                 ["badge"            , "nom"              , "prenom"         , "adresse", "code_postal",
                  "ville"            , "tel"              , "portable"       , "email"  , "prof"       ,
                  "date_naiss"       , "lieu_naiss"       , "carte_fed"      , "user"   , "passwd"     , "mail"];
    for(index = 1; index < nameChamps.length; index++) {
        document.getElementById(nameChamps[index]).disabled = false;
    }
    // change le onClick et le type de submitButton
    document.getElementById("submitButton").innerHTML = '<input type="submit" value="Enregistrer">';
}