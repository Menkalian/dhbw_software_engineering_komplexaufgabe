package packagecenter.report;

import packagecenter.incomming.*;
import packagecenter.incomming.Package;

import java.util.List;
import java.util.Map;

public interface IReport {

    java.time.LocalDateTime getCurrentTime();

    int getCompletedTruckloads();

    Map<PackageType, Integer> getAmountPackages();

    /**
     * 
     * @param type
     */
    Integer getAmountPackages(PackageType type);

    List<Package> getDangerousPackages();

}