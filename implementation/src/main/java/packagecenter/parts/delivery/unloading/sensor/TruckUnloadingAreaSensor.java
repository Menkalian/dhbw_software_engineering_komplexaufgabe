package packagecenter.parts.delivery.unloading.sensor;

import java.util.LinkedList;
import java.util.List;

public class TruckUnloadingAreaSensor implements ITruckUnloadingAreaSensor {
    private final List<ISensorListener> listeners = new LinkedList<>();
    private boolean isActivated = true; // Activated by default

    public void addListener(ISensorListener listener) {
        listeners.add(listener);
    }

    public void removeListener(ISensorListener listener) {
        listeners.remove(listener);
    }

    public void truckArriving() {
        if (isActivated)
            listeners.forEach(ISensorListener::onTruckArrival);
    }

    public void activate() {
        isActivated = true;
    }

    public void deactivate() {
        isActivated = false;
    }

}