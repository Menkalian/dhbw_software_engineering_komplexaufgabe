package packagecenter.parts.delivery.waiting;

import packagecenter.parts.delivery.unloading.*;

public class ParkingZone implements IParkingZone {
    private IAutonomousCar[] cars;

    public ParkingZone(int amountParkingSpots) {
        cars = new IAutonomousCar[amountParkingSpots];
    }

    public int parkCar(IAutonomousCar car) {
        // TODO - implement ParkingZone.parkCar @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param spot
     */
    public void carLeaving(int spot) {
        // TODO - implement ParkingZone.carLeaving @Löh
        throw new UnsupportedOperationException();
    }

}