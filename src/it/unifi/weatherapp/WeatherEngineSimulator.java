package it.unifi.weatherapp;

public class WeatherEngineSimulator {
    public static void main(String[] args) {

        Sensor s = new Sensor(23.3);

        WeatherEngine we = new WeatherEngine();
        s.addObserver(we);

        SensorSimulator simulator = new SensorSimulator(s);

        simulator.start();

        we.addUser(new MailUserNotificationChannel("leonardo.fralini@edu.unifi.it"));
        we.addUser(new MailUserNotificationChannel("marco.rossi@gmail.com"));
        we.addUser(new MobileUserNotificationChannel("9843"));
        we.addUser(new MobileUserNotificationChannel("7342"));
    }
}
