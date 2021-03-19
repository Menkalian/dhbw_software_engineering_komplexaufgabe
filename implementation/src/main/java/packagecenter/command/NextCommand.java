package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

public class NextCommand implements ICommand {

    /**
     * 
     * @param controlUnit
     */
    public void execute(ICentralControlUnit controlUnit) {
        // TODO - implement NextCommand.execute @Löh
        throw new UnsupportedOperationException();
    }

    public CommandType getType() {
        return CommandType.NEXT;
    }

}