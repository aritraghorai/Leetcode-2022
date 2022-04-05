package HashMap;

import java.util.*;

/*
 !Name: Aritra Ghorai
 !Date:03/04/2022
 ?Program Details:5302. Encrypt and Decrypt Strings
 *https://leetcode.com/contest/weekly-contest-287/problems/encrypt-and-decrypt-strings/
 *https://leetcode.com/problems/encrypt-and-decrypt-strings/
   */
public class Q9_Encrypt_And_Decrypt_String {

}

class Encrypter {
    HashMap<Character, String> enc;
    HashMap<String, Integer> encriptVsCount;
    String[] values;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.values = values;
        for (int i = 0; i < keys.length; i++) {
            enc.put(keys[i], values[i]);
        }
        encriptVsCount = new HashMap<>();
        enc = new HashMap<>();
        for (String s : dictionary) {
            String en = encrypt(s);
            if (en != null)
                encriptVsCount.put(en, encriptVsCount.getOrDefault(en, 0) + 1);
        }

    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char c : word1.toCharArray()) {
            if (enc.containsKey(c))
                sb.append(enc.get(c));
            else
                return null;
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return encriptVsCount.getOrDefault(word2, 0);
    }

}
