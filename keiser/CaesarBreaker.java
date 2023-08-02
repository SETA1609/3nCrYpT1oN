package keiser;

import java.util.*;

public class CaesarBreaker {

    private String input;
    private StringBuilder output = new StringBuilder();
    private HashSet<String> commonWords;
    private int key1;
    private int key2;

    public CaesarBreaker() {
        setInput("");
        setKey1(0);
        setKey2(0);
        setCommonWords();
        setOutput("");
    }

    public CaesarBreaker(String input) {
        setInput(input);
        setCommonWords();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = new StringBuilder(output);
    }

    public HashSet<String> getCommonWords() {
        return commonWords;
    }

    public void setCommonWords() {
        commonWords = new HashSet<String>(List.of(new String[]{"the", "a", "i", "of", "and", "to", "in", "for", "is", "on", "that", "by", "this", "with", "you", "it", "not", "or", "be", "are"}));
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

    public int countCommonWords(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
        String[] inputWordArray = cleanedInput.split(" ");
        int counter = 0;

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
        System.out.println(countIndexForOneKey);
        return countIndexForOneKey;
    }

    public String[] decodedStringsForOneKey(String input) {
        String[] decodedStrings = new String[26];

        for (int i = 0; i < 26; i++) {
            Cypher c = new Cypher(i + 1, input);
            decodedStrings[i] = c.getOutput();
        }
        System.out.println(Arrays.toString(decodedStrings));
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

    public String decryptOneKey(String input) {
        String[] decodedStrings = decodedStringsForOneKey(input);
        HashMap<Integer, Integer> countIndex = countIndexForOneKey(decodedStrings);
        WorldLengths wl = new WorldLengths();
        int biggestIndex = wl.biggestIndex(countIndex);
        setKey1(getKeyByValue(countIndex, biggestIndex));
        System.out.println(key1);
        Cypher c = new Cypher(getKey1(), input);
        setOutput(c.getOutput());
        return new String(getOutput());
    }

    public String[][] decodedStringsForTwoKeys(String input) {
        String[][] decodedStrings = new String[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                Cypher c = new Cypher((i + 1), (j + 1), input);
                decodedStrings[i][j] = c.getOutput();
            }
        }

        return decodedStrings;
    }

    public HashMap<Integer, Integer> countIndexForTwoKeys(String[][] bruteForceStrings) {
        HashMap<Integer, Integer> countIndexForTwoKeys = new HashMap<>();
        int sum;
        for (int i = 0; i < 26; i++) {
            HashMap<Integer, Integer> count1 = countIndexForOneKey(bruteForceStrings[i]);
            sum = 0;
            sum = totalSum(count1);
            System.out.println(sum);
            // Sum the frequencies for the current first key
            for (int j = 0; j < 26; j++) {
                int count = sum + countCommonWords(bruteForceStrings[i][j]) + countLetterFreq(bruteForceStrings[i][j]);
               // System.out.println(count);
                countIndexForTwoKeys.put(i * 26 + (j + 1), count);
            }
        }
        System.out.println(countIndexForTwoKeys);
        return countIndexForTwoKeys;
    }


    private Integer totalSum(HashMap<Integer, Integer> count1) {
        int tmp = 0;

        for (Map.Entry<Integer, Integer> entry : count1.entrySet()) {
            tmp += entry.getValue();
        }

        return tmp;
    }

    public String decryptTwoKeys(String input) {
        StringBuilder firsthalft= new StringBuilder();
        StringBuilder secondhalft= new StringBuilder();

        for (int i = 0; i <input.length() ; i++) {
            if (i%2==0){
                firsthalft.append(input.charAt(i));
            }else{
                secondhalft.append(input.charAt(i));
            }
        }

        String decoded1=decryptOneKey(new String(firsthalft));
        String decoded2=decryptOneKey(new String(secondhalft));
        System.out.println("1: "+decoded1+" 2: "+decoded2);
        setOutput("");
        int index1=0;
        int index2=0;

        for (int i = 0; i <input.length() ; i++) {
            if (i%2==0){
                output.append(decoded1.charAt(index1));
                index1++;
            }else {
                output.append(decoded2.charAt(index2));
                index2++;
            }
        }

        return new String(getOutput());
    }


}