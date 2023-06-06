package keiser;

import edu.duke.FileResource;

public class Solution {

    public static void main(String[] args) {
        // Cypher caesar = new Cypher(15, "At noon be in the conference room with your
        Cypher c = new Cypher();
        // hat on for a surprise party. YELL LOUD!");
        // WorldLengths probe = new WorldLengths();
        CaesarBreaker cB = new CaesarBreaker();
        FileResource fr = new FileResource();
        // cB.testDecrypt();
        c.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 16, 3);
        cB.decryptTwoKeys(fr.asString());
       // System.out.println(c.getCypherString());
        // probe.testCountWordLengths();
        // caesar.bruteForceDecrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc
        // udg p hjgegxht epgin. NTAA ADJS!");
        // System.out.println(caesar.getAlphabet());
        // System.out.println(caesar.getShiftedAlphabet());
        System.out.println(c.getSecret());
        System.out.println(c.getCypherString());
        // caesar.test2KeyEncryption(8, 21);
    }
}
