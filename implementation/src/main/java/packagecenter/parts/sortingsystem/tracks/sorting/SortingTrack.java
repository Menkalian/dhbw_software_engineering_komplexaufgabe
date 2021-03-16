package packagecenter.parts.sortingsystem.tracks.sorting;

import packagecenter.incomming.Package;

import java.util.LinkedList;
import java.util.List;

public abstract class SortingTrack {
    private final SortingTrack successor;
    private final List<Package> packages;
    private final IScanner scanner;
    private final List<Package> dangerousPackages;

    public SortingTrack(SortingTrack successor) {
        this.successor = successor;

        scanner = new Scanner();
        packages = new LinkedList<>();
        dangerousPackages = new LinkedList<>();
    }

    public List<Package> getPackages() {
        return this.packages;
    }

    public IScanner getScanner() {
        return this.scanner;
    }

    public List<Package> getDangerousPackages() {
        return this.dangerousPackages;
    }

    public abstract boolean doesAccept(Package pkg);

    public void accept(Package pkg) {
        if (doesAccept(pkg)) {
            if(scanner.scan(pkg)){
                dangerousPackages.add(pkg);
                System.out.println("Package " + pkg.getId() + " sorted out and destroyed!");
            } else {
                packages.add(pkg);
            }
        } else {
            successor.accept(pkg);
        }
    }

}