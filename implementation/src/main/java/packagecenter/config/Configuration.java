package packagecenter.config;

import packagecenter.crypto.AES;
import packagecenter.crypto.IDecryptionStrategy;
import packagecenter.crypto.IEncryptionStrategy;
import packagecenter.parts.sortingsystem.tracks.sorting.SearchAlgorithm;

import java.io.File;

public enum Configuration {
    INSTANCE;

    public String idCardEncryptionKey = "dhbw";
    public IEncryptionStrategy encryptionStrategy = new AES();
    public IDecryptionStrategy decryptionStrategy = new AES();

    public String rabinKarpJarPath = constructComponentPath("rabin_karp");
    public String boyerMooreJarPath = constructComponentPath("boyer_moore");

    public SearchAlgorithm initialSearchAlgorithm = SearchAlgorithm.RABIN_KARP;

    private String constructComponentPath(String component) {
        return System.getenv("user.home") + File.separator + "components" + File.separator + component + File.separator + "build" + File.separator + "libs" + File.separator + component + ".jar";
    }
}