package packagecenter.parts;

import packagecenter.parts.controlling.controlunit.*;
import packagecenter.parts.delivery.unloading.*;
import packagecenter.parts.sortingsystem.*;

public interface IPackageSortingCenter {

    ICentralControlUnit getCentralControlUnit();

    /**
     * 
     * @param index
     */
    ITruckUnloadingArea getUnloadingArea(int index);

    ISortingSystem getSortingSystem();

}