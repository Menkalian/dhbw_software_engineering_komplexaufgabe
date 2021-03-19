package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

public class LockCommand implements ICommand {

    public void execute(ICentralControlUnit controlUnit) {
        controlUnit.getPackageSortingCenter().getSortingSystem().lock();
    }

    public CommandType getType() {
        return CommandType.LOCK;
    }

}