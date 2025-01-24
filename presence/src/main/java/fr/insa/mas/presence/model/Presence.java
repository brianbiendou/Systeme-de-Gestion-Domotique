package fr.insa.mas.presence.model;

public class Presence {
    private boolean presence;
    private String timestamp;

    public Presence(boolean presence, String timestamp) {
		super();
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
