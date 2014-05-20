function ajax (url, id, loading) {
	
	if(loading == undefined) {
		loading = "Chargement...";
	}
	
	
	/* Objet REQUEST */
	if (this.m_Request != undefined) {
		this.m_Request.abort();
		delete this.m_Request;
    }
	if (window.XMLHttpRequest) {
		/* Mozilla, Firefox, Opera et le reste du monde. */
		m_Request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
		/* IE */
		m_Request = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
		alert('Navigateur incompatible !');
	}
	
	/* Au changement d'état de REQUEST */
	m_Request.onreadystatechange = function() {
		if (m_Request.readyState == 4) {
			
			/* On regarde pour 0 à cause d'un bug dans Firefox. */
			if (m_Request.status == 200 || m_Request.status == 0) {
				
				/* Tout s'est bien passé : */
				document.getElementById(id).innerHTML = m_Request.responseText; // innerHTML : remplace le contenu d'une balise
				
			} else {
				document.getElementById(id).innerHTML = "Erreur 404";
			}
			
			delete m_Request;
			
		} else {
			document.getElementById(id).innerHTML = loading;
		}
	};
	
	/* ENVOI de REQUEST */
	this.m_Request.open("POST", url, true);
    this.m_Request.send();
}