package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;
import packagecenter.parts.sortingsystem.tracks.sorting.IScanner;
import packagecenter.parts.sortingsystem.tracks.sorting.SortingTrack;

public class ShutdownCommand implements ICommand {

    public void execute(ICentralControlUnit controlUnit) {
        for (int i = 0; i < 7; i++) {
            controlUnit.getPackageSortingCenter().getUnloadingArea(i).getSensor().deactivate();
            controlUnit.getPackageSortingCenter().getSortingSystem().getSortingTracks().stream().map(SortingTrack::getScanner).forEach(IScanner::unloadScanComponent);
        }
    }

    public CommandType getType() {
        return CommandType.SHUTDOWN;
    }

}