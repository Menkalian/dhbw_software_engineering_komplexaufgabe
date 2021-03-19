package packagecenter.parts.controlling.terminal;

import packagecenter.command.ICommand;

public interface ITerminal {

    ICardReader getCardReader();

    ITouchPad getTouchPad();

    /**
     * 
     * @param command
     */
    void sendCommand(ICommand command);

    /**
     *
     * @param type
     */
    void setCurrentEmployeeType(String type);

}