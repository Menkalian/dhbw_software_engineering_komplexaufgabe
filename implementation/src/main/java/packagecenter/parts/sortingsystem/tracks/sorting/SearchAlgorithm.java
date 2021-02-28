package packagecenter.parts.sortingsystem.tracks.sorting;

public enum SearchAlgorithm {
    BOYER_MOORE("bm"),
    RABIN_KARP("rk");
    private String signature;

    public String getSignature() {
        return this.signature;
    }

    /**
     * 
     * @param signature
     */
    SearchAlgorithm(String signature) {
        // TODO - implement SearchAlgorithm.SearchAlgorithm @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param signature
     */
    public static SearchAlgorithm getBySignature(String signature) {
        // TODO - implement SearchAlgorithm.getBySignature @Löh
        throw new UnsupportedOperationException();
    }

}