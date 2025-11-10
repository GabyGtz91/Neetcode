package arrays_hashing;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar";
        String t = "carrace";
        System.out.println("Resultado: " + isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        } else {
            HashMap<Character,Integer> hashS = new HashMap<>();
            HashMap<Character, Integer> hashT = new HashMap<>();
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                hashS.put(charS[i], hashS.getOrDefault(charS[i], 0) + 1);
                hashT.put(charT[i], hashT.getOrDefault(charT[i], 0) + 1);
            }

            if(hashS.equals(hashT)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
