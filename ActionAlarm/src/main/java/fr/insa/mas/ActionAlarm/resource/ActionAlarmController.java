package fr.insa.mas.ActionAlarm.resource;

import fr.insa.mas.ActionAlarm.model.ActionAlarm;

import fr.insa.mas.ActionAlarm.resource.ActionAlarmService;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/actionalarm")
public class ActionAlarmController {

    private final ActionAlarmService actionalarmService;

    public ActionAlarmController(ActionAlarmService actionalarmService) {
        this.actionalarmService = actionalarmService;
    }

    // Endpoint pour récupérer l'état actuel des actionneurs
    @GetMapping("/etat")
    public boolean getEtat() {
        return actionalarmService.getActionneurState();
    }


    // Endpoint pour mettre à jour l'état de l'alarme
    @PostMapping("/alarm")
    public void updateAlarm(@RequestBody boolean alarmeActivee) {
        actionalarmService.updateAlarm(alarmeActivee);
    }


}
