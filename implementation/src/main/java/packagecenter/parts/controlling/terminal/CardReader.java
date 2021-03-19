package packagecenter.parts.controlling.terminal;

import packagecenter.employee.card.*;

public class CardReader implements ICardReader {
    private ITerminal terminal;
    private IIDCard lastCardSwept;

    public void swipeCard(IIDCard card) {
        lastCardSwept = card;
    }

    /**
     *
     * @param pin
     */
    public boolean enterPIN(String pin) {
        return lastCardSwept.checkPIN(pin);
    }

    /**
     *
     * @param terminal
     */
    public CardReader(ITerminal terminal) {
        // TODO - implement CardReader.CardReader @Löh
        throw new UnsupportedOperationException();
    }

}