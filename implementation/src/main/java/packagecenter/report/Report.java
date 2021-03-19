package packagecenter.report;

import packagecenter.incomming.Package;
import packagecenter.incomming.PackageType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Report implements IReport {
    private java.time.LocalDateTime currentTime;
    private int completedTruckloads;
    private java.util.Map<PackageType, Integer> amountPackages;
    private java.util.List<Package> dangerousPackages;

    public String toString() {
        // TODO - implement Report.toString @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param type
     */
    public Integer getAmountPackages(PackageType type) {
        // TODO - implement Report.getAmountPackages @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param currentTime
     * @param completedTruckloads
     * @param amountPackages
     */
    private Report(java.time.LocalDateTime currentTime, int completedTruckloads, java.util.Map<PackageType, Integer> amountPackages) {
        // TODO - implement Report.Report @Löh
        throw new UnsupportedOperationException();
    }

    public java.time.LocalDateTime getCurrentTime() {
        return this.currentTime;
    }

    public int getCompletedTruckloads() {
        return this.completedTruckloads;
    }

    public Map<PackageType, Integer> getAmountPackages() {
        // TODO - implement Report.getAmountPackages @Löh
        throw new UnsupportedOperationException();
    }

    public List<Package> getDangerousPackages() {
        // TODO - implement Report.getDangerousPackages @Löh
        throw new UnsupportedOperationException();
    }

    public class Builder {
        private int completedTruckloads;
        private java.util.Map<PackageType, Integer> amountPackages;
        private java.util.List<Package> dangerousPackages;

        /**
         * 
         * @param amount
         */
        public Builder completedTruckloads(int amount) {
            // TODO - implement Builder.completedTruckloads @Löh
            throw new UnsupportedOperationException();
        }

        /**
         * 
         * @param type
         * @param amount
         */
        public Builder amountPackages(PackageType type, int amount) {
            // TODO - implement Builder.amountPackages @Löh
            throw new UnsupportedOperationException();
        }

        /**
         * 
         * @param dangerous
         */
        public Builder dangerousPackage(Package dangerous) {
            // TODO - implement Builder.dangerousPackage @Löh
            throw new UnsupportedOperationException();
        }

        public Report build() {
            // TODO - implement Builder.build @Löh
            throw new UnsupportedOperationException();
        }

    }

}