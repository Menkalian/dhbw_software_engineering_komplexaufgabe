package packagecenter.parts.sortingsystem.tracks.storage.sensor;

import packagecenter.parts.sortingsystem.tracks.storage.sensor.IStorageTrackSensor.*;

public class StorageTrackSensor {
    private java.util.List<ISensorListener> listeners;

    public void addListener(ISensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISensorListener listener) {
        listeners.remove(listener);
    }

    public void packagesStored(int amount) {
        // TODO - implement StorageTrackSensor.packagesStored @Löh
        throw new UnsupportedOperationException();
    }

}