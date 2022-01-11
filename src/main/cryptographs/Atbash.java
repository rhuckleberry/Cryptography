package main.cryptographs;

import main.Utils;

public class Atbash extends SubstitutionCryptograph {

    public String substitutionEncryption(String numericMessage) {
        StringBuilder cipher = new StringBuilder();

        String[] bigrams = Utils.bigramSplit(numericMessage);
        for (String bigram: bigrams) {
            int number = Integer.parseInt(bigram);
            String atbash = Integer.toString(25 - number); // Caesar encryption!
            if (atbash.length() == 1) { // Ensure all numeric mappings have the same length
                atbash = "0" + atbash;
            }
            cipher.append(atbash);
        }
        return cipher.toString();
    }

    public String substitutionDecryption(String numericCipher) {
        // Decryption and Encryption for the Atbash cipher are equivalent!
        // This is a reflection cipher and reflection is an involution!
        return substitutionEncryption(numericCipher);
    }

}
