package packagecenter.parts.controlling.terminal;

import packagecenter.command.ICommand;
import packagecenter.employee.*;

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
     * @param employee
     */
    void setCurrentEmployee(Employee employee);

}