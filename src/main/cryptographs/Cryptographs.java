package main.cryptographs;

public interface Cryptographs {

    /**
     * Encrypts message into cipher.
     * @param message message to encrypt.
     * @return encrypted cipher.
     */
    public String encrypt(String message);

    /**
     * Decrypts cipher into message.
     * @param cipher encrypted cipher.
     * @return decrypted message.
     */
    public String decrypt(String cipher);
}
