package keiser;

import java.util.HashMap;

public class Cypher {
    int key1=0;
    int key2=0;
    HashMap<Integer,Character> alpha;
    HashMap<Character,Character> encrypt1;
    HashMap<Character,Character> encrypt2;
    HashMap<Character,Character> decrypt1;
    HashMap<Character,Character> decrypt2;
    String input;
    String output;

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
        alpha= new HashMap<>();
        int i =1;
        for (char a='a'; a <='z' ; a++) {
            alpha.put(i,a);
            i++;
        }
    }

    public HashMap<Character, Character> getEncrypt1() {
        return encrypt1;
    }

    public void setEncrypt1() {
        encrypt1=new HashMap<>();
        int offset = key1;
        int i=1;
        for (char a='a'; a <='z' ; a++) {
            char currentChar= (char) (a+offset);
            if (currentChar<122){
                encrypt1.put(a,currentChar);
            }

            if (currentChar>122){
                currentChar= (char)(currentChar-122+97);
                encrypt1.put(a,currentChar);
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
        int i=1;
        for (char a='a'; a <='z' ; a++) {
            char currentChar= (char) (a+offset);
            if (currentChar<122){
                encrypt2.put(a,currentChar);
            }

            if (currentChar>122){
                currentChar= (char)(currentChar-122+97);
                encrypt2.put(a,currentChar);
            }

            i++;
        }
    }

    public HashMap<Character, Character> getDecrypt1() {
        return decrypt1;
    }

    public void setDecrypt1(int key) {
        decrypt1= new HashMap<>();
        int offset = key;
        int i=1;
        for (char a='a'; a <='z' ; a++) {
            char currentChar= (char) (a+offset);
            if (currentChar<122){
                decrypt1.put(a,currentChar);
            }

            if (currentChar>122){
                currentChar= (char)(currentChar-122+97);
                decrypt1.put(a,currentChar);
            }

            i++;
        }
    }

    public HashMap<Character, Character> getDecrypt2() {
        return decrypt2;
    }

    public void setDecrypt2(int key) {
        decrypt2= new HashMap<>();
        int offset = key;
        int i=1;
        for (char a='a'; a <='z' ; a++) {
            char currentChar= (char) (a+offset);
            if (currentChar<122){
                decrypt2.put(a,currentChar);
            }

            if (currentChar>122){
                currentChar= (char)(currentChar-122+97);
                decrypt2.put(a,currentChar);
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
        if (key1!=0&&key2==0){
            for (char c:input.toCharArray()) {
                boolean isLetter= Character.isLetter(c);
                if (isLetter){
                    boolean isUppercase = !alpha.containsValue(c);
                    char newChar= isUppercase? (char)(encrypt1.get(c)-90):encrypt1.get(c);
                    output = input.replace(c,newChar);
                }

            }
        }
    }
}
