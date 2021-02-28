package packagecenter.event.delivery;

import packagecenter.event.*;

public class UnloadTruckEvent extends Event {
    private String carId;
    private int areaId;

    public String getCarId() {
        return this.carId;
    }

    public int getAreaId() {
        return this.areaId;
    }

    /**
     * 
     * @param carId
     * @param areaId
     */
    public UnloadTruckEvent(String carId, int areaId) {
        // TODO - implement UnloadTruckEvent.UnloadTruckEvent @Löh
        throw new UnsupportedOperationException();
    }

}