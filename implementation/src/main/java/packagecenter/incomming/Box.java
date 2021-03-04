package packagecenter.incomming;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private String id;
    private BoxLayer[] layers = {new BoxLayer(), new BoxLayer(), new BoxLayer(), new BoxLayer(), new BoxLayer()};

    public String getId() {
        return this.id;
    }

    public BoxLayer[] getLayers() {
        return this.layers;
    }

    public class BoxLayer {
        private List<Package> leftSide = new ArrayList<>();
        private List<Package> rightSide = new ArrayList<>();

        public List<Package> getLeftSide() {
            return this.leftSide;
        }

        public List<Package> getRightSide() {
            return this.rightSide;
        }

        public boolean addPackageToBoxLayer(Package pack) {
            if(leftSide.size()<4){
                leftSide.add(pack);
                return true;}
            else if(rightSide.size()<4){
                rightSide.add(pack);
                return true;}
            return false;
        }
    }

    public boolean addPackageToBox(Package pack) {
        for(int i = 0; i<5; i++) {
            if(layers[i].addPackageToBoxLayer(pack)) {
               return true;
            }
        }
        return false;
    }

    public Box(String id){
        if(id.matches("(.*)[^a-z0-9](.*)") && id.length() == 5){
            this.id = null;
        } else this.id = id;

    }

}