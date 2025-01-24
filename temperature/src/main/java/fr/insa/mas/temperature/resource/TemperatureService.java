package fr.insa.mas.temperature.resource;

import fr.insa.mas.temperature.model.Temperature;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Service
public class TemperatureService {
   private Temperature currentTemperature = new Temperature();
   private final RestTemplate restTemplate = new RestTemplate();

   public Temperature getCurrentTemperature() {
       return currentTemperature;
   }

   public void updateInternalTemperature(double temperature) {
       currentTemperature.setInternalTemperature(temperature);
   }

   public void updateExternalTemperature(double temperature) {
       currentTemperature.setExternalTemperature(temperature); 
   }
}