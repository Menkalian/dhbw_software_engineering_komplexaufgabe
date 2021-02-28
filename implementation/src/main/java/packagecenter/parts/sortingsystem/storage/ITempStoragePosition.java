package packagecenter.parts.sortingsystem.storage;

import packagecenter.incomming.*;

public interface ITempStoragePosition {

    int getCapacity();

    /**
     * 
     * @param pallet
     */
    void store(Pallet pallet);

    Pallet take();

}