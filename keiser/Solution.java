package keiser;

import edu.duke.FileResource;

public class Solution {

    public static void main(String[] args) {
        Cypher c = new Cypher(17,"First Legion");
        System.out.println(c.getOutput());
        System.out.println(c.getShiftedWithKey1());
        Cypher c2 = new Cypher(23, 17,"First Legion");
        System.out.println(c2.getOutput());

        WordPlay w = new WordPlay();

        System.out.println(w.emphasize("Mary Bella Abracadabra", 'a'));
        //M+ry Bell+ +br*c*d*br+
    }
}
