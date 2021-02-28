package packagecenter.crypto;

public interface IDecryptionStrategy {

    /**
     * 
     * @param encrypted
     * @param key
     */
    String decrypt(String encrypted, String key);

}