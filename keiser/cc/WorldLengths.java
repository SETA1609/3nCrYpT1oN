package keiser.cc;

import edu.duke.FileResource;

import java.util.HashMap;

public class WorldLengths {
    public boolean needToReduce(String word) {
        return !Character.isLetter(word.charAt(0)) || !Character.isLetter(word.charAt(word.length()-1));
    }

    public int biggestIndex(int[] counts) {
        int index = 0;
        int currentIndex = 0;
        for (int i : counts) {
            currentIndex = i;
            if (currentIndex > index) {
                index = currentIndex;
            }
        }
        return index;
    }

    public int biggestIndex(HashMap<Integer,Integer> counts) {
        int index = 0;
        int currentIndex = 0;
        for (int i = 1; i < counts.size(); i++) {
            currentIndex = counts.getOrDefault(i, 0);
            if (currentIndex > index) {
                index = currentIndex;
            }
        }
        return index;
    }

    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            int wordLength = word.length();
            if (needToReduce(word)) {
                wordLength--;
            }
            if (wordLength >= 30) {
                counts[30]++;
            } else {
                counts[wordLength]++;
            }

        }
        biggestIndex(counts);
    }

    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                System.out.println(counts[i]+" with a length of "+ i);
            }

        }
        System.out.println("There are more words from a length of "+ biggestIndex(counts));
    }
}
