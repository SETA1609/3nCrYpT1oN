package keiser.storyteller;

import edu.duke.FileResource;

import java.util.*;


public class WordFrequencies {

    private HashSet<String> myWords;

    private HashMap<String,Integer> myFreqs;


    public WordFrequencies() {
        myWords=new HashSet<>();
        myFreqs = new HashMap<>();

    }

    public HashSet<String> getMyWords() {
        return myWords;
    }

    public void setMyWords(HashSet<String> myWords) {
        this.myWords = myWords;
    }

    public HashMap<String, Integer> getMyFreqs() {
        return myFreqs;
    }

    public void setMyFreqs(HashMap<String, Integer> myFreqs) {
        this.myFreqs = myFreqs;
    }

    public boolean isFirstNotLetter(String s){
        return !Character.isLetter(s.charAt(0));
    }
    public boolean isLastNotLetter(String s){
        return !Character.isLetter(s.charAt(s.length()-1));
    }
    public boolean needToReduce(String word) {
        if (!word.isEmpty()){
            return isFirstNotLetter(word) || isLastNotLetter(word);
        }
        return false;

    }
    /*
    * public String filterString(String input){
        String output=input;
        if (needToReduce(input)){
            if (isFirstNotLetter(input)){
                output=input.substring(1);
            }

            if (isLastNotLetter(input)){
                output=output.substring(0,input.length()-1);
            }

            output=filterString(output);

            return output;
         }
        return output;
    }
    * */

    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        ArrayList<String>words= new ArrayList<>();

        for (String word:fr.words()) {
            String currentWord=word.toLowerCase();//filterString(word.toLowerCase());
            words.add(currentWord);
        }

        for (String word:words) {
            String currentWord=word.toLowerCase();//filterString(word.toLowerCase());
            myWords.add(currentWord);
            if (myWords.contains(currentWord)){
                myFreqs.put(currentWord,1);
            }
        }

        for (String word:words) {
            String currentWord=word.toLowerCase();//filterString(word.toLowerCase());
            if (myWords.contains(currentWord)) {
                myFreqs.put(currentWord, myFreqs.get(currentWord)+1);
            }
        }
    }

    public String findIndexOfMax(){
        int tmp=0;
        String currentWord="";
        for (Map.Entry<String,Integer> entry: myFreqs.entrySet()) {
            if (entry.getValue()>tmp){
                tmp= entry.getValue();
                currentWord=entry.getKey();
            }
        }
        return currentWord;
    }

    public  void tester(){
        findUnique();

        for (String word:myWords) {
            System.out.println( word + " has a frequency of:  "+myFreqs.get(word));
        }

        System.out.println("The word with the most freq is: "+findIndexOfMax()+" with: "+myFreqs.get(findIndexOfMax()));
        System.out.println("Number of unique words: "+myWords.size());
    }
}
