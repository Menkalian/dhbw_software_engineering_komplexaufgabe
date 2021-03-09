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
        private final Box[] boxes = new Box[3];

        public Box[] getBoxes() {
            return this.boxes;
        }

        public boolean addBoxToPalletPosition(Box box, int level){
            if(level<4 && level >= 0) {
                boxes[level] = box;
                return true;
            } return false;
        }
    }

    public boolean addBoxToPallet(Box box, int position, int level){
        if(position == 0){
            if(positions[0][0].addBoxToPalletPosition(box, level))
                return true;
        }
        if(position == 1){
            if(positions[0][1].addBoxToPalletPosition(box, level))
                return true;
        }
        if(position == 2){
            if(positions[1][0].addBoxToPalletPosition(box, level))
                return true;
        }
        if(position == 3){
            if(positions[1][1].addBoxToPalletPosition(box, level))
                return true;
        }


                return false;
    }

    public Pallet(){
        this.id = lastId + 1;
        lastId++;
    }

}