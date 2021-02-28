package packagecenter.parts.delivery.waiting;

import packagecenter.parts.delivery.unloading.*;

public interface IParkingZone {

    /**
     * 
     * @param car
     */
    int parkCar(IAutonomousCar car);

    /**
     * 
     * @param spot
     */
    void carLeaving(int spot);

}