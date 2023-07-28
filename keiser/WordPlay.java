package keiser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordPlay {

    public boolean isVowel(char ch) {
        boolean isVowel = false;
        Character[] vowelArray = {'a', 'e', 'i', 'o', 'u'};
        List<Character> vowels = new ArrayList<Character>(Arrays.asList(vowelArray));

        if (vowels.contains(Character.toLowerCase(ch))) {
            isVowel = true;
        }

        return isVowel;
    }


    public String replaceVowels(String phrase, Character ch) {
        return phrase;

    }

}
