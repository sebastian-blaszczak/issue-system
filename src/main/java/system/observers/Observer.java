package system.observers;

public interface Observer<T> {
    void notify(ObserverMethod<T> method);
}
