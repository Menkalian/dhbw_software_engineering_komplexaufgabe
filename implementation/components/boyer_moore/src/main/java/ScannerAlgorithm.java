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
    int innerScan(String toSearch, char[][][] toScan){return -1;}

    public class Port implements IScannerAlgorithm {
        @Override
        public String getVersion(){return innerGetVersion();}
        @Override
        public int scan(String toSearch, char[][][] toScan){return innerScan(toSearch, toScan);}
    }
}
