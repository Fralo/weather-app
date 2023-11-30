package it.unifi.weatherapp.test;

import it.unifi.weatherapp.Observable;
import it.unifi.weatherapp.Observer;
import it.unifi.weatherapp.Sensor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {

    @Test
    public void testGetTemperature() {
        double initialTemperature = 25.0;
        Sensor sensor = new Sensor(initialTemperature);
        assertEquals(initialTemperature, sensor.getTemperature(), 0.001);
    }

    @Test
    public void testSetTemperature() {
        double initialTemperature = 25.0;
        Sensor sensor = new Sensor(initialTemperature);

        double newTemperature = 30.0;
        sensor.setTemperature(newTemperature);

        assertEquals(newTemperature, sensor.getTemperature(), 0.001);
    }

    @Test
    public void testObserverNotification() {
        double initialTemperature = 25.0;
        Sensor sensor = new Sensor(initialTemperature);

        MockObserver mockObserver = new MockObserver();
        sensor.addObserver(mockObserver);

        double newTemperature = 30.0;
        sensor.setTemperature(newTemperature);

        assertTrue(mockObserver.isNotified());
    }

    @Test
    public void testObserverNotNotifiedOnSameTemperatureNotification() {
        double initialTemperature = 25.0;
        Sensor sensor = new Sensor(initialTemperature);

        MockObserver mockObserver = new MockObserver();
        sensor.addObserver(mockObserver);

        double newTemperature = 25.0;
        sensor.setTemperature(newTemperature);

        assertFalse(mockObserver.isNotified());
    }

    // MockObserver class to simulate an observer
    private class MockObserver implements Observer {
        private boolean notified = false;

        @Override
        public void update(Observable o, Object arg) {
            notified = true;
        }

        public boolean isNotified() {
            return notified;
        }
    }
}