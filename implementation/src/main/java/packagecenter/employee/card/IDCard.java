package packagecenter.employee.card;

import packagecenter.employee.card.state.*;
import packagecenter.employee.*;

public class IDCard implements IIDCard {
    private byte stripe;
    private IDCardState state = new ActiveState(this);

    public byte getStripe() {
        return this.stripe;
    }

    /**
     * 
     * @param employee
     */
    public IDCard(Employee employee) {
        // TODO - implement IDCard.IDCard @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param input
     */
    public void checkPIN(String input) {
        // TODO - implement IDCard.checkPIN @Löh
        throw new UnsupportedOperationException();
    }

    public IDCardState getState() {
        return this.state;
    }

    /**
     * 
     * @param state
     */
    public void setState(IDCardState state) {
        this.state = state;
    }

}