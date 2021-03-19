package packagecenter.incomming;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private final String id;
    private final BoxLayer[] layers = {new BoxLayer(), new BoxLayer(), new BoxLayer(), new BoxLayer(), new BoxLayer()};

    public String getId() {
        return this.id;
    }

    public BoxLayer[] getLayers() {
        return this.layers;
    }

    public List<Package> getPackages(){
        List<Package> packageList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            packageList.addAll(layers[i].leftSide);
            packageList.addAll(layers[i].rightSide);
        }

        return packageList;
    }

    public static class BoxLayer {
        private final List<Package> leftSide = new ArrayList<>();
        private final List<Package> rightSide = new ArrayList<>();

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