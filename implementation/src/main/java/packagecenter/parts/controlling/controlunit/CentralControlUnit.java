package packagecenter.parts.controlling.controlunit;

import com.google.common.eventbus.EventBus;
import packagecenter.command.ICommand;
import packagecenter.employee.Employee;
import packagecenter.event.*;
import packagecenter.event.delivery.*;

public class CentralControlUnit implements ICentralControlUnit {
    private com.google.common.eventbus.EventBus eventBus;

    public void subscribe(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void publish(Object event) {
        eventBus.post(event);
    }

    public void onEvent(Event event) {
        System.out.println("Event received: " + event);
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
        command.execute(this);
    }

    public CentralControlUnit() {
        eventBus = new EventBus("PackageCenter");
    }
}