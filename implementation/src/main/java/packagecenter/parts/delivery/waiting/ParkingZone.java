package packagecenter.parts.delivery.waiting;

import packagecenter.parts.delivery.unloading.*;

public class ParkingZone implements IParkingZone {
    private IAutonomousCar[] cars;

    public ParkingZone(int amountParkingSpots) {
        cars = new IAutonomousCar[amountParkingSpots];
    }

    public int parkCar(IAutonomousCar car) {
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] == null){
                cars[i] = car;
                car.setCurrentSpotId(i);
                return i;
            }
        }
        throw new RuntimeException();
    }

    public void carLeaving(int spot) {
        cars[spot]= null;
    }

}