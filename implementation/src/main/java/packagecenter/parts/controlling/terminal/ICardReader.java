package packagecenter.parts.controlling.terminal;

import packagecenter.employee.card.*;

public interface ICardReader {

    /**
     * 
     * @param card
     */
    void swipeCard(IIDCard card);

    /**
     * 
     * @param pin
     */
    boolean enterPIN(String pin);

}