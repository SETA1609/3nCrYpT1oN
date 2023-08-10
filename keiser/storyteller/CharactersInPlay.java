package keiser.storyteller;

import edu.duke.FileResource;

import java.util.*;

public class CharactersInPlay {
private HashSet<String> characters;
private HashMap<String,Integer> countsOfCharacters;
private ArrayList<Integer> couters;

    public CharactersInPlay() {
        characters=new HashSet<>();
        countsOfCharacters=new HashMap<>();
        couters=new ArrayList<>();
    }

    public void update(String character){
        if (!character.isEmpty()){
            if (characters.contains(character)){
                int currentCount= countsOfCharacters.get(character);
                countsOfCharacters.put(character,currentCount+1);
            }else {
                characters.add(character);
                countsOfCharacters.put(character,1);
            }
        }

    }
    public boolean isFirstNotLetter(String s){
        return !Character.isLetter(s.charAt(0));
    }
    public String filteringWord(String s){
        String output=s;
        if (s.length()!=0){
            if (isFirstNotLetter(s)){
                output=s.substring(1);
                output=filteringWord(output);
            }
        }


        return output;
    }
    public boolean isUppercase(String s){

        for (Character ch:s.toCharArray()) {
            if (Character.isLowerCase(ch)){
                return false;
            }
        }

        return true;
    }
    public void findAllCharacters(){
        couters.clear();
        countsOfCharacters.clear();
        characters.clear();
        FileResource fr = new FileResource();
        for (String line: fr.lines()) {
            String[] words=line.split("\\.");
            for (String word:words) {
                String currentWord= filteringWord(word);
                if (currentWord.length()<=12&&!word.contains(",")&&isUppercase(currentWord)){
                    update(currentWord);
                }
            }
        }

        for (Map.Entry<String,Integer> entry:countsOfCharacters.entrySet()) {
            couters.add(entry.getValue());
        }
    }

    public int getMean(){
        int tmp=0;
        int counter=0;
        for (Map.Entry<String,Integer> entry:countsOfCharacters.entrySet()) {
            tmp=tmp+ entry.getValue();
            counter++;
        }
        tmp=Math.round((float) tmp /counter);
        return tmp;
    }

    public void charactersWithNumParts(int min,int max){
        for (Map.Entry<String,Integer> entry:countsOfCharacters.entrySet()) {
            int tmp = entry.getValue();
            if (min<tmp&&tmp<max){
                System.out.println("Character name: "+entry.getKey()+" is between the limit");
            }
        }
    }

    public void tester(){
        findAllCharacters();
        for (Map.Entry<String,Integer> entry:countsOfCharacters.entrySet()) {
            if (entry.getValue()>getMean()){
                System.out.println(entry.getKey()+" has: "+entry.getValue()+" number of parts");

            }

        }
       charactersWithNumParts(10,15);
    }
}
