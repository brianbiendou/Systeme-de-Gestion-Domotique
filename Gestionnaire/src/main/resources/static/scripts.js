const temperatureApi = "http://localhost:8081/api/temperature";
const presenceApi = "http://localhost:8082/api/presence";
const actuatorfenApi = "http://localhost:8083/api/actionfen";
const actuatoralarmApi = "http://localhost:8084/api/actionalarm";

// Température
function updateInternalTemperature() {
    const temperature = document.getElementById("internalTemperature").value;
    fetch(`${temperatureApi}/internal`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ temperature })
    }).then(response => {
        if (response.ok) {
            alert("Température intérieure mise à jour !");
            fetchActuatorState();  // Récupérer l'état des actionneurs après mise à jour
        }
    });
}

function updateExternalTemperature() {
    const temperature = document.getElementById("externalTemperature").value;
    fetch(`${temperatureApi}/external`, {
        method: "POST",
		//mode: "no-cors",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ temperature })
    }).then(response => {
        if (response.ok) {
            alert("Température extérieure mise à jour !");
            fetchActuatorState();  // Récupérer l'état des actionneurs après mise à jour
        }
    });
}

// Présence
function updatePresence() {
    const presence = document.getElementById("presenceStatus").value.toLowerCase() === "true";
    fetch(`${presenceApi}/update`, {
        method: "POST",
		//mode: "no-cors",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ presence })
    }).then(response => {
        if (response.ok) {
            alert("Données de présence mises à jour !");
            fetchActuatorState();  // Récupérer l'état des actionneurs après mise à jour
        }
    });
}

// Récupérer l'état des actionneurs
function fetchActuatorState() {
    fetch(`${actuatorfenApi}/etat`)
        .then(response => response.json())
        .then(data => {
            // Mettre à jour l'état des fenêtres
            document.getElementById("windowState").innerText = 
                `Fenêtre : ${data.fenetreOuverte ? "Ouverte" : "Fermée"}`;
        })
        .catch(error => {
            console.error("Erreur lors de la récupération de l'état de l'actionneur fenetre :", error);
        });
		fetch(`${actuatoralarmApi}/etat`)
		        .then(response => response.json())
		        .then(data => {
		            document.getElementById("alarmState").innerText = 
		                `Alarme : ${data.alarme ? "Activée" : "Désactivée"}`;
		        })
		        .catch(error => {
		            console.error("Erreur lors de la récupération de l'état de l'actionneur alarme:", error);
		        });
}



// Initialisation - Mettre à jour l'état des actionneurs au chargement de la page
fetchActuatorState();
