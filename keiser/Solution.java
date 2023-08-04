package keiser;

import edu.duke.FileResource;

public class Solution {

    public static void main(String[] args) {
       
        WordPlay w = new WordPlay();

        System.out.println(w.emphasize("Mary Bella Abracadabra", 'a'));
        //M+ry Bell+ +br*c*d*br+
       // FileResource fr = new FileResource();
       // String input = fr.asString();



        // WorldLengths wl =new WorldLengths();
        //  wl.testCountWordLengths();

        CaesarCipher cc = new CaesarCipher(17);
        System.out.println(cc.encrypt("Hi I am Carl"));
        System.out.println(cc.decrypt("Yz Z rd Tric"));

        TestCaesarCipher t = new TestCaesarCipher();
        TestCaesarCipherTwo t2= new TestCaesarCipherTwo();
     // t.simpleTests();
      //  t2.simpleTests();
        CaesarCipherTwo cc2 = new CaesarCipherTwo(12,2,"Hfs cpwewloj loks cd Hoto kyg Cyy.");
        //CaesarCipherTwo cc2 = new CaesarCipherTwo(input);
        //Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!
        System.out.println(cc2.getText());
        System.out.println("decryptkey1: "+cc2.getDecryptionKey1()+" for key1: "+cc2.getKey1());
        System.out.println("decryptkey2: "+cc2.getDecryptionKey2()+" for key2: "+cc2.getKey2());
    }
}
