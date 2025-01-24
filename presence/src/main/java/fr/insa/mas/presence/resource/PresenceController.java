package fr.insa.mas.presence.resource;

import fr.insa.mas.presence.model.Presence;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presence")
public class PresenceController {
    private final Presenceservice presenceService;

    public PresenceController(Presenceservice presenceService) {
        this.presenceService = presenceService;
    }

    @PostMapping("/update")
    public void updatePresence(@RequestBody boolean presence) {
        presenceService.updatePresence(presence);
    }

    @GetMapping("/latest")
    public Presence getPresence() {
        return presenceService.getCurrentPresence();
    }
}