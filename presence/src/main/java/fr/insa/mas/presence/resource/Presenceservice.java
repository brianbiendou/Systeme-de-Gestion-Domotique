package fr.insa.mas.presence.resource;

import fr.insa.mas.presence.model.Presence;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Presenceservice {
   private Presence currentPresence = new Presence(false, null);
   private final RestTemplate restTemplate = new RestTemplate();

   public Presence getCurrentPresence() {
       return currentPresence; 
   }

   public void updatePresence(boolean presence) {
       currentPresence.setPresence(presence);
       currentPresence.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
   }
}