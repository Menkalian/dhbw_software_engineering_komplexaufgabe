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
        private Pallet[] leftSide;
        private Pallet[] rightSide;

        public Pallet[] getLeftSide() {
            return this.leftSide;
        }

        public Pallet[] getRightSide() {
            return this.rightSide;
        }

    }

}