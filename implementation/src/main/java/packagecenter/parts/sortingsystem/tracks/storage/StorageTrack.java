package packagecenter.parts.sortingsystem.tracks.storage;

import packagecenter.incomming.Package;
import packagecenter.parts.sortingsystem.tracks.storage.sensor.IStorageTrackSensor;

public class StorageTrack implements IStorageTrack {
    private java.util.Deque<Package> packages;
    private IStorageTrackSensor sensor;

    public java.util.Deque<Package> getPackages() {
        return this.packages;
    }

    /**
     * 
     * @param pkg
     */
    public void store(Package pkg) {
        // TODO - implement StorageTrack.store @Löh
        throw new UnsupportedOperationException();
    }

    public Package getPackage() {
        // TODO - implement StorageTrack.getPackage @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param sensor
     */
    public StorageTrack(IStorageTrackSensor sensor) {
        // TODO - implement StorageTrack.StorageTrack @Löh
        throw new UnsupportedOperationException();
    }

    public IStorageTrackSensor getSensor() {
        return this.sensor;
    }

}