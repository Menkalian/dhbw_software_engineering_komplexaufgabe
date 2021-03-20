package packagecenter.parts;

import packagecenter.event.delivery.TruckArrivingEvent;
import packagecenter.parts.controlling.controlunit.CentralControlUnit;
import packagecenter.parts.controlling.controlunit.ICentralControlUnit;
import packagecenter.parts.delivery.unloading.AutonomousCar;
import packagecenter.parts.delivery.unloading.ITruckUnloadingArea;
import packagecenter.parts.delivery.unloading.TruckUnloadingArea;
import packagecenter.parts.delivery.waiting.IParkingZone;
import packagecenter.parts.delivery.waiting.ITruckWaitingArea;
import packagecenter.parts.delivery.waiting.ParkingZone;
import packagecenter.parts.delivery.waiting.TruckWaitingArea;
import packagecenter.parts.sortingsystem.ISortingSystem;
import packagecenter.parts.sortingsystem.SortingSystem;
import packagecenter.parts.sortingsystem.UnboxingRobot;
import packagecenter.parts.sortingsystem.storage.EmptyBoxesStorage;
import packagecenter.parts.sortingsystem.storage.EmptyPalletsStorage;
import packagecenter.parts.sortingsystem.storage.IEmptyBoxesStorage;
import packagecenter.parts.sortingsystem.storage.IEmptyPalletStorage;
import packagecenter.parts.sortingsystem.storage.ITempStorageArea;
import packagecenter.parts.sortingsystem.storage.TempStorageArea;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrack;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrackExpress;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrackNormal;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrackValue;
import packagecenter.parts.sortingsystem.tracks.storage.IStorageTrack;
import packagecenter.parts.sortingsystem.tracks.storage.StorageTrack;
import packagecenter.parts.sortingsystem.tracks.storage.sensor.StorageTrackSensor;

import java.util.ArrayList;
import java.util.List;

public class PackageSortingCenter implements IPackageSortingCenter {
    private final List<ITruckUnloadingArea> unloadingAreas;
    private final ICentralControlUnit centralControlUnit;
    private final ITruckWaitingArea waitingArea;
    private final ISortingSystem sortingSystem;
    private final IParkingZone parkingZone;
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

    @Override
    public void truckloadComplete() {
        completedTruckloads++;
    }

    private PackageSortingCenter(ICentralControlUnit centralControlUnit, IParkingZone parkingZone, ISortingSystem sortingSystem, java.util.List<ITruckUnloadingArea> unloadingAreas, ITruckWaitingArea waitingArea) {
        this.centralControlUnit = centralControlUnit;
        this.parkingZone = parkingZone;
        this.sortingSystem = sortingSystem;
        this.unloadingAreas = unloadingAreas;
        this.waitingArea = waitingArea;

        centralControlUnit.setPackageSortingCenter(this);
    }

    public ICentralControlUnit getCentralControlUnit() {
        return this.centralControlUnit;
    }

    public ITruckUnloadingArea getUnloadingArea(int index) {
        return unloadingAreas.get(index);
    }

    public ISortingSystem getSortingSystem() {
        return this.sortingSystem;
    }

    public static class Builder {
        private int capacityWaitingArea;

        public Builder capacityWaitingArea(int capacity) {
            capacityWaitingArea = capacity;
            return this;
        }

        public PackageSortingCenter build() {
            ICentralControlUnit controlUnit = new CentralControlUnit();

            int amountParkingSpots = 5;
            IParkingZone parkingZone = new ParkingZone(amountParkingSpots);
            for (int i = 0; i < amountParkingSpots; i++) {
                AutonomousCar car = new AutonomousCar(String.format("AC%02d", i));
                car.setCurrentSpotId(parkingZone.parkCar(car));
                controlUnit.subscribe(car);
            }

            ITempStorageArea tempStorageArea = new TempStorageArea();
            IEmptyBoxesStorage emptyBoxesStorage = new EmptyBoxesStorage();
            IEmptyPalletStorage emptyPalletStorage = new EmptyPalletsStorage();

            List<IStorageTrack> storageTracks = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                StorageTrack storageTrack = new StorageTrack(new StorageTrackSensor());
                storageTracks.add(storageTrack);
            }

            List<SortingTrack> sortingTracks = new ArrayList<>();
            SortingTrack value = new SortingTrackValue(null);
            SortingTrack express = new SortingTrackExpress(value);
            SortingTrack normal = new SortingTrackNormal(express);
            sortingTracks.add(normal);
            sortingTracks.add(express);
            sortingTracks.add(value);

            SortingSystem sortingSystem = new SortingSystem(tempStorageArea, emptyBoxesStorage, emptyPalletStorage, storageTracks, sortingTracks);
            sortingSystem.setRobot(new UnboxingRobot(sortingSystem));

            int amountUnloadingZones = 7;
            List<ITruckUnloadingArea> unloadingAreas = new ArrayList<>(amountUnloadingZones);
            for (int i = 0; i < amountUnloadingZones; i++) {
                ITruckUnloadingArea area = new TruckUnloadingArea(i);
                area.getSensor().addListener(() -> controlUnit.publish(new TruckArrivingEvent(area.getId())));
                unloadingAreas.add(area);
            }

            ITruckWaitingArea waitingArea = new TruckWaitingArea(capacityWaitingArea);

            return new PackageSortingCenter(controlUnit, parkingZone, sortingSystem, unloadingAreas, waitingArea);
        }

    }

}