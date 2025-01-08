package it.unifi.weatherapp.test;

import it.unifi.weatherapp.UserNotificationChannel;
import it.unifi.weatherapp.WeatherEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeatherEngineTest {
    @Test
    void testGetTemperatureString() {
        WeatherEngine weatherEngine = new WeatherEngine();
        double temperature = 20.5;

        weatherEngine.setTemperature(temperature);
        assertEquals("20.5°C", weatherEngine.getTemperatureString());
    }

    @Test
    void testIsBigChange() {
        WeatherEngine weatherEngine = new WeatherEngine();
        double oldTemperature = 20.0;
        double newTemperature1 = 32.0;
        double newTemperature2 = 21.0;

        assertTrue(weatherEngine.isBigChange(oldTemperature, newTemperature1));
        assertFalse(weatherEngine.isBigChange(oldTemperature, newTemperature2));
    }

    @Test
    void testNotifyUsers() {
        WeatherEngine weatherEngine = new WeatherEngine();
        MockUserNotificationChannel userChannel = new MockUserNotificationChannel();
        weatherEngine.addUser(userChannel);

        double temperature = 30.0;
        weatherEngine.setTemperature(temperature);
        weatherEngine.notifyUsers();

        assertEquals(userChannel.getNotification(), "30.0°C");
    }

}

// Mock class for UserNotificationChannel
class MockUserNotificationChannel implements UserNotificationChannel {
    private String notification;

    @Override
    public void notify(String message) {
        this.notification = message;
    }

    public String getNotification() {
        return notification;
    }
}