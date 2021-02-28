package packagecenter.parts.sortingsystem.tracks.storage;

import packagecenter.incomming.Package;
import packagecenter.parts.sortingsystem.tracks.storage.sensor.IStorageTrackSensor;

public interface IStorageTrack {

    /**
     * 
     * @param pkg
     */
    void store(Package pkg);

    Package getPackage();

    IStorageTrackSensor getSensor();

}