package fr.insa.mas.Gestionnaire.model;

public class PresenceData {
    private boolean presence;
    private String timestamp;

    public PresenceData() {}

    public PresenceData(boolean presence, String timestamp) {
        this.presence = presence;
        this.timestamp = timestamp;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
