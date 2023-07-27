package keiser;

import java.util.HashMap;

public class Cypher {
    private int key1=0;
    private int key2=0;
    private String input = "";
    private HashMap<Integer, Character> alphabet = new HashMap<>();
    private HashMap<Character, Character> shiftedWithKey1 = new HashMap<>();
    private HashMap<Character, Character> shiftedWithKey2 = new HashMap<>();
    private StringBuilder output=new StringBuilder();

    public Cypher(int key1, String input) {
        reset();
        setKey1(key1);
        setInput(input);
        setAlphabet();
        setShiftedWithKey1();
        setOutput();
    }

    public Cypher(int key1, int key2, String input) {
        reset();
        setKey1(key1);
        setKey2(key2);
        setInput(input);
        setAlphabet();
        setShiftedWithKey1();
        setShiftedWithKey2();
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
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
        for (int i = 'a'; i <='z' ; i++) {
            char currentMappedChar =(char) (i+key1)>'z'?(char) (i+key1-26) :(char) (i+key1);
            alphabet.put(i, currentMappedChar);
        }
    }

    public HashMap<Character, Character> getShiftedWithKey2() {
        return shiftedWithKey2;
    }

    public void setShiftedWithKey2() {
        for (int i = 'a'; i <='z' ; i++) {
            char currentMappedChar =(char) (i+key2)>'z'?(char) (i+key2-26) :(char) (i+key2);
            alphabet.put(i, currentMappedChar);
        }
    }

    public String getOutput() {
        return output.toString();
    }

    public void setOutput() {
        if (key2==0){
            for (char letter: input.toCharArray()) {
                if (Character.isAlphabetic(letter)){
                    output.append(shiftedWithKey1.get(letter));
                }else{
                    output.append(letter);
                }
            }
        }else{
            for (int i = 0; i <input.length() ; i++) {
                char currentChar = input.charAt(i);
                if (!Character.isAlphabetic(currentChar)){
                    output.append(currentChar);
                }else {
                    if (i%2==0){
                        char mappedChar=shiftedWithKey1.get(currentChar);
                        output.append((Character.isUpperCase(currentChar))?Character.toUpperCase(mappedChar):mappedChar);
                    }else{
                        char mappedChar=shiftedWithKey2.get(currentChar);
                        output.append((Character.isUpperCase(currentChar))?Character.toUpperCase(mappedChar):mappedChar);
                    }
                }
            }
        }
    }



    public void reset(){
        setInput("");
        setKey1(0);
        setKey2(0);
        shiftedWithKey1.clear();
        shiftedWithKey2.clear();
        output.delete(0,output.length()-1);
    }
}
