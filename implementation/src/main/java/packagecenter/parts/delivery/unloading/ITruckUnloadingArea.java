package packagecenter.parts.delivery.unloading;

import packagecenter.parts.delivery.unloading.sensor.*;
import packagecenter.incomming.*;

public interface ITruckUnloadingArea {

    int getId();

    ITruckUnloadingAreaSensor getSensor();

    Truck getCurrentTruck();

    /**
     * 
     * @param truck
     */
    void truckArriving(Truck truck);

    void truckLeaving();

}