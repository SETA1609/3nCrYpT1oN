package keiser;

import java.util.HashMap;

public class CaesarCipherTwo {

    private int key1;
    private int key2;
    private int masterKey1;
    private int masterKey2;
    private HashMap<Integer, Character> alphabet=new HashMap<>();
    private HashMap<Character, Character> shiftedWithKey1 = new HashMap<>();
    private HashMap<Character, Character> shiftedWithKey2 = new HashMap<>();

    public CaesarCipherTwo(int key1, int key2) {
        setKey1(key1);
        setKey2(key2);
        setMasterKey1(0);
        setMasterKey2(0);
        setAlphabet();
        setShiftedWithKey1();
        setShiftedWithKey2();
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

    public int getMasterKey1() {
        return masterKey1;
    }

    public void setMasterKey1(int masterKey1) {
        this.masterKey1 = masterKey1;
    }

    public int getMasterKey2() {
        return masterKey2;
    }

    public void setMasterKey2(int masterKey2) {
        this.masterKey2 = masterKey2;
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
        CaesarCipher cc1 = new CaesarCipher(key1);
        CaesarCipher cc2 = new CaesarCipher(key2);
        cc1.decrypt(new String(firsthalft));
        cc2.decrypt(new String(secondhalft));
        String decrypted1 = cc1.decrypt(new String(firsthalft));
        String decrypted2 = cc2.decrypt(new String(secondhalft));
        setMasterKey1(cc1.getMasterKey());
        setMasterKey2(cc2.getMasterKey());
        StringBuilder output = new StringBuilder();
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                output.append(decrypted1.charAt(index1));
                index1++;
            } else {
                output.append(decrypted2.charAt(index2));
                index2++;
            }
        }
        return new String(output);
    }

}
