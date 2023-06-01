package keiser;

import java.io.File;

import edu.duke.FileResource;

public class Cypher {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String shiftedAlphabet = "";
    private String shifted2 = "";
    private final StringBuilder cypherString = new StringBuilder();
    private int key1 = 0;
    private int key2 = 0;
    private String secret = "";

    public Cypher() {
    }

    public Cypher(int key) {
        setKey1(key);
        setShiftedAlphabet();
    }

    public Cypher(int key, String secret) {
        setKey1(key);
        setSecret(secret);
        setShiftedAlphabet();
        setCypherString();
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getShiftedAlphabet() {
        return shiftedAlphabet;
    }

    public void setShiftedAlphabet() {
        this.shiftedAlphabet = alphabet.substring(this.key1) + alphabet.substring(0, this.key1);
    }

    public String getShifted2() {
        return shifted2;
    }

    public void setShifted2() {
        this.shifted2 = alphabet.substring(this.key2) + alphabet.substring(0, this.key2);
    }

    public int getKey1() {
        return key1;
    }

    public void setKey1(int key) {
        this.key1 = key;
    }

    public int getKey2() {
        return key2;
    }

    public void setKey2(int key) {
        this.key2 = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public StringBuilder getCypherString() {
        return cypherString;
    }

    public void setCypherString() {
        encrypt(secret, key1);
    }

    public void encrypt(String input, int key) {
        resetCypherString();
        setKey1(key);
        setSecret(input);
        for (int i = 0; i < secret.length(); i++) {
            int alphabetIndex = 0;
            String letter = String.valueOf(secret.charAt(i));
            boolean isUppercase = !alphabet.contains(letter);
            boolean isCharLetter = alphabet.contains(letter) || alphabet.toUpperCase().contains(letter);
            char currentChar = isUppercase ? secret.toLowerCase().charAt(i) : secret.toUpperCase().charAt(i);
            if (isCharLetter) {

                alphabetIndex = isUppercase ? alphabet.indexOf(currentChar)
                        : alphabet.toUpperCase().indexOf(currentChar);

                char newChar = isUppercase ? shiftedAlphabet.toUpperCase().charAt(alphabetIndex)
                        : shiftedAlphabet.charAt(alphabetIndex);

                cypherString.append(newChar);
            } else {
                cypherString.append(currentChar);
            }
        }
    }

    public void resetCypherString() {
        if (!cypherString.equals("")) {
            cypherString.delete(0, cypherString.length());
        }
    }

    public void testCypher() {
        setShiftedAlphabet();
        FileResource fr = new FileResource();
        setSecret(fr.asString());
        setCypherString();
        System.out.println(alphabet);
        System.out.println(shiftedAlphabet);
        System.out.println("Message to encode: " + secret);
        System.out.println("Encoded message is: " + cypherString);
    }

    public void encryptTwoKeys(String input, int key1, int key2) {
        setKey1(key1);
        setKey2(key2);
        setShiftedAlphabet();
        setShifted2();
        resetCypherString();
        for (int i = 0; i < secret.length(); i++) {
            int alphabetIndex = 0;
            String letter = String.valueOf(secret.charAt(i));
            boolean isUppercase = !alphabet.contains(letter);
            boolean isCharLetter = alphabet.contains(letter) || alphabet.toUpperCase().contains(letter);
            char currentChar = isUppercase ? secret.toLowerCase().charAt(i) : secret.toUpperCase().charAt(i);

            if (isCharLetter) {
                char newChar = ' ';
                alphabetIndex = isUppercase ? alphabet.indexOf(currentChar)
                        : alphabet.toUpperCase().indexOf(currentChar);
                if (i % 2 == 0) {
                    newChar = isUppercase ? shiftedAlphabet.toUpperCase().charAt(alphabetIndex)
                            : shiftedAlphabet.charAt(alphabetIndex);
                } else {
                    newChar = isUppercase ? shifted2.toUpperCase().charAt(alphabetIndex)
                            : shifted2.charAt(alphabetIndex);
                }
                cypherString.append(newChar);
            } else {
                cypherString.append(currentChar);
            }
        }
    }

    public void test2KeyEncryption(int key1, int key2) {
        FileResource fr = new FileResource();
        setSecret(fr.asString());
        encryptTwoKeys(secret, key1, key2);
        System.out.println(alphabet);
        System.out.println(shiftedAlphabet);
        System.out.println(shifted2);
        System.out.println("Message to encode: " + secret);
        System.out.println("Encoded message is: " + cypherString);
    }

    public int biggestIndex(int[] counters) {
        int index = 0;
        int currentIndex = 0;
        for (int i : counters) {
            currentIndex = i;
            if (currentIndex > index) {
                index=currentIndex;
            }
        }
        return index;
    }

    public int mostEsIndex(String input) {
        int[] letterCounters = new int[26];
        for (int i = 0; i < letterCounters.length; i++) {
            for (char letter : input.toCharArray()) {
                if (letter == alphabet.charAt(i)) {
                    letterCounters[i] += 1;
                }
            }
        }
        int index = biggestIndex(letterCounters);
        System.out.println(alphabet.charAt(index));
        return index;
    }

    public void decrypt() {

    }
}
