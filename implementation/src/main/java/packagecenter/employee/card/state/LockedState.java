package packagecenter.employee.card.state;

import packagecenter.employee.card.*;

public class LockedState extends IDCardState {
    private int incorrectInputs;

    /**
     * 
     * @param input
     */
    public boolean checkPIN(String input) {
        // TODO - implement LockedState.checkPIN @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param card
     */
    public LockedState(IIDCard card) {
        super(card);
        // TODO - implement LockedState.LockedState @Löh
        throw new UnsupportedOperationException();
    }

}