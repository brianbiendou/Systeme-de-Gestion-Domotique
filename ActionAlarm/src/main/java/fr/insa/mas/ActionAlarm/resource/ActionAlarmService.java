package fr.insa.mas.ActionAlarm.resource;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import fr.insa.mas.ActionAlarm.model.ActionAlarm;

@Service
public class ActionAlarmService {
    private ActionAlarm actionneurState = new ActionAlarm();

    public boolean getActionneurState() {
        return actionneurState.isAlarm();
    }

    public void updateAlarm(boolean alarmOn) {
        actionneurState.setAlarm(alarmOn);
    }
}