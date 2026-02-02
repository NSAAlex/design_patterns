package Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    /**
     * Notifies all registered observers of a state change.
     * 
     * @param cry The type of cry that triggered the notification
     */
    void notifyObservers(Cry cry);
}