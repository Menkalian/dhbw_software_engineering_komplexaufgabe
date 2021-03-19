package packagecenter.parts.controlling.controlunit;

import packagecenter.command.ICommand;

public interface IControlUnit {

    void executeCommand(ICommand command, String usertype);

}