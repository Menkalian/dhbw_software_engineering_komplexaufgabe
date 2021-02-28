package packagecenter.parts.controlling.terminal;

import packagecenter.parts.sortingsystem.tracks.sorting.SearchAlgorithm;

public interface ITouchPad {

    void init();

    void next();

    void shutdown();

    void lock();

    void unlock();

    void showStatistics();

    /**
     * 
     * @param algorithm
     */
    void changeAlgorithm(SearchAlgorithm algorithm);

}