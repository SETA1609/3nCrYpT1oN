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

        for (int i = 0; i <phrase.length() ; i++) {
            char currentChar=phrase.charAt(i);
            if (isVowel(currentChar)){
               phrase= phrase.replace(currentChar,ch);
            }
        }
        return phrase;
    }

    public String emphasize(String phrase, Character ch){

        char[] phraseArray= phrase.toCharArray();
        for (int i = 0; i <phraseArray.length ; i++) {
            char currentChar=Character.isUpperCase(ch)?Character.toUpperCase(phrase.charAt(i)):Character.toLowerCase(phrase.charAt(i));
            if (currentChar==ch){
                if (i%2==0){
                    phraseArray[i]='*';
                } else {
                    phraseArray[i]='+';
                }
            }
        }
        return new String(phraseArray);
    }

}
