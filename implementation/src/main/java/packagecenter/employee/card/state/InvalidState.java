package packagecenter.employee.card.state;

import packagecenter.employee.card.IIDCard;

public class InvalidState extends IDCardState {


    public boolean checkPIN(String input) {
        return false;
    }

    public InvalidState(IIDCard card) {
        super(card);
    }

}