package packagecenter.parts.sortingsystem.tracks.sorting;

import packagecenter.incomming.Package;
import packagecenter.incomming.PackageType;

public class SortingTrackExpress extends SortingTrack {

    public SortingTrackExpress(SortingTrack successor) {
        super(successor);
    }

    public boolean doesAccept(Package pkg) {
        return pkg.getType() == PackageType.EXPRESS;
    }

}