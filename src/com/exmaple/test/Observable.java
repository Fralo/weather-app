package com.exmaple.test;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    private List<Observer> observers = new ArrayList<>();

    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }
    public void notifyObservers(Observable arg) {
        for(Observer o : observers) {
            o.update(this, arg);
        }
    }
}
