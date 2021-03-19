package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

public class ShutdownCommand implements ICommand {

    /**
     * 
     * @param controlUnit
     */
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