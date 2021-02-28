package packagecenter.parts.controlling.controlunit;

import packagecenter.command.ICommand;
import packagecenter.employee.*;

public interface IControlUnit {

    /**
     * 
     * @param command
     * @param user
     */
    void executeCommand(ICommand command, Employee user);

}