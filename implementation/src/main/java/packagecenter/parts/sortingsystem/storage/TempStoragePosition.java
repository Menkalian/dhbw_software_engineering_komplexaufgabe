package packagecenter.parts.sortingsystem.storage;

import packagecenter.incomming.*;

public class TempStoragePosition implements ITempStoragePosition {
    private java.util.Deque<Pallet> pallets;

    public int getCapacity() {
        return 2-pallets.size();
    }

    public void store(Pallet pallet) {
        if(pallets.size()<2){
            pallets.add(pallet);
        }
    }

    public Pallet take() {
        if(pallets.size()>0){
            return pallets.pop();
        }else return null;
    }

}