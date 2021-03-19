package packagecenter.event.sorting;

import packagecenter.event.*;
import packagecenter.parts.IPackageSortingCenter;

public class StartSortingEvent extends Event {
    private IPackageSortingCenter packageSortingCenter;

    public IPackageSortingCenter getPackageSortingCenter() {
        return packageSortingCenter;
    }

    public StartSortingEvent(IPackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
    }
}