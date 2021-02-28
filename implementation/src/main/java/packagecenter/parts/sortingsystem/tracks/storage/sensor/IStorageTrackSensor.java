package packagecenter.parts.sortingsystem.tracks.storage.sensor;

public interface IStorageTrackSensor {

    /**
     * 
     * @param listener
     */
    void addListener(ISensorListener listener);

    /**
     * 
     * @param listener
     */
    void removeListener(ISensorListener listener);

    /**
     * 
     * @param amount
     */
    void packagesStored(int amount);

    interface ISensorListener {

        void onTrackFull();

    }

}