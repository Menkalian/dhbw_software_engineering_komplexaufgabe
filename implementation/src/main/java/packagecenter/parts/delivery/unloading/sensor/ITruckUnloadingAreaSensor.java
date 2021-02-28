package packagecenter.parts.delivery.unloading.sensor;

public interface ITruckUnloadingAreaSensor {

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

    void truckArriving();

    void activate();

    void deactivate();

    interface ISensorListener {

        void onTruckArrival();

    }

}