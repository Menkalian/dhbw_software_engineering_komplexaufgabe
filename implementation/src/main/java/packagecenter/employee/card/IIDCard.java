package packagecenter.employee.card;

import packagecenter.employee.card.state.*;

public interface IIDCard {

    /**
     * 
     * @param input
     */
    boolean checkPIN(String input);

    IDCardState getState();

    /**
     * 
     * @param state
     */
    void setState(IDCardState state);

}