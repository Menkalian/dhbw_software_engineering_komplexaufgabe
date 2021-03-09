package packagecenter.command;

import packagecenter.incomming.*;
import packagecenter.incomming.Package;
import packagecenter.parts.controlling.controlunit.ICentralControlUnit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class InitCommand implements ICommand {

    /**
     * 
     * @param controlUnit
     */
    public void execute(ICentralControlUnit controlUnit) {

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader brPackage = new BufferedReader(new FileReader("../resources/base_package.csv"))) {
            String line;
            while ((line = brPackage.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        String id;
        char[][][] content = new char[25][10][10];
        String zipCode;
        PackageType type;
        double weight;

        List<Package> packages = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {

            id = records.get(i).get(0);

            Stack<Character> contentChars = new Stack<>();
            for (int j = 0; j < records.get(i).get(1).length(); j++) {
                contentChars.push(records.get(i).get(1).charAt(j));
            }
            for (int j = 0; j < 25; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        content[j][k][l] = contentChars.pop();
                    }
                }
            }

            zipCode = records.get(i).get(2);

            type = PackageType.valueOf(records.get(i).get(3));

            weight = Double.valueOf(records.get(i).get(4));

            Package pack = new Package(id, content, zipCode, type, weight);

            packages.add(pack);
        }

        records.clear();
        try (BufferedReader brBox = new BufferedReader(new FileReader("../resources/base_box.csv"))) {
            String line;
            while ((line = brBox.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        List<Box> boxes = new ArrayList<>();
        HashSet<String> boxIds = new HashSet<>();
        for (int i = 0; i < records.size(); i++) {
            boxIds.add(records.get(i).get(0));
        }
        for(String boxId : boxIds){
            boxes.add(new Box(boxId));
        }
        for (int j = 0; j < records.size(); j++) {
            for (Box box : boxes) {
                if(box.getId().equals(records.get(j).get(0))) {
                    for (int i = 0; i < packages.size(); i++) {
                        if(packages.get(i).getId() == records.get(j).get(1)){
                            box.addPackageToBox(packages.get(i));
                        }
                    }
                }
            }
        }

        records.clear();
        try (BufferedReader brPallet = new BufferedReader(new FileReader("../resources/base_pallet.csv"))) {
            String line;
            while ((line = brPallet.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        List<Pallet> Pallets = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Pallets.add(new Pallet());
        }
        for (int i = 0; i < records.size(); i++) {
            for(Pallet pallet : Pallets){
                if(records.get(i).get(0).equals(pallet.getId())) {
                    for (int j = 0; j < boxes.size(); j++) {
                        if(records.get(i).get(3).equals(boxes.get(j).getId())){
                            pallet.addBoxToPallet(boxes.get(j), Integer.valueOf(records.get(i).get(1)), Integer.valueOf(records.get(i).get(2)));
                        }
                    }
                }
            }
        }

        records.clear();
        try (BufferedReader brTruck = new BufferedReader(new FileReader("../resources/base_truck.csv"))) {
            String line;
            while ((line = brTruck.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        List<Truck> Trucks = new ArrayList<>();
        HashSet<String> truckIds = new HashSet<>();
        for (int i = 0; i < records.size(); i++) {
            truckIds.add(records.get(i).get(0));
        }
        for(String truckId : truckIds){
            Trucks.add(new Truck(truckId));
        }
        for (int i = 0; i < records.size(); i++) {
            for (Truck truck : Trucks){
                if (records.get(i).get(0).equals(truck.getId())){
                    for (int j = 0; j < Pallets.size(); j++) {
                        if(records.get(i).get(3).equals(Pallets.get(j).getId())){
                            truck.addPalletToTruck(Pallets.get(j), records.get(i).get(1), Integer.valueOf(records.get(i).get(2)));
                        }
                    }
                }
            }
        }

        System.out.println();
    }

    public CommandType getType() {
        // TODO - implement InitCommand.getType @Löh
        throw new UnsupportedOperationException();
    }

}