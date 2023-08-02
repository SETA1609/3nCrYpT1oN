package keiser;

import edu.duke.FileResource;

public class TestCaesarCipher {

    public void simpleTests(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        CaesarCipher cc = new CaesarCipher(18);
        String encryptedInput=cc.encrypt(input);
        cc.decrypt(encryptedInput);
        int key = cc.getMasterKey();
        System.out.println("Encrypted: "+encryptedInput);
        System.out.println("decrypted: "+cc.decrypt(encryptedInput));
        System.out.println("Key for decryption: "+key);
    }



}
