package it.unifi.weatherapp;

public class MailUserNotificationChannel implements UserNotificationChannel {

    private String email;

    public MailUserNotificationChannel(String email) {
        this.email = email;
    }

    @Override
    public void notify(String temperature) {
        System.out.println("Email sent to " + this.email + " --> content: The temperature is " + temperature);
    }


}
