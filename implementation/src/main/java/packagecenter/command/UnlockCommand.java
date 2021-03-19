package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

public class UnlockCommand implements ICommand {

    public void execute(ICentralControlUnit controlUnit) {
        controlUnit.getPackageSortingCenter().getSortingSystem().unlock();
    }

    public CommandType getType() {
        return CommandType.UNLOCK;
    }

}