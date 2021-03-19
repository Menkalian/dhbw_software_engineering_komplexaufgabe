package packagecenter.incomming;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private final String id;
    private final TruckTrailer trailer;

    public String getId() {
        return this.id;
    }

    public TruckTrailer getTrailer() {
        return this.trailer;
    }

    public List<Pallet> getPallets() {
        List<Pallet> palletList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if(trailer.leftSide[i] != null) {
                palletList.add(trailer.leftSide[i]);
                trailer.leftSide[i] = null;
            }
            if(trailer.rightSide[i] != null) {
                palletList.add(trailer.rightSide[i]);
                trailer.rightSide[i] = null;
            }
        }

        return palletList;
    }

    public static class TruckTrailer {
        private final Pallet[] leftSide = new Pallet[5];
        private final Pallet[] rightSide = new Pallet[5];

        public Pallet[] getLeftSide() {
            return this.leftSide;
        }

        public Pallet[] getRightSide() {
            return this.rightSide;
        }

    }

    public Truck (String id) {
        this.id = id;
        trailer = new TruckTrailer();
    }

    public boolean addPalletToTruck(Pallet pallet, String side, int pos){
        if(pos>=0 && pos<5) {
            if (side.equals("left")){
                trailer.leftSide[pos] = pallet;
                return true;
            } else if (side.equals("right")){
                trailer.rightSide[pos] = pallet;
                return true;
            }
        }
        return false;
    }

}