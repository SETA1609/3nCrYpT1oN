package keiser;

import java.util.*;

public class CaesarBreaker {

    private String input;
    private StringBuilder output = new StringBuilder();
    private String[] commonWords;
    private List<String> commons = new ArrayList<>();
    private int key1;
    private int key2;
    private int[] countIndexForOneKey = new int[26];
    private int[][] countIndexForTwoKeys = new int[26][26];

    public CaesarBreaker() {
        setInput("");
        setKey1(0);
        setKey2(0);
        setCommonWords();
        setCommons();
        setOutput("");
    }

    public CaesarBreaker(String input) {
        setInput(input);
        setCommonWords();
        setCommons();
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

    public String[] getCommonWords() {
        return commonWords;
    }

    public void setCommonWords() {
        commonWords = new String[]{"the", "of", "and", "to", "a", "in", "for", "is", "on", "that", "by", "this", "with", "I", "you", "it", "not", "or", "be", "are"};
    }

    public List<String> getCommons() {
        return commons;
    }

    public void setCommons() {
        commons = new ArrayList<>(List.of(commonWords));
    }

    public int[] getCountIndexForOneKey() {
        return countIndexForOneKey;
    }

    public void setCountIndexForOneKey() {
        this.countIndexForOneKey = countIndexForOneKey;
    }

    public int[][] getCountIndexForTwoKeys() {
        return countIndexForTwoKeys;
    }

    public void setCountIndexForTwoKeys() {
        this.countIndexForTwoKeys = countIndexForTwoKeys;
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

    public int countCommonWords(String input){
        String[] words=input.split(" ");
        List<String> wordList=new ArrayList<String>(List.of(words));
        int counter=0;
        for (String word:commons) {
            for (String inputWord:words) {
                if (word.equalsIgnoreCase(inputWord)){
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean decryptOneKey(){
        boolean isOneKey=true;

        for (int i = 0; i <26 ; i++) {

        }

        return isOneKey;
    }



}