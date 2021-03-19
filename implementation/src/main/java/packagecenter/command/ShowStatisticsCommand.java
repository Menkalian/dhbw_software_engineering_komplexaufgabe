package packagecenter.command;

import packagecenter.incomming.PackageType;
import packagecenter.parts.controlling.controlunit.ICentralControlUnit;
import packagecenter.parts.sortingsystem.ISortingSystem;
import packagecenter.report.Report;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ShowStatisticsCommand implements ICommand {

    /**
     * 
     * @param controlUnit
     */
    public void execute(ICentralControlUnit controlUnit) {

        ISortingSystem sortingSystem = controlUnit.getPackageSortingCenter().getSortingSystem();
        Report.Builder reportBuilder = new Report.Builder();
        sortingSystem.getSortingTracks().forEach(
                sortingTrack -> {
                    PackageType type = sortingTrack.getPackages().get(0).getType();
                    reportBuilder.amountPackages(type, sortingTrack.getPackages().size());
                    sortingTrack.getDangerousPackages().forEach(reportBuilder::dangerousPackage);
                }
        );

        reportBuilder.completedTruckloads(controlUnit.getPackageSortingCenter().getCompletedTruckloads());

        try {
            File reportFile = new File("report.txt");
            reportFile.createNewFile();
            PrintWriter fileWriter = new PrintWriter(reportFile);

            fileWriter.println(reportBuilder.build().toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public CommandType getType() {
        return CommandType.SHOW_STATISTICS;
    }

}