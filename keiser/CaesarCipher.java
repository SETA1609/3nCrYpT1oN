package keiser;

import java.util.*;

public class CaesarCipher {
    private int key;
    private int masterKey;
    private HashMap<Integer, Character> alphabet = new HashMap<>();
    private HashMap<Character, Character> shifted = new HashMap<>();

    public CaesarCipher(int key) {
        setKey(key);
        setAlphabet();
        setShifted();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(int masterKey) {
        this.masterKey = masterKey;
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

    public HashMap<Character, Character> getShifted() {
        return shifted;
    }

    public void setShifted() {
        for (int i = 'a'; i <= 'z'; i++) {
            char currentMappedChar = (char) (i + key) > 'z' ? (char) (i + key - 26) : (char) (i + key);
            shifted.put((char) i, currentMappedChar);
        }
    }

    public String encrypt(String input) {
        StringBuilder output = new StringBuilder();
        for (char letter : input.toCharArray()) {
            if (Character.isLetter(letter)) {
                Character charToLowercase = Character.toLowerCase(letter);
                char mappedChar = shifted.get(charToLowercase);
                output.append(Character.isUpperCase(letter) ? Character.toUpperCase(mappedChar) : mappedChar);
            } else {
                output.append(letter);
            }
        }
        return new String(output);
    }

    public int countCommonWords(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        String[] inputWordArray = cleanedInput.split(" ");
        int counter = 0;
        HashSet<String> commonWords = new HashSet<String>(List.of(new String[]{"the", "a", "i", "of", "and", "to", "in", "for", "is", "on", "that", "by", "this", "with", "you", "it", "not", "or", "be", "are"}));
        for (String inputWord : inputWordArray) {
            if (commonWords.contains(inputWord.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }

    public int countLetterFreq(String input) {
        int counter = 0;
        HashSet<Character> commonCharacters = new HashSet<>();
        commonCharacters.add('e');
        commonCharacters.add('t');
        commonCharacters.add('a');
        commonCharacters.add('o');
        commonCharacters.add('i');
        for (Character letter : input.toCharArray()) {
            if (commonCharacters.contains(letter)) {
                counter++;
            }
        }
        return counter;
    }

    public HashMap<Integer, Integer> countIndexForOneKey(String[] bruteForceStrings) {
        HashMap<Integer, Integer> countIndexForOneKey = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int count = countCommonWords(bruteForceStrings[i]) + countLetterFreq(bruteForceStrings[i]);
            countIndexForOneKey.put(i + 1, count);
        }

        return countIndexForOneKey;
    }

    public String[] decodedStringsForOneKey(String input) {
        String[] decodedStrings = new String[26];

        for (int i = 0; i < 26; i++) {
            Cypher c = new Cypher(i + 1, input);
            decodedStrings[i] = c.getOutput();
        }

        return decodedStrings;
    }

    public int getKeyByValue(Map<Integer, Integer> map, int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public String decrypt(String input) {
        int mainKey;
        String[] decodedStrings = decodedStringsForOneKey(input);
        HashMap<Integer, Integer> countIndex = countIndexForOneKey(decodedStrings);
        WorldLengths wl = new WorldLengths();
        int biggestIndex = wl.biggestIndex(countIndex);
        mainKey = getKeyByValue(countIndex, biggestIndex);
        setMasterKey(mainKey);
        CaesarCipher cc = new CaesarCipher(mainKey);
        return cc.encrypt(input);
    }


}
