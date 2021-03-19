package packagecenter.parts.delivery.unloading;

import packagecenter.incomming.*;
import packagecenter.parts.delivery.unloading.sensor.*;

public class TruckUnloadingArea implements ITruckUnloadingArea {
    private int id;
    private Truck currentTruck;
    private ITruckUnloadingAreaSensor sensor;

    public void setSensor(ITruckUnloadingAreaSensor sensor) {
        this.sensor = sensor;
    }

    /**
     * 
     * @param id
     */
    public TruckUnloadingArea(int id) {
        // TODO - implement TruckUnloadingArea.TruckUnloadingArea @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param truck
     */
    public void truckArriving(Truck truck) {
        currentTruck = truck;
        sensor.truckArriving();
    }

    public void truckLeaving() {
        // TODO - implement TruckUnloadingArea.truckLeaving @Löh
        throw new UnsupportedOperationException();
    }

    public int getId() {
        return this.id;
    }

    public ITruckUnloadingAreaSensor getSensor() {
        return this.sensor;
    }

    public Truck getCurrentTruck() {
        return this.currentTruck;
    }

}