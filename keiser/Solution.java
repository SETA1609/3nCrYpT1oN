package keiser;

import edu.duke.FileResource;

public class Solution {

    public static void main(String[] args) {
        Cypher c = new Cypher(17, "Hi I am Carl");
        System.out.println(c.getOutput());
        System.out.println(c.getShiftedWithKey1());
        Cypher c2 = new Cypher(23, 17, "First Legion");
        System.out.println(c2.getOutput());
        Cypher c3 = new Cypher(9, "Yz Z rd Tric");
        System.out.println(c3.getOutput());
        WordPlay w = new WordPlay();

        System.out.println(w.emphasize("Mary Bella Abracadabra", 'a'));
        //M+ry Bell+ +br*c*d*br+

        CaesarBreaker cb = new CaesarBreaker();
        System.out.println(cb.decryptOneKey("Yz Z rd Tric"));
        System.out.println(cb.decryptTwoKeys("Czojq Ivdzle"));

    }
}
