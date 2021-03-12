package packagecenter.parts.sortingsystem.storage;

public abstract class Storage<T> {
    protected java.util.List<T> stored;

    public java.util.List<T> getStored() {
        return this.stored;
    }

    public abstract void store(T element);

}