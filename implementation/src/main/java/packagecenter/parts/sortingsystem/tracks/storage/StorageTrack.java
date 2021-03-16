package packagecenter.parts.sortingsystem.tracks.storage;

import packagecenter.incomming.Package;
import packagecenter.parts.sortingsystem.tracks.storage.sensor.IStorageTrackSensor;

import java.util.LinkedList;

public class StorageTrack implements IStorageTrack {
    private final java.util.Deque<Package> packages;
    private final IStorageTrackSensor sensor;

    public StorageTrack(IStorageTrackSensor sensor) {
        this.sensor = sensor;
        packages = new LinkedList<>();
    }

    public java.util.Deque<Package> getPackages() {
        return this.packages;
    }

    public void store(Package pkg) {
        packages.add(pkg);
        sensor.packagesStored(packages.size());
    }

    public Package getPackage() {
        return packages.pollLast();
    }

    public IStorageTrackSensor getSensor() {
        return this.sensor;
    }
}