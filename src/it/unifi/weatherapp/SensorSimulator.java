package it.unifi.weatherapp;

public class SensorSimulator extends Thread {


    private boolean isStopped;
    private final Sensor sensor;

    public SensorSimulator(Sensor s) {
        this.isStopped = false;
        this.sensor = s;
    }

    public void stopSimulating() {
        this.isStopped = true;
        this.interrupt();
    }

    @Override
    public void run(){
        while(!this.isStopped) {
            try {
                sensor.setTemperature(Math.random() * 30);
                Thread.sleep(2000);
            }catch(InterruptedException es) {
                System.out.println(es.getMessage());
            }
        }
    }
}
