import java.util.Arrays;

import static java.lang.Math.max;

public class ScannerAlgorithm {
    private static final int d = 256; // Size of alphabet = 256

    // static instance
    private static ScannerAlgorithm instance = new ScannerAlgorithm();

    // port
    public Port port;

    private ScannerAlgorithm() {
        port = new Port();
    }

    String innerGetVersion() {
        return "bm_01";
    }

    int innerScan(String pattern, char[][][] text) {
        char[] pat = pattern.toCharArray();
        char[] txt = new char[text.length * text[0].length * text[0][0].length];

        int m = pat.length;
        int n = txt.length;


        int x = text[0][0].length;
        int y = x * text[0].length;
        for (int i = 0 ; i < n ; i++) {
            txt[i] = text[i / y][i / x][i % x];
        }

        int[] badChars = heuristic(pat);
        int shift = 0;
        while (shift <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[shift + j])
                j--;

            if (j < 0) {
                return shift;
            }

            shift += max(1, j - badChars[txt[shift + j]]);
        }

        return -1;
    }

    private int[] heuristic(char[] text) {
        int[] badChars = new int[d];
        Arrays.fill(badChars, -1);

        for (int i = 0 ; i < text.length ; i++) {
            badChars[text[i]] = i;
        }

        return badChars;
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
