package packagecenter.parts.delivery.waiting;

import packagecenter.incomming.*;

public class TruckWaitingArea implements ITruckWaitingArea {
    private Truck[] trucks;

    public TruckWaitingArea(int capacity) {
        trucks = new Truck[capacity];
    }

    public Truck[] getTrucks() {
        return this.trucks;
    }

}