package packagecenter.parts.controlling.controlunit;

import packagecenter.parts.IPackageSortingCenter;

public interface ICentralControlUnit extends IControlUnit {

    /**
     * 
     * @param subscriber
     */
    void subscribe(Subscriber subscriber);

    /**
     * 
     * @param event
     */
    void publish(Object event);

    IPackageSortingCenter getPackageSortingCenter();

    void setPackageSortingCenter(IPackageSortingCenter packageSortingCenter);


}