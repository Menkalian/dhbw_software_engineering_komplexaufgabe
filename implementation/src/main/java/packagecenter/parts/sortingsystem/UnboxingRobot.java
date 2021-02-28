package packagecenter.parts.sortingsystem;

import packagecenter.parts.controlling.controlunit.*;
import packagecenter.event.sorting.*;

public class UnboxingRobot extends Subscriber implements IUnboxingRobot {
    private final ISortingSystem sortingSystem;

    public ISortingSystem getSortingSystem() {
        return this.sortingSystem;
    }

    /**
     * 
     * @param system
     */
    public UnboxingRobot(ISortingSystem system) {
        // TODO - implement UnboxingRobot.UnboxingRobot @Löh
        throw new UnsupportedOperationException();
    }

    /**
     *  @Subscribe
     * @param event
     */
    public void onStartFillingEvent(StartFillingEvent event) {
        // TODO - implement UnboxingRobot.onStartFillingEvent @Löh
        throw new UnsupportedOperationException();
    }

}