package packagecenter.parts.sortingsystem.tracks.storage.sensor;

import packagecenter.parts.sortingsystem.tracks.storage.sensor.IStorageTrackSensor.ISensorListener;

import java.util.LinkedList;
import java.util.List;

public class StorageTrackSensor implements IStorageTrackSensor{
    private final List<ISensorListener> listeners = new LinkedList<>();

    public void addListener(ISensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISensorListener listener) {
        listeners.remove(listener);
    }

    public void packagesStored(int amount) {
        if(amount >= 600) {
            listeners.forEach(ISensorListener::onTrackFull);
        }
    }

}