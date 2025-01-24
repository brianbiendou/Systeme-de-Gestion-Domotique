package fr.insa.mas.temperature.model;

import java.time.LocalDateTime;

public class Temperature {
    private double internalTemperature;
    private double externalTemperature;
    private LocalDateTime timestamp;

    public Temperature() {
        this.timestamp = LocalDateTime.now(); // Initialisation au moment de la création
    }

    public double getInternalTemperature() {
        return internalTemperature;
    }

    public void setInternalTemperature(double internalTemperature) {
        this.internalTemperature = internalTemperature;
        this.timestamp = LocalDateTime.now(); // Met à jour le timestamp
    }

    public double getExternalTemperature() {
        return externalTemperature;
    }

    public void setExternalTemperature(double externalTemperature) {
        this.externalTemperature = externalTemperature;
        this.timestamp = LocalDateTime.now(); // Met à jour le timestamp
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
