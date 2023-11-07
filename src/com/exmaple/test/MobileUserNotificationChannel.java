package com.exmaple.test;

public class MobileUserNotificationChannel implements UserNotificationChannel {
    private String userId;

    public MobileUserNotificationChannel(String userId) {
        this.userId = userId;
    }

    @Override
    public void notify(String temperature) {
        System.out.println("Notification sent to User " + this.userId + " --> content: The temperature is " + temperature);
    }
}
