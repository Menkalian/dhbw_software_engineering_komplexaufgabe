package packagecenter.parts;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;
import packagecenter.parts.delivery.unloading.ITruckUnloadingArea;
import packagecenter.parts.delivery.waiting.IParkingZone;
import packagecenter.parts.delivery.waiting.ITruckWaitingArea;
import packagecenter.parts.sortingsystem.ISortingSystem;

import java.util.List;

public class PackageSortingCenter implements IPackageSortingCenter {
    private List<ITruckUnloadingArea> unloadingAreas = new java.util.ArrayList<>(7);
    private ICentralControlUnit centralControlUnit;
    private ITruckWaitingArea waitingArea;
    private ISortingSystem sortingSystem;
    private IParkingZone parkingZone;
    private int completedTruckloads;

    public List<ITruckUnloadingArea> getUnloadingAreas() {
        return this.unloadingAreas;
    }

    public ITruckWaitingArea getWaitingArea() {
        return this.waitingArea;
    }

    public IParkingZone getParkingZone() {
        return this.parkingZone;
    }

    public int getCompletedTruckloads() {
        return this.completedTruckloads;
    }

    /**
     * 
     * @param centralControlUnit
     * @param parkingZone
     * @param sortingSystem
     * @param unloadingAreas
     */
    private PackageSortingCenter(ICentralControlUnit centralControlUnit, IParkingZone parkingZone, ISortingSystem sortingSystem, java.util.List<ITruckUnloadingArea> unloadingAreas) {
        // TODO - implement PackageSortingCenter.PackageSortingCenter @Löh
        throw new UnsupportedOperationException();
    }

    public ICentralControlUnit getCentralControlUnit() {
        return this.centralControlUnit;
    }

    /**
     * 
     * @param index
     */
    public ITruckUnloadingArea getUnloadingArea(int index) {
        // TODO - implement PackageSortingCenter.getUnloadingArea @Löh
        throw new UnsupportedOperationException();
    }

    public ISortingSystem getSortingSystem() {
        return this.sortingSystem;
    }

    public static class Builder {
        private int amountAutonomousCarSpots;
        private int amountUnloadingAreas;
        private int capacityWaitingArea;

        /**
         * 
         * @param amount
         */
        public Builder amountAutonomousCarSpots(int amount) {
            // TODO - implement Builder.amountAutonomousCarSpots @Löh
            throw new UnsupportedOperationException();
        }

        /**
         * 
         * @param amount
         */
        public Builder amountUnloadingAreas(int amount) {
            // TODO - implement Builder.amountUnloadingAreas @Löh
            throw new UnsupportedOperationException();
        }

        /**
         * 
         * @param capacity
         */
        public Builder capacityWaitingArea(int capacity) {
            // TODO - implement Builder.capacityWaitingArea @Löh
            throw new UnsupportedOperationException();
        }

        public PackageSortingCenter build() {
            // TODO - implement Builder.build @Löh
            throw new UnsupportedOperationException();
        }

    }

}