package packagecenter.parts.sortingsystem.tracks.sorting;

import java.util.Arrays;

public enum SearchAlgorithm {
    BOYER_MOORE("bm"),
    RABIN_KARP("rk");
    private final String signature;

    public String getSignature() {
        return this.signature;
    }

    SearchAlgorithm(String signature) {
        this.signature = signature;
    }


    public static SearchAlgorithm getBySignature(String signature) {
        return Arrays.stream(values()).filter(algo -> algo.getSignature().equals(signature)).findFirst().orElse(null);
    }

}