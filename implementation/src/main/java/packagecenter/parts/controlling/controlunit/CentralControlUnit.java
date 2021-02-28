package packagecenter.parts.controlling.controlunit;

import packagecenter.command.ICommand;
import packagecenter.employee.Employee;
import packagecenter.event.*;
import packagecenter.event.delivery.*;

public class CentralControlUnit implements ICentralControlUnit {
    private com.google.common.eventbus.EventBus eventBus;

    /**
     * 
     * @param subscriber
     */
    public void subscribe(Subscriber subscriber) {
        // TODO - implement CentralControlUnit.subscribe @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param event
     */
    public void publish(Object event) {
        // TODO - implement CentralControlUnit.publish @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * @Subscribe
     * Hier bitte die Events loggen
     * @param event
     */
    public void onEvent(Event event) {
        // TODO - implement CentralControlUnit.onEvent @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * @Subscribe
     * @param event
     */
    public void onTruckArriving(TruckArrivingEvent event) {
        // TODO - implement CentralControlUnit.onTruckArriving @Löh
        throw new UnsupportedOperationException();
    }

    @Override
    public void executeCommand(ICommand command, Employee user) {
        // TODO - implement CentralControlUnit.onTruckArriving @Löh
        throw new UnsupportedOperationException();
    }
}