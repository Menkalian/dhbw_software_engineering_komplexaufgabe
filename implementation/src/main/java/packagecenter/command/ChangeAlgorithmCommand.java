package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;
import packagecenter.parts.sortingsystem.tracks.sorting.*;

public class ChangeAlgorithmCommand implements ICommand {
    private SearchAlgorithm targetAlgorithm;

    public SearchAlgorithm getTargetAlgorithm() {
        return this.targetAlgorithm;
    }

    /**
     * 
     * @param targetAlgorithm
     */
    public ChangeAlgorithmCommand(SearchAlgorithm targetAlgorithm) {
        // TODO - implement ChangeAlgorithmCommand.ChangeAlgorithmCommand @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param controlUnit
     */
    public void execute(ICentralControlUnit controlUnit) {
        // TODO - implement ChangeAlgorithmCommand.execute @Löh
        throw new UnsupportedOperationException();
    }

    public CommandType getType() {
        // TODO - implement ChangeAlgorithmCommand.getType @Löh
        throw new UnsupportedOperationException();
    }

}