package system.observers;


public interface Subject {

    //Subscribe
    void assignToSubject(Observer o);
    //Unsubscribe
    void unassignFromSubject(Observer o);
    //Notify
    void notifyObservers();
}
