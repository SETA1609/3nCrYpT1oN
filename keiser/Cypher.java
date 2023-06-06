package keiser;

import java.util.HashMap;

public class Cypher {
    private int key1 = 0;
    private int key2 = 0;
    private HashMap<Integer, Character> alpha;
    private HashMap<Character, Character> encrypt1;
    private HashMap<Character, Character> encrypt2;
    private HashMap<Character, Character> decrypt1;
    private HashMap<Character, Character> decrypt2;
    private String input;
    private String output;

    public Cypher() {
    }

    public Cypher(int key1, String input) {
        this.key1 = key1;
        this.input = input;
        setAlpha();
        setEncrypt1();
        setOutput();
    }

    public Cypher(int key1, int key2, String input) {
        this.key1 = key1;
        this.key2 = key2;
        this.input = input;
        setAlpha();
        setEncrypt1();
        setEncrypt2();
        setOutput();
    }

    public int getKey1() {
        return key1;
    }

    public void setKey1(int key1) {
        this.key1 = key1;
    }

    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    public HashMap<Integer, Character> getAlpha() {
        return alpha;
    }

    public void setAlpha() {
        alpha = new HashMap<>();
        int i = 1;
        for (char a = 'a'; a <= 'z'; a++) {
            alpha.put(i, a);
            i++;
        }
    }

    public HashMap<Character, Character> getEncrypt1() {
        return encrypt1;
    }

    public void setEncrypt1() {
        encrypt1 = new HashMap<>();
        int offset = key1;
        int i = 1;
        for (char a = 'a'; a <= 'z'; a++) {
            char currentChar = (char) (a + offset);
            if (currentChar < 122) {
                encrypt1.put(a, currentChar);
            }

            if (currentChar > 122) {
                currentChar = (char) (currentChar - 26);
                encrypt1.put(a, currentChar);
            }

            i++;
        }
    }

    public HashMap<Character, Character> getEncrypt2() {
        return encrypt2;
    }

    public void setEncrypt2() {
        encrypt2 = new HashMap<>();
        int offset = key2;
        int i = 1;
        for (char a = 'a'; a <= 'z'; a++) {
            char currentChar = (char) (a + offset);
            if (currentChar < 122) {
                encrypt2.put(a, currentChar);
            }

            if (currentChar > 122) {
                currentChar = (char) (currentChar - 26);
                encrypt2.put(a, currentChar);
            }

            i++;
        }
    }

    public HashMap<Character, Character> getDecrypt1() {
        return decrypt1;
    }

    public void setDecrypt1(int key) {
        decrypt1 = new HashMap<>();
        int offset = key;
        int i = 1;
        for (char a = 'a'; a <= 'z'; a++) {
            char currentChar = (char) (a + offset);
            if (currentChar < 122) {
                decrypt1.put(a, currentChar);
            }

            if (currentChar > 122) {
                currentChar = (char) (currentChar - 26);
                decrypt1.put(a, currentChar);
            }

            i++;
        }
    }

    public HashMap<Character, Character> getDecrypt2() {
        return decrypt2;
    }

    public void setDecrypt2(int key) {
        decrypt2 = new HashMap<>();
        int offset = key;
        int i = 1;
        for (char a = 'a'; a <= 'z'; a++) {
            char currentChar = (char) (a + offset);
            if (currentChar < 122) {
                decrypt2.put(a, currentChar);
            }

            if (currentChar > 122) {
                currentChar = (char) (currentChar - 26);
                decrypt2.put(a, currentChar);
            }

            i++;
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput() {
        StringBuilder sb = new StringBuilder();

        if (key1 != 0 && key2 == 0) {
            for (char c : input.toCharArray()) {
                boolean isLetter = Character.isLetter(c);
                if (isLetter) {
                    boolean isUppercase = Character.isUpperCase(c);
                    char newChar = isUppercase ? (char) (encrypt1.get(c) - 32) : encrypt1.get(c);
                    sb.append(newChar);
                } else {
                    sb.append(c);
                }
            }
        }

        if (key1 != 0 && key2 != 0) {
            for (int i = 0; i < input.length(); i++) {
                char crrntChar = input.charAt(i);
                boolean isLetter = Character.isLetter(crrntChar);
                if (isLetter) {
                    boolean isUppercase = Character.isUpperCase(crrntChar);
                    if (isUppercase) {
                        char newChar = (i % 2 == 0) ? (char) (encrypt1.get(crrntChar) - 32) : (char) (encrypt2.get(crrntChar) - 32);
                        sb.append(newChar);
                    } else {
                        char newChar = (i % 2 == 0) ? encrypt1.get(crrntChar) : encrypt2.get(crrntChar);
                        sb.append(newChar);
                    }
                } else {
                    sb.append(crrntChar);
                }
            }
        }
        output = sb.toString();
    }

    public void reset() {
        setInput("");
        setKey1(0);
        setKey2(0);
        setOutput();
    }

}
