package packagecenter.report;

import packagecenter.incomming.Package;
import packagecenter.incomming.PackageType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Report implements IReport {
    private final LocalDateTime currentTime;
    private final int completedTruckloads;
    private final Map<PackageType, Integer> amountPackages;
    private final List<Package> dangerousPackages;

    @Override
    public String toString() {
        return "Report{" +
                "currentTime=" + currentTime +
                ", completedTruckloads=" + completedTruckloads +
                ", amountPackages=" + amountPackages +
                ", dangerousPackages=" + dangerousPackages +
                '}';
    }

    public Integer getAmountPackages(PackageType type) {
        return amountPackages.get(type);
    }

    private Report(java.time.LocalDateTime currentTime, int completedTruckloads, java.util.Map<PackageType, Integer> amountPackages, List<Package> dangerousPackages) {
        this.currentTime = currentTime;
        this.completedTruckloads = completedTruckloads;
        this.amountPackages = amountPackages;
        this.dangerousPackages = dangerousPackages;
    }

    public LocalDateTime getCurrentTime() {
        return this.currentTime;
    }

    public int getCompletedTruckloads() {
        return this.completedTruckloads;
    }

    public Map<PackageType, Integer> getAmountPackages() {
        return amountPackages;
    }

    public List<Package> getDangerousPackages() {
        return dangerousPackages;
    }

    public static class Builder {
        private int completedTruckloads;
        private Map<PackageType, Integer> amountPackages;
        private List<Package> dangerousPackages;

        public Builder completedTruckloads(int amount) {
            completedTruckloads = amount;
            return this;
        }

        public Builder amountPackages(PackageType type, int amount) {
            amountPackages.put(type, amount);
            return this;
        }

        public Builder dangerousPackage(Package dangerous) {
            dangerousPackages.add(dangerous);
            return this;
        }

        public Report build() {
            return new Report(LocalDateTime.now(), completedTruckloads, amountPackages, dangerousPackages);
        }

    }

}