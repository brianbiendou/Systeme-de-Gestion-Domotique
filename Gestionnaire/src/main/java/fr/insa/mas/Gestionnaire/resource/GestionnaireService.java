package fr.insa.mas.Gestionnaire.resource;

import fr.insa.mas.Gestionnaire.model.ActionAlarm;
import java.time.LocalTime;

//ou si vous utilisez déjà d'autres classes de java.time
import java.time.*;
import fr.insa.mas.Gestionnaire.model.ActionFen;
import fr.insa.mas.Gestionnaire.model.PresenceData;
import fr.insa.mas.Gestionnaire.model.Temperature;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GestionnaireService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 10000)
    public void checkSensors() {
        Temperature temperatureData = restTemplate.getForObject("http://localhost:8081/api/temperature/latest", Temperature.class);
        PresenceData presenceData = restTemplate.getForObject("http://localhost:8082/api/presence/latest", PresenceData.class);
        boolean alarmState = restTemplate.getForObject("http://localhost:8084/api/actionalarm/etat", boolean.class);
        boolean fenState = restTemplate.getForObject("http://localhost:8083/api/actionfen/etat", boolean.class);
        LocalTime currentTime = LocalTime.now();
        
        if (temperatureData != null && presenceData != null) {
            double internalTemperature = temperatureData.getInternalTemperature();
            double externalTemperature = temperatureData.getExternalTemperature();
            boolean presence = presenceData.isPresence();
            
            
            System.out.println("TEMP INT : " + internalTemperature);
            System.out.println("TEMP EXT : " + externalTemperature);
            System.out.println("PRES : " + presence +"\n");

         // Dans la logique des fenêtres
            if (externalTemperature < internalTemperature && externalTemperature <= 27 && externalTemperature >= 18 && !fenState) {
                sendActionToActionFen(true);
            } else if (((internalTemperature > externalTemperature && externalTemperature < 13) || !presence) && fenState) {
                sendActionToActionFen(false);
            }

         // Dans la logique de l'alarme
            if (presence && (currentTime.isAfter(LocalTime.of(14, 0)) || currentTime.isBefore(LocalTime.of(6, 0)))) {
               if (!alarmState) sendActionToActionAlarm(true);
            } else if (alarmState) {
               sendActionToActionAlarm(false);
            }
        }
    }

    private void sendActionToActionFen(boolean open) { // Changé en boolean
        try {
            restTemplate.postForObject("http://localhost:8083/api/actionfen/fenetre", 
                open,  // Envoie directement le boolean
                String.class);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'envoi de l'action à la fenêtre : " + e.getMessage());
        }
    }

    private void sendActionToActionAlarm(boolean activate) {
        try {
            restTemplate.postForObject("http://localhost:8084/api/actionalarm/alarm", 
            	activate, 
            	String.class);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'envoi de l'action à l'alarme : " + e.getMessage());
        }
    }
}