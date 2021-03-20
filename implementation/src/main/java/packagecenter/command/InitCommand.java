package packagecenter.command;

import packagecenter.incomming.Box;
import packagecenter.incomming.Package;
import packagecenter.incomming.PackageType;
import packagecenter.incomming.Pallet;
import packagecenter.incomming.Truck;
import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InitCommand implements ICommand {

    public void execute(ICentralControlUnit controlUnit) {
        Map<String, Package> packages;
        final Map<String, Box> boxes = new HashMap<>(); // Final for synchronization
        Map<Integer, Pallet> pallets = new HashMap<>();
        Map<String, Truck> trucks = new HashMap<>();

        try {
            InputStream packageCsv = getClass().getClassLoader().getResourceAsStream("base_package.csv");
            if (packageCsv != null) {
                String packageString = new String(packageCsv.readAllBytes());
                packages = packageString.lines().map(line -> {
                    String[] segments = line.split(",");

                    String id = segments[0];
                    String zipCode = segments[2];
                    PackageType type = PackageType.valueOf(segments[3]);
                    double weight = Double.parseDouble(segments[4]);

                    char[] contentRaw = segments[1].toCharArray();
                    char[][][] content = new char[25][10][10];

                    for (int i = 0 ; i < 25 ; i++) {
                        for (int j = 0 ; j < 10 ; j++) {
                            content[i][j] = Arrays.copyOfRange(contentRaw, (i * 10 + j) * 10, ((i * 10 + j) * 10) + 10);
                        }
                    }

                    return new Package(id, content, zipCode, type, weight);
                }).collect(Collectors.toMap(Package::getId, it -> it));
            } else {
                throw new RuntimeException("Could not parse packages CSV");
            }

            InputStream boxCsv = getClass().getClassLoader().getResourceAsStream("base_box.csv");
            if (boxCsv != null) {
                String boxesString = new String(boxCsv.readAllBytes());

                boxesString.lines().forEach(line -> {
                    String[] split = line.split(",");
                    String id = split[0];
                    Box toAdd;

                    synchronized (boxes) {
                        if (boxes.containsKey(id)) {
                            toAdd = boxes.get(id);
                        } else {
                            toAdd = new Box(id);
                            boxes.put(id, toAdd);
                        }
                    }

                    toAdd.addPackage(packages.get(split[1]));
                });
            } else {
                throw new RuntimeException("Could not parse box CSV");
            }

            InputStream palletCsv = getClass().getClassLoader().getResourceAsStream("base_pallet.csv");
            if (palletCsv != null) {
                String palletsString = new String(palletCsv.readAllBytes());

                palletsString.lines().forEachOrdered(line -> { // forEachOrdered is synchronous
                    String[] split = line.split(",");
                    int id = Integer.parseInt(split[0]);
                    Pallet toAdd;

                    if (pallets.containsKey(id)) {
                        toAdd = pallets.get(id);
                    } else {
                        toAdd = new Pallet();
                        pallets.put(id, toAdd);
                    }

                    toAdd.addBox(
                            boxes.get(split[3]),
                            Integer.parseInt(split[1]),
                            Integer.parseInt(split[2])
                    );
                });
            } else {
                throw new RuntimeException("Could not parse pallet CSV");
            }

            InputStream truckCsv = getClass().getClassLoader().getResourceAsStream("base_truck.csv");
            if (truckCsv != null) {
                String trucksString = new String(truckCsv.readAllBytes());

                trucksString.lines().forEachOrdered(line -> { // forEachOrdered is synchronous
                    String[] split = line.split(",");
                    String id = split[0];
                    Truck toAdd;

                    if (trucks.containsKey(id)) {
                        toAdd = trucks.get(id);
                    } else {
                        toAdd = new Truck(id);
                        trucks.put(id, toAdd);
                    }

                    toAdd.addPallet(
                            pallets.get(Integer.parseInt(split[3])),
                            split[1],
                            Integer.parseInt(split[2])
                    );
                });
            } else {
                throw new RuntimeException("Could not parse pallet CSV");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Take the reference to the trucks-array and fill it
        List<Truck> truckList = new ArrayList<>(trucks.values());
        Truck[] truckArray = controlUnit.getPackageSortingCenter().getWaitingArea().getTrucks();

        for (int i = 0 ; i < truckList.size() ; i++) {
            truckArray[i] = truckList.get(i);
        }
    }

    public CommandType getType() {
        return CommandType.INIT;
    }

}