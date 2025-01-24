package fr.insa.mas.ActionFen.resource;

import fr.insa.mas.ActionFen.model.ActionFen;
import org.springframework.web.bind.annotation.*;
import fr.insa.mas.ActionFen.resource.ActionFenService;

//@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/actionfen")
public class ActionFenController {

    private final ActionFenService actionfenService;

    public ActionFenController(ActionFenService actionfenService) {
        this.actionfenService = actionfenService;
    }

    // Endpoint pour récupérer l'état actuel des actionneurs
    @GetMapping("/etat")
    public boolean getEtat() {
        return actionfenService.getActionneurState();
    }

    // Endpoint pour mettre à jour l'état de la fenêtre
    @PostMapping("/fenetre")
    public void updateFenetre(@RequestBody boolean fenetreOuverte) {
        actionfenService.updateFenetre(fenetreOuverte);
    }

    /*
    // Classe interne pour recevoir les données JSON de la fenêtre
    public static class FenetreRequest {
        private boolean fenetreOuverte;

        public boolean isFenetreOuverte() {
            return fenetreOuverte;
        }

        public void setFenetreOuverte(boolean fenetreOuverte) {
            this.fenetreOuverte = fenetreOuverte;
        }
    }
    */
}
