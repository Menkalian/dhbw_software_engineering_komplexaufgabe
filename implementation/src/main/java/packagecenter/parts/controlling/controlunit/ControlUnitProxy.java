package packagecenter.parts.controlling.controlunit;

import packagecenter.command.CommandType;
import packagecenter.command.ICommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControlUnitProxy implements IControlUnit {
    private final IControlUnit controlUnit;
    private final java.util.Map<String, java.util.List<CommandType>> permissions;


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
        permissions.put("Supervisor", commands);

        commands = new ArrayList<>();
        commands.add(CommandType.SHOW_STATISTICS);
        commands.add(CommandType.SHUTDOWN);
        permissions.put("Administrator", commands);

        commands = new ArrayList<>();
        commands.add(CommandType.NEXT);
        commands.add(CommandType.SHOW_STATISTICS);

        permissions.put("Operator", commands);

        commands = new ArrayList<>();
        commands.add(CommandType.SHOW_STATISTICS);
        permissions.put("DataAnalyst", commands);
    }

    public void executeCommand(ICommand command, String userType) {

        if (permissions.get(userType) != null && permissions.get(userType).contains(command.getType())) {
            controlUnit.executeCommand(command, userType);
        } else throw new InsufficientRightsException();
    }

    public static class InsufficientRightsException extends RuntimeException {
    }

}