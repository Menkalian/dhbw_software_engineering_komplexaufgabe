package packagecenter.crypto;

import javax.crypto.spec.SecretKeySpec;

public class DES implements IEncryptionStrategy, IDecryptionStrategy {
    private SecretKeySpec secretKey;
    private byte[] key;

    /**
     * 
     * @param plain
     * @param key
     */
    public String encrypt(String plain, String key) {
        // TODO - implement DES.encrypt @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param encrypted
     * @param key
     */
    public String decrypt(String encrypted, String key) {
        // TODO - implement DES.decrypt @Löh
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @param key
     */
    private void setKey(String key) {
        // TODO - implement DES.setKey @Löh
        throw new UnsupportedOperationException();
    }

}