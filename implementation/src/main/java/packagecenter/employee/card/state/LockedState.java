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

        String encryptedStripe = new String(reducedStripe);
        String decryptedStripe = Configuration.INSTANCE.decryptionStrategy.decrypt(encryptedStripe, Configuration.INSTANCE.idCardEncryptionKey);

        if (decryptedStripe.split(";")[4].equals(input)) {
            return true;
        } else {
            incorrectInputs++;
            if (incorrectInputs >= 2) {
                card.setState(new InvalidState(card));
            }
            return false;
        }
    }

    public LockedState(IIDCard card) {
        super(card);
        // TODO - implement LockedState.LockedState @Löh
        throw new UnsupportedOperationException();
    }

}