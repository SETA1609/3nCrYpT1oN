package keiser;

import java.util.HashMap;

public class CaesarBreaker {

    private String input;
    private HashMap<Character, Character> decrypt1;
    private HashMap<Character, Character> decrypt2;
    private String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public HashMap<Character, Character> getDecrypt1() {
        return decrypt1;
    }

    public void setDecrypt1(int key) {
        decrypt1 = new HashMap<>();
        int offset = key;
        for (char a = 'a'; a <= 'z'; a++) {
            char currentChar = (char) (a + offset);
            if (currentChar < 122) {
                decrypt1.put(a, currentChar);
            }

            if (currentChar > 122) {
                currentChar = (char) (currentChar - 26);
                decrypt1.put(a, currentChar);
            }
        }
    }

    public HashMap<Character, Character> getDecrypt2() {
        return decrypt2;
    }

    public void setDecrypt2(int key) {
        decrypt2 = new HashMap<>();
        int offset = key;
        for (char a = 'a'; a <= 'z'; a++) {
            char currentChar = (char) (a + offset);
            if (currentChar < 122) {
                decrypt2.put(a, currentChar);
            }

            if (currentChar > 122) {
                currentChar = (char) (currentChar - 26);
                decrypt2.put(a, currentChar);
            }
        }
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            boolean isLetter = Character.isLetter(currentChar);
            if (isLetter) {
                boolean isUppercase = Character.isUpperCase(currentChar);
                if (isUppercase) {
                    char newChar = (i % 2 == 0) ? (char) (decrypt1.get(Character.toLowerCase(currentChar)) - 32)
                            : (char) (decrypt2.get(Character.toLowerCase(currentChar)) - 32);
                    sb.append(newChar);
                } else {
                    char newChar = (i % 2 == 0) ? decrypt1.get(currentChar) : decrypt2.get(currentChar);
                    sb.append(newChar);
                }
            } else {
                sb.append(currentChar);
            }
        }
        output = sb.toString();
    }

    public int[] countLetters(String input) {
        int[] counts = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char currentChar = Character.toLowerCase(input.charAt(i));
            if (Character.isLetter(currentChar)) {
                counts[currentChar - 'a']++;
            }
        }
        return counts;
    }

    public int biggestIndex(int[] counts) {
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[index]) {
                index = i;
            }
        }
        return index;
    }

    public String decrypt(String encrypted, int key) {
        Cypher cc = new Cypher(26 - key, encrypted);
        return cc.getOutput();
    }

    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = biggestIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex < 4) {
            dKey = 26 - (4 - maxDex);
        }
        return dKey;
    }

    public String decryptTwoKeys(String encrypted) {
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);

        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);

        System.out.println("Key1 is " + key1 + ", Key2 is " + key2);

        Cypher cc = new Cypher(key1, key2, encrypted);
        String output = cc.getOutput();
        return output;
    }

}
