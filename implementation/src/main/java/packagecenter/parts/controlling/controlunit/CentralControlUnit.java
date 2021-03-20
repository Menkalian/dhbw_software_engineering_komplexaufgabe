package packagecenter.parts.controlling.controlunit;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import packagecenter.command.ICommand;
import packagecenter.event.Event;
import packagecenter.event.delivery.TruckArrivingEvent;
import packagecenter.event.delivery.TruckUnloadedEvent;
import packagecenter.event.delivery.UnloadTruckEvent;
import packagecenter.event.sorting.StartFillingEvent;
import packagecenter.event.sorting.StartSortingEvent;
import packagecenter.event.sorting.TrackFullEvent;
import packagecenter.parts.IPackageSortingCenter;

import java.util.Random;

public class CentralControlUnit implements ICentralControlUnit {
    private final EventBus eventBus;
    private IPackageSortingCenter packageSortingCenter;
    private int fullTracksCount = 0;

    public CentralControlUnit() {
        eventBus = new EventBus("PackageCenter");
        eventBus.register(this);
    }

    public void subscribe(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void publish(Object event) {
        eventBus.post(event);
    }

    public IPackageSortingCenter getPackageSortingCenter() {
        return packageSortingCenter;
    }

    public void setPackageSortingCenter(IPackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
    }

    public void onEvent(Event event) {
        System.out.println("Event received: " + event);
    }

    @Subscribe
    public void onTruckArriving(TruckArrivingEvent event) {
        Random random = new Random();
        UnloadTruckEvent unloadTruckEvent = new UnloadTruckEvent(String.format("AC%02d", random.nextInt(5)), event.getAreaId(), packageSortingCenter);
        publish(unloadTruckEvent);
    }

    @Subscribe
    public void onTruckUnloadedEvent(TruckUnloadedEvent event) {
        StartFillingEvent startFillingEvent = new StartFillingEvent(packageSortingCenter, 0);
        packageSortingCenter.getSortingSystem().getRobot();
    }

    @Subscribe
    public void onTrackFull(TrackFullEvent event) {
        fullTracksCount++;
        if (fullTracksCount == 8) {
            fullTracksCount = 0;
            StartSortingEvent startSortingEvent = new StartSortingEvent(packageSortingCenter);
            publish(startSortingEvent);
        }
    }

    @Override
    public void executeCommand(ICommand command, String usertype) {
        command.execute(this);
    }
}