package packagecenter.parts.sortingsystem.tracks.sorting;

import packagecenter.incomming.Package;
import packagecenter.incomming.PackageType;

public class SortingTrackNormal extends SortingTrack {

    public SortingTrackNormal(SortingTrack successor) {
        super(successor);
    }

    public boolean doesAccept(Package pkg) {
        return pkg.getType() == PackageType.NORMAL;
    }

}