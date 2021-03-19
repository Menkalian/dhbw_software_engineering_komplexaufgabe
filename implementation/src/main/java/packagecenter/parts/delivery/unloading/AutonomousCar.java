package packagecenter.parts.delivery.unloading;

import packagecenter.parts.controlling.controlunit.*;
import packagecenter.incomming.*;
import packagecenter.event.delivery.*;

import java.util.List;

public class AutonomousCar extends Subscriber implements IAutonomousCar {
    private String id;
    private int currentSpotId;
    private Pallet loadedPallet;

    public void setCurrentSpotId(int currentSpotId) {
        this.currentSpotId = currentSpotId;
    }

    @Subscribe
    public void onUnloadTruck(UnloadTruckEvent event) {
        // TODO - implement AutonomousCar.onUnloadTruck @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param id
     */
    public AutonomousCar(String id) {
        // TODO - implement AutonomousCar.AutonomousCar @Löh
        throw new UnsupportedOperationException();
    }

    @Override
    public String getId() {
        return id;
    }
}