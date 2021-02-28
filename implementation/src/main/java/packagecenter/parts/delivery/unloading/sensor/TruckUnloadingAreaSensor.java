package packagecenter.parts.delivery.unloading.sensor;

import packagecenter.parts.delivery.unloading.sensor.ITruckUnloadingAreaSensor.*;

public class TruckUnloadingAreaSensor implements ITruckUnloadingAreaSensor {
    private java.util.List<ISensorListener> listeners;
    private boolean isActivated;

    /**
     * 
     * @param listener
     */
    public void addListener(ISensorListener listener) {
        // TODO - implement TruckUnloadingAreaSensor.addListener @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param listener
     */
    public void removeListener(ISensorListener listener) {
        // TODO - implement TruckUnloadingAreaSensor.removeListener @Löh
        throw new UnsupportedOperationException();
    }

    public void truckArriving() {
        // TODO - implement TruckUnloadingAreaSensor.truckArriving @Löh
        throw new UnsupportedOperationException();
    }

    public void activate() {
        // TODO - implement TruckUnloadingAreaSensor.activate @Löh
        throw new UnsupportedOperationException();
    }

    public void deactivate() {
        // TODO - implement TruckUnloadingAreaSensor.deactivate @Löh
        throw new UnsupportedOperationException();
    }

}