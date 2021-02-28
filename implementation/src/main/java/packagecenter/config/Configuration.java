package packagecenter.config;

import packagecenter.crypto.*;
import packagecenter.parts.sortingsystem.tracks.sorting.*;

public enum Configuration {
    INSTANCE;
    public String idCardEncryptionKey = "dhbw";
    public IEncryptionStrategy encryptionStrategy = new AES();
    public IDecryptionStrategy decryptionStrategy = new AES();
    public String rabinKarpJarPath;
    public String boyerMooreJarPath;
    public SearchAlgorithm initialSearchAlgorithm;

}