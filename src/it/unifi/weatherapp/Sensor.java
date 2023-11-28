package it.unifi.weatherapp;

public class Sensor extends Observable {

    private double temperature;

    public Sensor(double temperature) {
        this.setTemperature(temperature);
    }

    public void setTemperature(double temperature) {
        if(temperature == this.temperature) {
            return;
        }
        this.temperature = temperature;
        this.notifyObservers(this);
    }

    public double getTemperature() {
        return this.temperature;
    }
}
