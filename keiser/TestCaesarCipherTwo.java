package keiser;

import edu.duke.FileResource;

public class TestCaesarCipherTwo {
    public void simpleTests(){
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
        FileResource fr= new FileResource();
        String input = fr.asString();
        String encryptedString= cc.encrypt(input);
        cc.decrypt(encryptedString);
        int key1=cc.getMasterKey1();
        int key2=cc.getMasterKey2();
        String decryptedString= cc.decrypt(encryptedString);
        System.out.println("Encrypted String: "+encryptedString);
        System.out.println("Decrypted String: "+decryptedString);
        System.out.println("Key1: "+key1);
        System.out.println("Key2:"+ key2);

    }
}
