package main.cryptographs;

import main.Utils;

public class Caesar extends SubstitutionCryptograph {

    private int key;

    public Caesar(int key) {
        this.key = key;
    }

    public String substitutionEncryption(String numericMessage) {
        StringBuilder cipher = new StringBuilder();

        String[] bigrams = Utils.bigramSplit(numericMessage);
        for (String bigram: bigrams) {
            int number = Integer.parseInt(bigram);
            String caesar = Integer.toString((number + key) % 26); // Caesar encryption!
            if (caesar.length() == 1) { // Ensure all numeric mappings have the same length
                caesar = "0"+ caesar;
            }
            cipher.append(caesar);
        }
        return cipher.toString();
    }

    public String substitutionDecryption(String numericCipher) {
        StringBuilder message = new StringBuilder();

        String[] bigrams = Utils.bigramSplit(numericCipher);
        for (String bigram: bigrams) {
            int number = Integer.parseInt(bigram);
            String inverseCaesar = Integer.toString((number - key + 26) % 26); // Caesar encryption!
            if (inverseCaesar.length() == 1) { // Ensure all numeric mappings have the same length
                inverseCaesar = "0"+ inverseCaesar;
            }
            message.append(inverseCaesar);
        }
        return message.toString();
    }

    /**
     * Gets the caesar cipher key.
     * NOTE: Do not give keys to other people or it renders the encryption useless
     * (although caesar method is easily breakable anyways!)
     * @param key key being used for caesar cipher.
     */
    public int getKey(int key) {
        return this.key;
    }

    /**
     * Sets the caesar cipher key.
     * @param key new key for caesar cipher.
     */
    public void setKey(int key) {
        this.key = key;
    }
}
