package keiser.cc;

import edu.duke.FileResource;
import keiser.cc.CaesarCipherTwo;

public class TestCaesarCipherTwo {
    public void simpleTests(){

        FileResource fr= new FileResource();
        String input = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(21,8,input);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(cc.getText());

        int key1=cc2.getDecryptionKey1();
        int key2=cc2.getDecryptionKey2();

        System.out.println("Encrypted String: "+ cc.getText());
        System.out.println("Decrypted String: "+ cc2.getText());
        System.out.println("Decryption key1: "+ key1+" for key 1: "+cc.getKey1());
        System.out.println("Decryption key2: "+ key2+" for key 2: "+cc.getKey2());

    }
}
