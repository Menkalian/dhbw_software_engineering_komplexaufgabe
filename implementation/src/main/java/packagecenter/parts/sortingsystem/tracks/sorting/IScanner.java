package packagecenter.parts.sortingsystem.tracks.sorting;

import packagecenter.incomming.Package;

public interface IScanner {

    /**
     * 
     * @param algorithm
     */
    void changeSearchAlgorithm(SearchAlgorithm algorithm);

    /**
     * 
     * @param pkg
     */
    boolean scan(Package pkg);

    void unloadScanComponent();

}