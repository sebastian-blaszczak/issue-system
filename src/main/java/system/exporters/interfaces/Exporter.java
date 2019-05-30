package system.exporters;

public interface Exporter<T,R> {

    R export(T obj);

}
