package keiser;

import java.util.HashMap;

public class CaesarCipherTwo {

    private int key1;
    private int key2;
    private int decryptionKey1;
    private int decryptionKey2;
    private String text;
    private HashMap<Integer, Character> alphabet=new HashMap<>();
    private HashMap<Character, Character> shiftedWithKey1 = new HashMap<>();
    private HashMap<Character, Character> shiftedWithKey2 = new HashMap<>();

    public CaesarCipherTwo(int key1, int key2) {
        setKey1(key1);
        setKey2(key2);
        setDecryptionKey1(26-key1);
        setDecryptionKey2(26-key2);
        setAlphabet();
        setShiftedWithKey1();
        setShiftedWithKey2();
        setText("");
    }

    public CaesarCipherTwo(int key1, int key2, String text) {
        setKey1(key1);
        setKey2(key2);
        setDecryptionKey1(26-key1);
        setDecryptionKey2(26-key2);
        setAlphabet();
        setShiftedWithKey1();
        setShiftedWithKey2();
        setText(encrypt(text));
    }

    public CaesarCipherTwo(String text) {
        setAlphabet();
        decrypt(text);
        setKey1(26-decryptionKey1);
        setKey2(26-decryptionKey2);
        setShiftedWithKey1();
        setShiftedWithKey2();
        setText(decrypt(text));
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

    public int getDecryptionKey1() {
        return decryptionKey1;
    }

    public void setDecryptionKey1(int decryptionKey1) {
        this.decryptionKey1 = decryptionKey1;
    }

    public int getDecryptionKey2() {
        return decryptionKey2;
    }

    public void setDecryptionKey2(int decryptionKey2) {
        this.decryptionKey2 = decryptionKey2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public HashMap<Integer, Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet() {
        for (int i = 1; i <= 26; i++) {
            char currentChar = (char) ('a' + i - 1);
            alphabet.put(i, currentChar);
        }
    }

    public HashMap<Character, Character> getShiftedWithKey1() {
        return shiftedWithKey1;
    }

    public void setShiftedWithKey1() {
        for (int i = 'a'; i <= 'z'; i++) {
            char currentMappedChar = (char) (i + key1) > 'z' ? (char) (i + key1 - 26) : (char) (i + key1);
            shiftedWithKey1.put((char) i, currentMappedChar);
        }
    }

    public HashMap<Character, Character> getShiftedWithKey2() {
        return shiftedWithKey2;
    }

    public void setShiftedWithKey2() {
        for (int i = 'a'; i <= 'z'; i++) {
            char currentMappedChar = (char) (i + key2) > 'z' ? (char) (i + key2 - 26) : (char) (i + key2);
            shiftedWithKey2.put((char) i, currentMappedChar);
        }
    }

    public String encrypt(String input) {
        System.out.println(shiftedWithKey1);
        System.out.println(shiftedWithKey2);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!Character.isLetter(currentChar)) {
                output.append(currentChar);
            } else {
                if (i % 2 == 0) {
                    Character charToLowercase = Character.toLowerCase(currentChar);
                    char mappedChar = shiftedWithKey1.get(charToLowercase);
                    output.append((Character.isUpperCase(currentChar)) ? Character.toUpperCase(mappedChar) : mappedChar);
                } else {
                    Character charToLowercase = Character.toLowerCase(currentChar);
                    char mappedChar = shiftedWithKey2.get(charToLowercase);
                    output.append((Character.isUpperCase(currentChar)) ? Character.toUpperCase(mappedChar) : mappedChar);
                }
            }
        }
        return new String(output);
    }

    public String decrypt(String input) {
        StringBuilder firsthalft = new StringBuilder();
        StringBuilder secondhalft = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                firsthalft.append(input.charAt(i));
            } else {
                secondhalft.append(input.charAt(i));
            }
        }
        CaesarCipher cc1 = new CaesarCipher(new String(firsthalft));
        CaesarCipher cc2 = new CaesarCipher(new String(secondhalft));

        setDecryptionKey1(cc1.getDecryptionKey());
        setDecryptionKey2(cc2.getDecryptionKey());
        StringBuilder output = new StringBuilder();
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                output.append(cc1.getText().charAt(index1));
                index1++;
            } else {
                output.append(cc2.getText().charAt(index2));
                index2++;
            }
        }
        return new String(output);
    }

}
