import java.util.function.Function;

public class ScannerAlgorithm {
    private static final int d = 256; // Size of alphabet = 256
    private static final int q = 101; // some prime

    // static instance
    private static ScannerAlgorithm instance = new ScannerAlgorithm();
    // port
    public Port port;

    private ScannerAlgorithm() {
        port = new Port();
    }

    public String innerGetVersion() {
        return "rk_01";
    }

    public int innerScan(String pattern, char[][][] text) {
        int m = pattern.length();
        int n = text.length * text[0].length * text[0][0].length;

        int x = text[0][0].length;
        int y = text[0].length;
        Function<Integer, Character> txtAt = i -> text[i / (x * y)][(i / x) % y][i % x];

        int p = 0; // Hash value of the pattern
        int t = 0; // Hash value of the  current textwindow
        int h = 1;

        for (int i = 0 ; i < m ; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text[i / y][i / x][i % x]) % q;
        }

        // Slide over text one by one
        for (int i = 0 ; i < n - m ; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < m ; j++) {
                    if (txtAt.apply(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == m)
                    return i;
            }

            // Calculate next window by removing the first char and adding the next
            if (i < n - m) {
                t = (d * (t - txtAt.apply(i) * h) + txtAt.apply(i + m)) % q;
            }
        }

        return -1;
    }

    public class Port implements IScannerAlgorithm {
        @Override
        public String getVersion() {
            return innerGetVersion();
        }

        @Override
        public int scan(String toSearch, char[][][] toScan) {
            return innerScan(toSearch, toScan);
        }
    }
}
