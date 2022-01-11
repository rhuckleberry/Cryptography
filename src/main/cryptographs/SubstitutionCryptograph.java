package main.cryptographs;

import main.Utils;

public abstract class SubstitutionCryptograph implements Cryptographs {

    public String encrypt(String message) {
        // Convert message into numeric
        String numericMessage = Utils.alphabeticToNumeric(message);

        // Perform substitution encryption on numeric message
        String cipher = substitutionEncryption(numericMessage);

        // Convert message back into alphabetic
        return Utils.numericToAlphabetic(cipher);
    }

    public String decrypt(String cipher) {
        // Convert cipher into numeric
        String numericCipher = Utils.alphabeticToNumeric(cipher);

        // Perform substitution decryption on numeric cipher
        String message = substitutionDecryption(numericCipher);

        // Convert message into alphabetic
        return Utils.numericToAlphabetic(message);
    }

    /**
     * Substitution encryption method. Converts numeric message into numeric cipher.
     * @param numericMessage numeric message to convert.
     * @return numeric cipher.
     */
    public abstract String substitutionEncryption(String numericMessage);

    /**
     * Substitution encryption method. Converts numeric cipher into numeric message.
     * @param numericCipher numeric cipher to convert.
     * @return numeric message.
     */
    public abstract String substitutionDecryption(String numericCipher);
}
