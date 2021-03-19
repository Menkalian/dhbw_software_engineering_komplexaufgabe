package packagecenter.parts.sortingsystem.storage;

import java.util.ArrayList;
import java.util.List;

public class TempStorageArea implements ITempStorageArea {
    private final List<ITempStoragePosition> positions = new ArrayList<>(5);

    public TempStorageArea() {
        for (int i = 0; i < 5; i++) {
            positions.add(new TempStoragePosition());
        }
    }

    public List<ITempStoragePosition> getPositions() {
        return positions;
    }

}