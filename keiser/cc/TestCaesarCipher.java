package keiser.cc;

import edu.duke.FileResource;
import keiser.cc.CaesarCipher;

public class TestCaesarCipher {

    public void simpleTests(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        CaesarCipher cc = new CaesarCipher(15,input);
        CaesarCipher ccDecryption = new CaesarCipher(cc.getText());
        int key = ccDecryption.getDecryptionKey();
        System.out.println("Encrypted: "+cc.getText());
        System.out.println("decrypted: "+ccDecryption.getText());
        System.out.println("Key for decryption: "+key);
    }



}
