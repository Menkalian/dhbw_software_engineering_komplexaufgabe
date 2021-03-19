package packagecenter.employee.card.state;

import packagecenter.employee.card.IIDCard;

public abstract class IDCardState {
    protected IIDCard card;

    public abstract boolean checkPIN(String input);

    public IDCardState(IIDCard card) {
        this.card = card;
    }
}