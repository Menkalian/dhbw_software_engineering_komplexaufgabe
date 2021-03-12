package packagecenter.parts.sortingsystem.tracks.storage;

import packagecenter.incomming.Package;
import packagecenter.parts.sortingsystem.tracks.storage.sensor.IStorageTrackSensor;

import java.util.LinkedList;

public class StorageTrack implements IStorageTrack {
    private java.util.Deque<Package> packages;
    private IStorageTrackSensor sensor;

    public java.util.Deque<Package> getPackages() {
        return this.packages;
    }

    public void store(Package pkg) {
        if(packages.size()<600)
            packages.add(pkg);
    }

    public Package getPackage() {
        if(packages.size()>0) return packages.pop();
            else return null;
    }

    public StorageTrack(IStorageTrackSensor sensor) {
        this.sensor = sensor;
        packages = new LinkedList<>();
    }

    public IStorageTrackSensor getSensor() {
        return this.sensor;
    }
}