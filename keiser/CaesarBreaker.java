package keiser;

import edu.duke.FileResource;

public class CaesarBreaker {
    public int[] countLetters(String toDecrypt) {
        int[] letterCounter = new int[26];
        for (int i = 0; i < toDecrypt.length(); i++) {
            int currentChar = toDecrypt.charAt(i);
            boolean isUpperCase = currentChar >= 65 && currentChar <= 90;
            boolean isLowerCase = currentChar >= 97 && currentChar <= 122;
            if (isLowerCase) {
                letterCounter[currentChar - 97]++;
            }

            if (isUpperCase) {
                letterCounter[currentChar - 65]++;
            }
        }
        return letterCounter;
    }

    public int maxIndex(int[] counts) {
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[index] < counts[i]) {
                index = i;
            }
        }
        return index;
    }

    public int getKey(String toDecrypt) {
        int decryptKey = maxIndex(countLetters(toDecrypt));
        return decryptKey;
    }

    public void testDecrypt() {
        FileResource fr = new FileResource();
        int decryptKey = getKey(fr.asString());
        System.out.println("the key to decrypt the message is : " + decryptKey);
        Cypher c = new Cypher(decryptKey, fr.asString());
        System.out.println(c.getCypherString());
    }

    public String halfOfString(String input, int startIndex) {
        StringBuilder sb = new StringBuilder();
        String newInput = input.substring(startIndex);
        for (int i = 0; i < newInput.length(); i++) {
            if (i % 2 == 0) {
                sb.append(newInput.charAt(i));
            }
        }
        return sb.toString();
    }

    public void decryptTwoKeys() {

    }
}
