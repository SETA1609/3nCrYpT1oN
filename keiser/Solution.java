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
        //FileResource fr = new FileResource();
        //String input = fr.asString();


        // System.out.println(cb.decryptTwoKeys(input));
        // WorldLengths wl =new WorldLengths();
        //  wl.testCountWordLengths();
        Cypher c4 = new Cypher(24, 6, "Top ncmy qkff vi vguv vbg ycpx");
        System.out.println(c4.getOutput());
        CaesarCipher cc = new CaesarCipher(17);
        System.out.println(cc.encrypt("Hi I am Carl"));
        System.out.println(cc.decrypt("Yz Z rd Tric"));

        TestCaesarCipher t = new TestCaesarCipher();
        TestCaesarCipherTwo t2= new TestCaesarCipherTwo();
     // t.simpleTests();
        t2.simpleTests();

    }
}
