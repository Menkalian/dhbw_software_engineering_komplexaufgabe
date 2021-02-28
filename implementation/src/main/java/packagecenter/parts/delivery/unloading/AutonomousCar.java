package packagecenter.parts.delivery.unloading;

import packagecenter.parts.controlling.controlunit.*;
import packagecenter.incomming.*;
import packagecenter.event.delivery.*;

public class AutonomousCar extends Subscriber implements IAutonomousCar {
    private int currentSpotId;
    private Pallet loadedPallet;

    /**
     * @Subscribe
     * @param event
     */
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

}