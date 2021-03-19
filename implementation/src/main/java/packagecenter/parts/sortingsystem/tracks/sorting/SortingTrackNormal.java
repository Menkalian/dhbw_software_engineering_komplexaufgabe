package packagecenter.parts.sortingsystem.tracks.sorting;

import com.google.common.eventbus.Subscribe;
import packagecenter.event.sorting.StartSortingEvent;
import packagecenter.incomming.Package;
import packagecenter.incomming.PackageType;

public class SortingTrackNormal extends SortingTrack {

    public SortingTrackNormal(SortingTrack successor) {
        super(successor);
    }

    @Subscribe
    public void onStartSortingEvent(StartSortingEvent event){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 600; j++) {
                this.accept(event.getPackageSortingCenter().getSortingSystem().getStorageTracks().get(i).getPackage());
            }
        }
    }

    public boolean doesAccept(Package pkg) {
        return pkg.getType() == PackageType.NORMAL;
    }

}