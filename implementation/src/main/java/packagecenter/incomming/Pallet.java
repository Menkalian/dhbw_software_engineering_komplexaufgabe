package packagecenter.incomming;

import java.util.ArrayDeque;

public class Pallet {
    private int id;
    private PalletPosition positions;

    public int getId() {
        return this.id;
    }

    public PalletPosition getPositions() {
        return this.positions;
    }

    public static class PalletPosition {
        private final java.util.Deque<Box> boxes = new ArrayDeque<>(3);

        public java.util.Deque<Box> getBoxes() {
            return this.boxes;
        }

    }

}