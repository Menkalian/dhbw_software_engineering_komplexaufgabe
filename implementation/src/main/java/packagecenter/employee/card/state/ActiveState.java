package packagecenter.employee.card.state;

import packagecenter.config.Configuration;
import packagecenter.employee.card.IIDCard;

import java.util.Arrays;

public class ActiveState extends IDCardState {
    private int incorrectInputs;

    public boolean checkPIN(String input) {
        byte[][] stripe = card.getStripe();
        int bytesAmount = Arrays.stream(stripe).map(b -> b.length).reduce(Integer::sum).orElse(0);
        byte[] reducedStripe = new byte[bytesAmount];

        int count = 0;
        for (byte[] row : stripe) {
            for (byte b : row) {
                reducedStripe[count] = b;
            }
        }

        String encryptedStripe = new String(reducedStripe);
        String decryptedStripe = Configuration.INSTANCE.decryptionStrategy.decrypt(encryptedStripe, Configuration.INSTANCE.idCardEncryptionKey);

        if (decryptedStripe.split(";")[3].equals(input)) {
            return true;
        } else {
            incorrectInputs++;
            if (incorrectInputs >= 3) {
                card.setState(new LockedState(card));
            }
            return false;
        }
    }

    public ActiveState(IIDCard card) {
        super(card);
    }

}