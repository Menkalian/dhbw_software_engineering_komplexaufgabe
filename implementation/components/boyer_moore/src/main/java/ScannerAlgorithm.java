public class ScannerAlgorithm {
    // static instance
    private static ScannerAlgorithm instance = new ScannerAlgorithm();
    // port
    public Port port;

    private ScannerAlgorithm() {
        port = new Port();
    }

    // TODO
    String innerGetVersion(){return "";}
    int innerScan(String toSearch, byte[][][] toScan){return -1;}

    public class Port implements IScannerAlgorithm {
        @Override
        String getVersion(){return innerGetVersion();}
        @Override
        int scan(String toSearch, byte[][][] toScan){return innerScan(toSearch, toScan);}
    }
}
