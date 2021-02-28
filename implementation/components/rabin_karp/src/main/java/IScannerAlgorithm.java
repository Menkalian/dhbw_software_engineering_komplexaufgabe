public interface IScannerAlgorithm {
  String getVersion();
  int scan(String toSearch, byte[][][] toScan);
}
