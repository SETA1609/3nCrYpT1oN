package keiser;

public class Cypher {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String shiftedAlphabet = "";
    private StringBuilder cypherString = new StringBuilder ();
    private int key = 0;
    private String secret = "";

    public Cypher() {
    }

    public Cypher(int key, String secret) {
        setKey (key);
        setSecret (secret);
        setShiftedAlphabet ();
        setCypherString ();
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
        this.shiftedAlphabet = alphabet.substring (this.key) + alphabet.substring (0, this.key);
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
        for (int i = 0; i < secret.length (); i++) {
            int tmp = 0;
            char currentChar = secret.toLowerCase ().charAt (i);
            if (currentChar != ' ') {
                tmp = alphabet.indexOf (currentChar);
                char newChar = shiftedAlphabet.charAt (tmp);
                cypherString.append (newChar);
            } else {
                cypherString.append (" ");
            }
        }
    }
}
