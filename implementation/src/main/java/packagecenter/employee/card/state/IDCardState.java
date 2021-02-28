package packagecenter.employee.card.state;

import packagecenter.employee.card.*;

public abstract class IDCardState {
    protected IIDCard card;

    /**
     * 
     * @param input
     */
    public abstract boolean checkPIN(String input);

    /**
     * 
     * @param card
     */
    public IDCardState(IIDCard card) {
        // TODO - implement IDCardState.IDCardState @Löh
        throw new UnsupportedOperationException();
    }

}