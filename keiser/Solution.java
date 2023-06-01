package keiser;

public class Solution {

    public static void main(String[] args) {
        Cypher caesar = new Cypher(15, "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!");
WorldLengths probe = new WorldLengths();

probe.testCountWordLengths();
       // System.out.println(caesar.getAlphabet());
       // System.out.println(caesar.getShiftedAlphabet());
       // System.out.println(caesar.getSecret());
       // System.out.println(caesar.getCypherString());
       // caesar.test2KeyEncryption(8, 21);
    }
}
