package packagecenter.parts.sortingsystem;

import com.google.common.eventbus.Subscribe;
import packagecenter.incomming.Box;
import packagecenter.incomming.Package;
import packagecenter.parts.controlling.controlunit.*;
import packagecenter.event.sorting.*;

public class UnboxingRobot extends Subscriber implements IUnboxingRobot {
    private final ISortingSystem sortingSystem;

    public ISortingSystem getSortingSystem() {
        return this.sortingSystem;
    }

    public UnboxingRobot(ISortingSystem system) {
        this.sortingSystem = system;
    }

    @Subscribe
    public void onStartFillingEvent(StartFillingEvent event) {
        // Place 600 Packages
        for (int i = 0; i < 600; i++) {
            // Look for non-empty positions in temporary storage
            for (int j = 0; j < 5; j++) {
                if(event.getPackageSortingCenter().getSortingSystem().getTempStorageArea().getPositions().get(j).getCapacity() < 2){
                    for(Box box : event.getPackageSortingCenter().getSortingSystem().getTempStorageArea().getPositions().get(j).take().getBoxes())
                        for(Package pack : box.getPackages())
                            event.getPackageSortingCenter().getSortingSystem().getStorageTracks().get(event.getCurrentTrackId()).store(pack);
                    }
                }
            }
        }
    }