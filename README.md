# Weather-App

[![Università degli studi di Firenze](https://i.imgur.com/1NmBfH0.png)](https://ingegneria.unifi.it)

The aim of the project is to test the implementation of the **observer** and the **strategy** pattern.
The **observer** pattern is used to update the WeatherEngine when a Sensor retrieves new data.
The **strategy** patter si used to demand the handling of notification to users at the implementations of various UserNotificationChannel.

The `SensorSimulator` class is a thread used to mimic the sensor update

***Docker***

`docker build . -t weather-app`
`docker run weather-app`
