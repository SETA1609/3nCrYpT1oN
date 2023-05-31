package keiser;

import java.io.File;

import edu.duke.FileResource;

public class Cypher {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String shiftedAlphabet = "";
    private final StringBuilder cypherString = new StringBuilder();
    private int key = 0;
    private String secret = "";

    public Cypher() {
    }

    public Cypher(int key) {
        setKey(key);
        setShiftedAlphabet();
    }

    public Cypher(int key, String secret) {
        setKey(key);
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
        this.shiftedAlphabet = alphabet.substring(this.key) + alphabet.substring(0, this.key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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

    public void testCypher() {
        if (!cypherString.equals("")) {
            cypherString.delete(0, cypherString.length());
        }
        setShiftedAlphabet();
        FileResource fr = new FileResource();
        setSecret(fr.asString());
        setCypherString();
        System.out.println(alphabet);
        System.out.println(shiftedAlphabet);
        System.out.println("Message to encode: " + secret);
        System.out.println("Encoded message is: " + cypherString);
    }
}
