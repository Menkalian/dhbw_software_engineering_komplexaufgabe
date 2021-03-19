package packagecenter.event.delivery;

import packagecenter.event.*;
import packagecenter.parts.IPackageSortingCenter;

public class UnloadTruckEvent extends Event {
    private final String carId;
    private final int areaId;
    private final IPackageSortingCenter packageSortingCenter;

    public String getCarId() {
        return this.carId;
    }

    public int getAreaId() {
        return this.areaId;
    }

    public IPackageSortingCenter getPackageSortingCenter() {
        return packageSortingCenter;
    }

    public UnloadTruckEvent(String carId, int areaId, IPackageSortingCenter packageSortingCenter) {
        this.carId = carId;
        this.areaId = areaId;
        this.packageSortingCenter = packageSortingCenter;
    }

}