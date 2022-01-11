package main;

import java.util.HashMap;

public class Utils {

    /**
     * String of the alphabet.
     */
    private final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Mapping of alphabetic characters to their numeric indices.
     */
    private final static HashMap<String, String> basicAlphabetToNumericMap = generateBasicAlphabetToNumericMap();

    /**
     * Mapping of alphabetic character's numeric indices to the alphabetic character.
     */
    private final static HashMap<String, String> basicNumericToAlphabeticMap = generateBasicNumericToAlphabeticMap();

    /**
     * @return Generates basic alphabetic to numeric mapping.
     */
    private static HashMap<String, String> generateBasicAlphabetToNumericMap() {
        HashMap<String, String> map = new HashMap<>();

        for (int i=0; i < alphabet.length(); i++) {
            String alphabetic = String.valueOf(alphabet.charAt(i));
            String numeric = Integer.toString(i);
            if (numeric.length() == 1) { // Ensure all numeric mappings have the same length
                numeric = "0" + numeric;
            }
            map.put(alphabetic, numeric);
        }

        return map;
    }

    /**
     * @return Generates basic numeric to alphabetic mapping.
     */
    private static HashMap<String, String> generateBasicNumericToAlphabeticMap() {
        HashMap<String, String> map = new HashMap<>();

        for (int i=0; i < alphabet.length(); i++) {
            String alphabetic = String.valueOf(alphabet.charAt(i));
            String numeric = Integer.toString(i);
            if (numeric.length() == 1) { // Ensure all numeric mappings have the same length
                numeric = "0" + numeric;
            }
            map.put(numeric, alphabetic);
        }

        return map;
    }

    /**
     * Converts message into a new one mapped by the input mapping by single characters.
     * @param msg original message.
     * @param map mapping form original character to new character.
     * @return new message.
     */
    public static String singleConvert(String msg, HashMap<String, String> map) {
        // Upper case the message.
        String message = msg.toUpperCase();

        StringBuilder numeric = new StringBuilder();
        for (int i=0; i < message.length(); i++) {
            String letter = String.valueOf(message.charAt(i));
            assert map.containsKey(letter) : "Letter not contained in mapping.";
            numeric.append(map.get(letter));
        }

        return numeric.toString();
    }

    /**
     * Converts message into a new one mapped by the input mapping by bigrams.
     * @param msg original message.
     * @param map mapping form original character to new character.
     * @return new message.
     */
    public static String bigramConvert(String msg, HashMap<String, String> map) {
        // Upper case the message.
        String message = msg.toUpperCase();

        // Split message into bigrams
        String[] bigrams = bigramSplit(message);

        // Convert message by bigrams
        StringBuilder numeric = new StringBuilder();
        for (String bigram : bigrams) {
            assert map.containsKey(bigram) : "Bigram not contained in mapping.";
            numeric.append(map.get(bigram));
        }

        return numeric.toString();
    }

    /**
     * Converts alphabetic message into numeric message.
     * @param msg original alphabetic message.
     * @return new numeric message.
     */
    public static String alphabeticToNumeric(String msg) {
        return singleConvert(msg, basicAlphabetToNumericMap);
    }

    /**
     * Converts numeric message into alphabetic message.
     * @param msg original numeric message.
     * @return new alphabetic message.
     */
    public static String numericToAlphabetic(String msg) {
        return bigramConvert(msg, basicNumericToAlphabeticMap);
    }

    /**
     * Splits string into a list of string bigrams.
     * @param str string to split.
     * @return list of string bigrams.
     */
    public static String[] bigramSplit(String str) {
        assert str.length() % 2 == 0 : "Input does not have an even number of characters.";
        int numBigrams = str.length() / 2;
        String[] bigrams = new String[numBigrams];

        for (int i=0; i < numBigrams; i++) {
            bigrams[i] = str.substring(i*2, (i+1)*2);
        }

        return bigrams;
    }

}
