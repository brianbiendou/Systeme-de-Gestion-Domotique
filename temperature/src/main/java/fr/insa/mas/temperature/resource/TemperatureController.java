package fr.insa.mas.temperature.resource;

import fr.insa.mas.temperature.model.Temperature;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {
    private final TemperatureService temperatureService = new TemperatureService();

    @PostMapping("/internal")
    public void updateInternalTemperature(@RequestBody double temperature) {
        temperatureService.updateInternalTemperature(temperature);
    }

    @PostMapping("/external") 
    public void updateExternalTemperature(@RequestBody double temperature) {
        temperatureService.updateExternalTemperature(temperature);
    }

    @GetMapping("/internal")
    public double getInternalTemperature() {
        return temperatureService.getCurrentTemperature().getInternalTemperature();
    }

    @GetMapping("/external")
    public double getExternalTemperature() {
        return temperatureService.getCurrentTemperature().getExternalTemperature();
    }

    @GetMapping("/latest")
    public Temperature getLatestTemperature() {
        return temperatureService.getCurrentTemperature();
    }
}