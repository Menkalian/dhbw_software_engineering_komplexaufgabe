package packagecenter.event.sorting;

import packagecenter.event.Event;
import packagecenter.parts.IPackageSortingCenter;

public class StartFillingEvent extends Event {
    private IPackageSortingCenter packageSortingCenter;
    private int currentTrackId;

    public IPackageSortingCenter getPackageSortingCenter() {
        return packageSortingCenter;
    }

    public int getCurrentTrackId() {
        return currentTrackId;
    }

    public StartFillingEvent(IPackageSortingCenter packageSortingCenter, int currentTrackId) {
        this.packageSortingCenter = packageSortingCenter;
        this.currentTrackId = currentTrackId;
    }
}