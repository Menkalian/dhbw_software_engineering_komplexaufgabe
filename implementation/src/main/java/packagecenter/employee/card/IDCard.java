package packagecenter.employee.card;

import packagecenter.employee.card.state.*;
import packagecenter.employee.*;

public class IDCard implements IIDCard {
    private byte[][] stripe = new byte[100][1];
    private IDCardState state = new ActiveState(this);

    public byte[][] getStripe() {
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
    public boolean checkPIN(String input) {
        // TODO - implement IDCard.checkPIN @Löh
        throw new UnsupportedOperationException();
    }

    public IDCardState getState() {
        return this.state;
    }

    public void setState(IDCardState state) {
        this.state = state;
    }

}