package packagecenter.employee.card;

import packagecenter.config.Configuration;
import packagecenter.employee.Employee;
import packagecenter.employee.card.state.ActiveState;
import packagecenter.employee.card.state.IDCardState;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IDCard implements IIDCard {
    private final byte[][] stripe = new byte[100][1];
    private IDCardState state = new ActiveState(this);

    public byte[][] getStripe() {
        return this.stripe;
    }

    public IDCard(Employee employee) {
        Random rng = new Random(employee.getId());

        String pin = Stream.of(1, 1, 1, 1).map(r -> rng.nextInt(10) + "").collect(Collectors.joining());
        String superPin = Stream.of(1, 1, 1, 1, 1, 1).map(r -> rng.nextInt(10) + "").collect(Collectors.joining());

        String plainStripe = String.join(";", Arrays.asList(
                String.valueOf(employee.getId()),
                employee.getName(),
                employee.getClass().getSimpleName(),
                pin,
                superPin
        ));

        byte[] encrypted = Configuration.INSTANCE.encryptionStrategy.encrypt(plainStripe, Configuration.INSTANCE.idCardEncryptionKey).getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < encrypted.length; i++) {
            stripe[i][0] = encrypted[i];
        }
    }

    public boolean checkPIN(String input) {
        return state.checkPIN(input);
    }

    public IDCardState getState() {
        return this.state;
    }

    public void setState(IDCardState state) {
        this.state = state;
    }

}