package fr.insa.mas.ActionFen.resource;

import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.ActionFen.model.ActionFen;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@Service
public class ActionFenService {
    private ActionFen actionneurState = new ActionFen();
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean getActionneurState() {
        return actionneurState.isFenetreOuverte();
    }

    public void updateFenetre(boolean fenetreOuverte) {
        actionneurState.setFenetreOuverte(fenetreOuverte);
    }
}

