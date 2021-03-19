package packagecenter.parts.controlling.terminal;

import packagecenter.config.Configuration;
import packagecenter.employee.card.*;

import java.nio.charset.StandardCharsets;

public class CardReader implements ICardReader {
    private final ITerminal terminal;
    private IIDCard lastCardSwept;

    public void swipeCard(IIDCard card) {
        lastCardSwept = card;
    }

    public boolean enterPIN(String pin) {
        if(lastCardSwept.checkPIN(pin)){
            byte[] encrypted = new byte[100];

            for (int i = 0; i < 100; i++) {
                encrypted[i] = lastCardSwept.getStripe()[i][0];
            }
            String str = new String(encrypted, StandardCharsets.UTF_8);
            String decrypted = Configuration.INSTANCE.decryptionStrategy.decrypt(str, Configuration.INSTANCE.idCardEncryptionKey);

            String[] strArr = decrypted.split(";");
            //ToDo: employeeId -> Employee
            //terminal.setCurrentEmployee(strArr[0]);

            terminal.setCurrentEmployee(null);
        }
        return lastCardSwept.checkPIN(pin);
    }

    public CardReader(ITerminal terminal) {
        this.terminal = terminal;
    }

}