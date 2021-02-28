package packagecenter.parts.sortingsystem;

import packagecenter.parts.sortingsystem.storage.*;
import packagecenter.parts.sortingsystem.tracks.storage.*;
import packagecenter.parts.sortingsystem.tracks.sorting.*;

import java.util.List;

public interface ISortingSystem {

    boolean isLocked();

    void lock();

    void unlock();

    ITempStorageArea getTempStorageArea();

    void getEmptyBoxesStorage();

    IEmptyPalletStorage getEmptyPalletStorage();

    java.util.List<IStorageTrack> getStorageTracks();

    List<SortingTrack> getSortingTracks();

}