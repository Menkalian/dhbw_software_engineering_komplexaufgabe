import packagecenter.command.InitCommand;
import packagecenter.incomming.Box;
import packagecenter.incomming.PackageType;
import packagecenter.incomming.Package;
import packagecenter.incomming.Pallet;
import packagecenter.parts.controlling.controlunit.CentralControlUnit;

public class testing {
    public static void main(String[] args) {
        char[][][] c = new char[25][10][10];
        for(int i = 0; i<25; i++){
            for(int j = 0; j<10; j++){
                for(int k = 0; k<10; k++){
                    c[i][j][k] = '!';
                }
            }
        }
        PackageType p = PackageType.EXPRESS;
        Package[] packs = new Package[40];
        for(int i = 0; i<40; i++) {
            packs[i] = new Package("test", c, "0001067", p, 2.52);
        }


        Box box1 = new Box("1");
        Box box2 = new Box("2");
        Box box3 = new Box("3");
        Box box4 = new Box("4");

        for(Package pack : packs) {
            box1.addPackageToBox(pack);
            box2.addPackageToBox(pack);
            box3.addPackageToBox(pack);
            box4.addPackageToBox(pack);
        }

        InitCommand command = new InitCommand();

        command.execute(new CentralControlUnit());

        System.out.println();
    }
}
