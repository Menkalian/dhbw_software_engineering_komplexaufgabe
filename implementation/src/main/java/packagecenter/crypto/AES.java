package packagecenter.crypto;

import javax.crypto.spec.SecretKeySpec;

public class AES implements IEncryptionStrategy, IDecryptionStrategy {
    private SecretKeySpec secretKey;
    private byte[] key;

    /**
     * 
     * @param plain
     * @param key
     */
    public String encrypt(String plain, String key) {
        // TODO - implement AES.encrypt @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param encrypted
     * @param key
     */
    public String decrypt(String encrypted, String key) {
        // TODO - implement AES.decrypt @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param key
     */
    private void setKey(String key) {
        // TODO - implement AES.setKey @Löh
        throw new UnsupportedOperationException();
    }

}