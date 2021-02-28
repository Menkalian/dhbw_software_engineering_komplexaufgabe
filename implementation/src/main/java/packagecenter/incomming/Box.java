package packagecenter.incomming;

public class Box {
    private String id;
    private BoxLayer layers;

    public String getId() {
        return this.id;
    }

    public BoxLayer getLayers() {
        return this.layers;
    }

    public class BoxLayer {
        private Package leftSide;
        private Package rightSide;

        public Package getLeftSide() {
            return this.leftSide;
        }

        public Package getRightSide() {
            return this.rightSide;
        }

    }

}