/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function verif(){
    
    var y = 0;
    var nameChamps = 
             ["badge"            , "Nom"            , "tel"              , 
              "date_naiss"       , "carte_fed"      , "user"   , "passwd"     ];
    for(i=1; i<nameChamps.length; i++){
        if ("" === document.getElementById(nameChamps[i]).value){
            y = y+1;
        }
    }
    if (y === 0)
    {
        return true;
        alert ("oui");
    }
    else{ 
        alert("Des valeurs obligatoires sont vide, merci de les remplir");
        return false;
    }
}
