package packagecenter.parts.controlling.controlunit;

import packagecenter.command.ICommand;
import packagecenter.employee.*;

public interface IControlUnit {

    void executeCommand(ICommand command, Employee user);

}