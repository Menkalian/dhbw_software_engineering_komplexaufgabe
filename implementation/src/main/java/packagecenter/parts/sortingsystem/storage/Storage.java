package packagecenter.parts.sortingsystem.storage;

import java.util.LinkedList;

public abstract class Storage<T> {
    protected java.util.List<T> stored = new LinkedList<>();

    public java.util.List<T> getStored() {
        return this.stored;
    }

    public void store(T element) {
        stored.add(element);
    }

}