package packagecenter.parts.delivery.unloading;

import com.google.common.eventbus.Subscribe;
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
        if(event.getCarId().equals(id)){
            event.getPackageSortingCenter().getParkingZone().carLeaving(currentSpotId);
            List<Pallet> palletList = event.getPackageSortingCenter().getUnloadingArea(event.getAreaId()).getCurrentTruck().getPallets();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 2; j++) {
                    event.getPackageSortingCenter().getSortingSystem().getTempStorageArea().getPositions().get(i).store(palletList.remove(event.getPackageSortingCenter().getSortingSystem().getTempStorageArea().getPositions().size()-1));
                }
            }
            event.getPackageSortingCenter().getParkingZone().parkCar(this);
            TruckUnloadedEvent truckUnloadedEvent = new TruckUnloadedEvent();
            event.getPackageSortingCenter().getCentralControlUnit().publish(truckUnloadedEvent);
        }
    }

    public AutonomousCar(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}