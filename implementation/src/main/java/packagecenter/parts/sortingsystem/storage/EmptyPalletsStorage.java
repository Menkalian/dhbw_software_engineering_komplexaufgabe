package packagecenter.parts.sortingsystem.storage;

import packagecenter.incomming.*;

public class EmptyPalletsStorage extends Storage<Pallet> implements IEmptyPalletStorage {

    // ToDo - does this make sense either?
    public void store(Pallet pallet) {
        stored.add(pallet);
    }

}