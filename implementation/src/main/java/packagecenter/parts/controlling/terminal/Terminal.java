package packagecenter.parts.controlling.terminal;

import packagecenter.command.ICommand;
import packagecenter.employee.*;
import packagecenter.parts.controlling.controlunit.*;

public class Terminal implements ITerminal {
    private ICardReader cardReader;
    private ITouchPad touchPad;
    private Employee currentEmployee;
    private IControlUnit controlUnit;

    /**
     * 
     * @param command
     */
    public void sendCommand(ICommand command) {
        // TODO - implement Terminal.sendCommand @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param controlUnit
     */
    public Terminal(IControlUnit controlUnit) {
        // TODO - implement Terminal.Terminal @Löh
        throw new UnsupportedOperationException();
    }

    public ICardReader getCardReader() {
        return this.cardReader;
    }

    public ITouchPad getTouchPad() {
        return this.touchPad;
    }

    /**
     * 
     * @param employee
     */
    public void setCurrentEmployee(Employee employee) {
        this.currentEmployee = employee;
    }

}