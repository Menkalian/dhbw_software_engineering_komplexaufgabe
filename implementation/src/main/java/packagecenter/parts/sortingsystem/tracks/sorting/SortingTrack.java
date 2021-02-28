package packagecenter.parts.sortingsystem.tracks.sorting;

import packagecenter.incomming.*;
import packagecenter.incomming.Package;

import java.util.List;

public abstract class SortingTrack {
    private SortingTrack successor;
    private List<Package> packages;
    private IScanner scanner;
    private List<Package> dangerousPackages;

    public List<Package> getPackages() {
        return this.packages;
    }

    public IScanner getScanner() {
        return this.scanner;
    }

    public List<Package> getDangerousPackages() {
        return this.dangerousPackages;
    }

    /**
     * 
     * @param pkg
     */
    public abstract void doesAccept(Package pkg);

    /**
     * 
     * @param pkg
     */
    public void accept(Package pkg) {
        // TODO - implement SortingTrack.accept @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param successor
     */
    public SortingTrack(SortingTrack successor) {
        // TODO - implement SortingTrack.SortingTrack @Löh
        throw new UnsupportedOperationException();
    }

}