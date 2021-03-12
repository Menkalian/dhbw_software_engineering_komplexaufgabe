package packagecenter.parts.sortingsystem.storage;

import packagecenter.incomming.*;

public class EmptyBoxesStorage extends Storage<Box> implements IEmptyBoxesStorage {

    // ToDo - Does this make sense
    public void store(Box box) {
        stored.add(box);
    }

}