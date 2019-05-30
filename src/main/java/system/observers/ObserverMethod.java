package system.observers;

@FunctionalInterface
public interface ObserverMethod<T> {
    T execute();
}
