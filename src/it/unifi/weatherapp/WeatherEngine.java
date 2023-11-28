package it.unifi.weatherapp;

import java.util.ArrayList;
public class WeatherEngine implements Observer {

    final static double BIG_TEMPERATURE_DELTA = 10;
    private double temperature;
    private final ArrayList<UserNotificationChannel> usersChannels;

    public WeatherEngine() {
        this.usersChannels = new ArrayList<>();
    }

    public void addUser(UserNotificationChannel unc) {
        this.usersChannels.add(unc);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureString() {
        return String.valueOf(this.temperature) + "°C";
    }

    @Override
    public void update(Observable o, Object arg) {

        double oldTemperature = this.temperature;

        if (o instanceof Sensor s) {
            this.setTemperature(s.getTemperature());
        }

        this.writeData();
        if (this.isBigChange(oldTemperature, this.temperature)) {
            this.notifyUsers();
        }
    }

    public boolean isBigChange(double oldTemperature, double newTemperature) {
        return Math.abs(oldTemperature - newTemperature) > WeatherEngine.BIG_TEMPERATURE_DELTA;
    }

    public void notifyUsers() {
        for (UserNotificationChannel unc : this.usersChannels) {
            unc.notify(this.getTemperatureString());
        }
    }

    public void writeData() {
        System.out.println("LOG: Sono " + this.getTemperatureString());
    }
}
