package keiser;

public class Solution {

    public static void main(String[] args) {
        Cypher caesar= new Cypher (19,"Hakuna Matata");



        System.out.println (caesar.getAlphabet ());
        System.out.println (caesar.getShiftedAlphabet ());
        System.out.println (caesar.getSecret ());
        System.out.println (caesar.getCypherString ());
        caesar.testCypher();
    }
}
