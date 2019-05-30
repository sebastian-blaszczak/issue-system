package system.exporters.interfaces;

public interface Exporter<R,T> {

    R export(T objectToExport);

}
