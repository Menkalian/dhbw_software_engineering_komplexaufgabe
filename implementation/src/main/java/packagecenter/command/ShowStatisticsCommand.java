package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

public class ShowStatisticsCommand implements ICommand {

    /**
     * 
     * @param controlUnit
     */
    public void execute(ICentralControlUnit controlUnit) {
        // TODO - implement ShowStatisticsCommand.execute @Löh
        throw new UnsupportedOperationException();
    }

    public CommandType getType() {
        return CommandType.SHOW_STATISTICS;
    }

}