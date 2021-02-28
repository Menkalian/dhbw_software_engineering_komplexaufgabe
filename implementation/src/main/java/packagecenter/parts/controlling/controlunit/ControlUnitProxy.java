package packagecenter.parts.controlling.controlunit;

import packagecenter.command.*;
import packagecenter.employee.*;

public class ControlUnitProxy implements IControlUnit {
    private IControlUnit controlUnit;
    private java.util.Map<Class<?>, java.util.List<CommandType>> permissions;

    /**
     * 
     * @param command
     * @param user
     */
    public void executeCommand(ICommand command, Employee user) {
        // TODO - implement ControlUnitProxy.executeCommand @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param nextControlUnit
     */
    public ControlUnitProxy(IControlUnit nextControlUnit) {
        // TODO - implement ControlUnitProxy.ControlUnitProxy @Löh
        throw new UnsupportedOperationException();
    }

    public class InsufficientRightsException {
    }

}