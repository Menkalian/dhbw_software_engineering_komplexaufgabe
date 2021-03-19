package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

public class NextCommand implements ICommand {

    /**
     * 
     * @param controlUnit
     */
    public void execute(ICentralControlUnit controlUnit) {
        Random random = new Random();
        for (int i = 0; i < controlUnit.getPackageSortingCenter().getWaitingArea().getTrucks().length; i++) {
            if (controlUnit.getPackageSortingCenter().getWaitingArea().getTrucks()[i] != null) {
                controlUnit
                        .getPackageSortingCenter()
                        .getUnloadingArea(random.nextInt(7))
                        .truckArriving(
                                controlUnit
                                        .getPackageSortingCenter()
                                        .getWaitingArea()
                                        .getTrucks()[i]
                        );
                controlUnit.getPackageSortingCenter().truckloadComplete();
                break;
            }
        }
    }

    public CommandType getType() {
        return CommandType.NEXT;
    }

}