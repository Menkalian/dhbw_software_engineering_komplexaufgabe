package packagecenter.incomming;

public class Truck {
    private String id;
    private TruckTrailer trailer;

    public String getId() {
        return this.id;
    }

    public TruckTrailer getTrailer() {
        return this.trailer;
    }

    public class TruckTrailer {
        private Pallet[] leftSide = new Pallet[5];
        private Pallet[] rightSide = new Pallet[5];

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