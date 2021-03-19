package packagecenter.parts;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;
import packagecenter.parts.delivery.unloading.ITruckUnloadingArea;
import packagecenter.parts.delivery.waiting.IParkingZone;
import packagecenter.parts.delivery.waiting.ITruckWaitingArea;
import packagecenter.parts.sortingsystem.ISortingSystem;

public interface IPackageSortingCenter {

    ICentralControlUnit getCentralControlUnit();

    ITruckUnloadingArea getUnloadingArea(int index);

    ITruckWaitingArea getWaitingArea();

    ISortingSystem getSortingSystem();

    int getCompletedTruckloads();

    void truckloadComplete();

    IParkingZone getParkingZone();
}