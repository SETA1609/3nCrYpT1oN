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

    public int decrypt1Key(String toDecrypt) {
        int decryptKey = maxIndex(countLetters(toDecrypt));
        return decryptKey;
    }

    public void testDecrypt() {
        FileResource fr = new FileResource();
        int decryptKey = decrypt1Key(fr.asString());
        System.out.println("the key to decrypt the message is : " + decryptKey);
        Cypher c = new Cypher(decryptKey, fr.asString());
        System.out.println(c.getCypherString());
    }

    public String halfOfString(String input, int startIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < input.length(); i += 2) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }


    public void decryptTwoKeys(String input) {
        String firstHalf = halfOfString(input, 0);
        String secondHalf = halfOfString(input, 1);
        int firstKey = decrypt1Key(firstHalf);
        int secondKey = decrypt1Key(secondHalf);
        Cypher c = new Cypher();
        c.encryptTwoKeys(input, (26-firstKey), (26-secondKey));

        System.out.println("First key: " + firstKey);
        System.out.println("Second key: " + secondKey);
        System.out.println(c.getCypherString().toString());
    }

}
