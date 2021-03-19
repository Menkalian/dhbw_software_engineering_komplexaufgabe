package packagecenter.parts.controlling.terminal;

import packagecenter.command.ICommand;
import packagecenter.parts.controlling.controlunit.IControlUnit;

public class Terminal implements ITerminal {
    private final ICardReader cardReader;
    private final ITouchPad touchPad;
    private String currentType;
    private final IControlUnit controlUnit;

    public void sendCommand(ICommand command) {
        controlUnit.executeCommand(command, currentType);
    }

    public Terminal(IControlUnit controlUnit) {
        this.controlUnit = controlUnit;
        touchPad = new TouchPad(this);
        cardReader = new CardReader(this);
    }

    public ICardReader getCardReader() {
        return this.cardReader;
    }

    public ITouchPad getTouchPad() {
        return this.touchPad;
    }

    public void setCurrentEmployeeType(String type) {
        this.currentType = type;
    }

}