package Observer;

import java.util.ArrayList;
import java.util.Random;

public class Baby implements Subject {
    private String name;
    private ArrayList<Observer> observers;
    private Random rand;
    
    public Baby(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
        this.rand = new Random();
    }
    
    public String getName() {
        return name;
    }
    
    public void receiveLove() {
        System.out.println(name + " received love and feels better!");
    }
    
    public void eat() {
        System.out.println(name + " is eating and feels satisfied!");
    }
    
    public void getChanged() {
        System.out.println(name + " got a fresh diaper and feels comfortable!");
    }
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(Cry cry) {
        for (Observer observer : observers) {
            observer.update(cry, this);
        }
    }
    
    public void angryCry() {
        System.out.println("\n" + name + " cries angrily!");
        notifyObservers(Cry.ANGRY);
    }
    
    public void hungryCry() {
        System.out.println("\n" + name + " cries hungrily!");
        notifyObservers(Cry.HUNGRY);
    }
    
    public void wetCry() {
        System.out.println("\n" + name + " cries because they're wet!");
        notifyObservers(Cry.WET);
    }
}