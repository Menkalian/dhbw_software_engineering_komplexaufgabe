package packagecenter.parts.delivery.unloading;

import packagecenter.incomming.Truck;
import packagecenter.parts.delivery.unloading.sensor.ITruckUnloadingAreaSensor;
import packagecenter.parts.delivery.unloading.sensor.TruckUnloadingAreaSensor;

public class TruckUnloadingArea implements ITruckUnloadingArea {
    private final int id;
    private Truck currentTruck;
    private ITruckUnloadingAreaSensor sensor;

    public void setSensor(ITruckUnloadingAreaSensor sensor) {
        this.sensor = sensor;
    }

    public TruckUnloadingArea(int id) {
        this.id = id;
        this.sensor = new TruckUnloadingAreaSensor();
    }

    public void truckArriving(Truck truck) {
        currentTruck = truck;
        sensor.truckArriving();
    }

    public void truckLeaving() {
        currentTruck = null;
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