package packagecenter.crypto;

public interface IEncryptionStrategy {

    /**
     * 
     * @param plain
     * @param key
     */
    String encrypt(String plain, String key);

}