package packagecenter.parts.sortingsystem.storage;

import java.util.List;

public class TempStorageArea implements ITempStorageArea {
    private final java.util.List<ITempStoragePosition> positions;

    public TempStorageArea(java.util.List<ITempStoragePosition> positions) {
        this.positions = positions;
    }

    public List<ITempStoragePosition> getPositions() {
        return positions;
    }

}