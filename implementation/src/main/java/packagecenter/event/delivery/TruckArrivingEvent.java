package packagecenter.event.delivery;

import packagecenter.event.*;

public class TruckArrivingEvent extends Event {
    private final int areaId;

    public int getAreaId() {
        return this.areaId;
    }

    public TruckArrivingEvent(int areaId) {
        this.areaId = areaId;
    }

}