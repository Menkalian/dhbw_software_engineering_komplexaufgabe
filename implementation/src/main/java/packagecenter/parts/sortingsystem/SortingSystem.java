package packagecenter.parts.sortingsystem;

import packagecenter.parts.sortingsystem.storage.IEmptyBoxesStorage;
import packagecenter.parts.sortingsystem.storage.IEmptyPalletStorage;
import packagecenter.parts.sortingsystem.storage.ITempStorageArea;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrack;
import packagecenter.parts.sortingsystem.tracks.storage.IStorageTrack;

import java.util.List;

public class SortingSystem implements ISortingSystem {
    private boolean locked;
    private final ITempStorageArea tempStorageArea;
    private IUnboxingRobot robot;
    private final IEmptyBoxesStorage emptyBoxesStorage;
    private final IEmptyPalletStorage emptyPalletStorage;
    private final List<IStorageTrack> storageTracks;
    private final List<SortingTrack> sortingTracks;

    public IUnboxingRobot getRobot() {
        return this.robot;
    }

    public void setRobot(IUnboxingRobot robot) {
        this.robot = robot;
    }

    public void lock() {
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public SortingSystem(ITempStorageArea tempStorage, IEmptyBoxesStorage emptyBoxesStorage, IEmptyPalletStorage emptyPalletStorage, List<IStorageTrack> storageTracks, List<SortingTrack> sortingTracks) {
        this.tempStorageArea = tempStorage;
        this.emptyBoxesStorage = emptyBoxesStorage;
        this.emptyPalletStorage = emptyPalletStorage;
        this.storageTracks = storageTracks;
        this.sortingTracks = sortingTracks;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public ITempStorageArea getTempStorageArea() {
        return this.tempStorageArea;
    }

    public IEmptyBoxesStorage getEmptyBoxesStorage() {
        return emptyBoxesStorage;
    }

    public IEmptyPalletStorage getEmptyPalletStorage() {
        return this.emptyPalletStorage;
    }

    public java.util.List<IStorageTrack> getStorageTracks() {
        return this.storageTracks;
    }

    public List<SortingTrack> getSortingTracks() {
        return sortingTracks;
    }

}