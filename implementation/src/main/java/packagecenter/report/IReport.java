package packagecenter.report;

import packagecenter.incomming.*;
import packagecenter.incomming.Package;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IReport {

    LocalDateTime getCurrentTime();

    int getCompletedTruckloads();

    Map<PackageType, Integer> getAmountPackages();

    Integer getAmountPackages(PackageType type);

    List<Package> getDangerousPackages();

}