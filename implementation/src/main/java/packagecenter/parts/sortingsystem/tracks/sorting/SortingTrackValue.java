package packagecenter.parts.sortingsystem.tracks.sorting;

import packagecenter.incomming.Package;
import packagecenter.incomming.PackageType;

public class SortingTrackValue extends SortingTrack {

    public SortingTrackValue(SortingTrack successor) {
        super(successor);
    }

    public boolean doesAccept(Package pkg) {
        return pkg.getType() == PackageType.VALUE;
    }

}