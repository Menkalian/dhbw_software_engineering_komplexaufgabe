package packagecenter.incomming;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pallet {
    private int id;
    private int lastId=0;
    private PalletPosition[][] positions = {{new PalletPosition(), new PalletPosition()},{new PalletPosition(), new PalletPosition()}};

    public int getId() {
        return this.id;
    }

    public PalletPosition[][] getPositions() {
        return this.positions;
    }

    public static class PalletPosition {
        private final Deque<Box> boxes = new ArrayDeque<>(3);

        public Deque<Box> getBoxes() {
            return this.boxes;
        }

        public boolean addBoxToPalletPosition(Box box){
            if(boxes.size()<3) {
                boxes.add(box);
                return true;
            } return false;
        }
    }

    public boolean addBoxToPallet(Box box){
        for(int i = 0; i<2; i++){
            for (int j = 0; j < 2; j++) {
                if(positions[i][j].addBoxToPalletPosition(box)) return true;
            }
        } return false;
    }

    public Pallet(){
        this.id = lastId + 1;
        lastId++;
    }

}