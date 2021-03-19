package packagecenter.parts.controlling.controlunit;

import packagecenter.command.CommandType;
import packagecenter.command.ICommand;
import packagecenter.employee.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControlUnitProxy implements IControlUnit {
    private final IControlUnit controlUnit;
    private final java.util.Map<Class<?>, java.util.List<CommandType>> permissions;


    public void executeCommand(ICommand command, Employee user) {
        if (user == null) {
            throw new InsufficientRightsException();
        }

        if (permissions.get(user.getClass()).contains(command.getType())) {
            controlUnit.executeCommand(command, user);
        } else throw new InsufficientRightsException();
    }

    //Hi hier ist solid
    public ControlUnitProxy(IControlUnit nextControlUnit) {
        controlUnit = nextControlUnit;
        permissions = new HashMap<>();

        List<CommandType> commands = new ArrayList<>();
        commands.add(CommandType.CHANGE_ALGORITHM);
        commands.add(CommandType.INIT);
        commands.add(CommandType.LOCK);
        commands.add(CommandType.NEXT);
        commands.add(CommandType.SHOW_STATISTICS);
        commands.add(CommandType.SHUTDOWN);
        commands.add(CommandType.UNLOCK);
        permissions.put(Supervisor.class, commands);

        commands = new ArrayList<>();
        commands.add(CommandType.SHOW_STATISTICS);
        commands.add(CommandType.SHUTDOWN);
        permissions.put(Administrator.class, commands);

        commands = new ArrayList<>();
        commands.add(CommandType.NEXT);
        commands.add(CommandType.SHOW_STATISTICS);

        permissions.put(Operator.class, commands);

        commands = new ArrayList<>();
        commands.add(CommandType.SHOW_STATISTICS);
        permissions.put(DataAnalyst.class, commands);
    }

    public static class InsufficientRightsException extends RuntimeException {
    }

}