package packagecenter.parts.sortingsystem;

import packagecenter.parts.sortingsystem.storage.IEmptyBoxesStorage;
import packagecenter.parts.sortingsystem.storage.IEmptyPalletStorage;
import packagecenter.parts.sortingsystem.storage.ITempStorageArea;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrack;
import packagecenter.parts.sortingsystem.tracks.storage.IStorageTrack;

import java.util.List;

public class SortingSystem implements ISortingSystem {
    private boolean locked;
    private ITempStorageArea tempStorageArea;
    private IUnboxingRobot robot;
    private IEmptyBoxesStorage emptyBoxesStorage;
    private IEmptyPalletStorage emptyPalletStorage;
    private java.util.List<IStorageTrack> storageTracks;
    private java.util.List<SortingTrack> sortingTracks;

    public IUnboxingRobot getRobot() {
        return this.robot;
    }

    public void setRobot(IUnboxingRobot robot) {
        this.robot = robot;
    }

    public void lock() {
        // TODO - implement SortingSystem.lock @Löh
        throw new UnsupportedOperationException();
    }

    public void unlock() {
        // TODO - implement SortingSystem.unlock @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param tempStorage
     * @param emptyBoxesStorage
     * @param emptyPalletStorage
     * @param storageTracks
     */
    public SortingSystem(ITempStorageArea tempStorage, IEmptyBoxesStorage emptyBoxesStorage, IEmptyPalletStorage emptyPalletStorage, List<IStorageTrack> storageTracks) {
        // TODO - implement SortingSystem.SortingSystem @Löh
        throw new UnsupportedOperationException();
    }

    public boolean isLocked() {
        return this.locked;
    }

    public ITempStorageArea getTempStorageArea() {
        return this.tempStorageArea;
    }

    public void getEmptyBoxesStorage() {
        // TODO - implement SortingSystem.getEmptyBoxesStorage @Löh
        throw new UnsupportedOperationException();
    }

    public IEmptyPalletStorage getEmptyPalletStorage() {
        return this.emptyPalletStorage;
    }

    public java.util.List<IStorageTrack> getStorageTracks() {
        return this.storageTracks;
    }

    public List<SortingTrack> getSortingTracks() {
        // TODO - implement SortingSystem.getSortingTracks @Löh
        throw new UnsupportedOperationException();
    }

}