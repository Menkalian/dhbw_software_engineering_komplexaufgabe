package packagecenter.parts.sortingsystem.storage;

public abstract class Storage<T> {
    protected java.util.List<T> stored;

    public java.util.List<T> getStored() {
        return this.stored;
    }

    /**
     * 
     * @param element
     */
    public void store(T element) {
        // TODO - implement Storage.store @Löh
        throw new UnsupportedOperationException();
    }

}