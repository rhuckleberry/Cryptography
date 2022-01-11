package main;

import main.cryptographs.Atbash;
import main.cryptographs.Caesar;
import main.cryptographs.Cryptographs;

public class Main {
    public static void main(String[] args){
        String message = "cat".toUpperCase();
        System.out.println("Message: " + message);

        Cryptographs cryptograph = new Atbash();

        // Encrypt
        String cipher = cryptograph.encrypt(message);
        System.out.println("Cipher: " + cipher);

        // Decrypt
        String decrypt = cryptograph.decrypt(cipher);
        System.out.println("Decrypt: " + decrypt);

        assert message.equals(decrypt) : "Message and Decryption not equivalent!";



//        String message = "cat".toUpperCase();
//        System.out.println("Message: " + message);
//
//        Cryptographs Caesar = new Caesar(7);
//
//        // Encrypt
//        String cipher = Caesar.encrypt(message);
//        System.out.println("Cipher: " + cipher);
//
//        // Decrypt
//        String decrypt = Caesar.decrypt(cipher);
//        System.out.println("Decrypt: " + decrypt);
//
//        assert message.equals(decrypt) : "Message and Decryption not equivalent!";
    }
}
