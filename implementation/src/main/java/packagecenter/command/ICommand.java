package packagecenter.command;

import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

public interface ICommand {

    /**
     * 
     * @param controlUnit
     */
    void execute(ICentralControlUnit controlUnit);

    CommandType getType();

}