package Design_DS;

import java.util.HashMap;

/*
 !Name: Aritra Ghorai
 !Date:23/04/2022
 ?Program Details:535. Encode and Decode TinyURL
 *https://leetcode.com/problems/encode-and-decode-tinyurl/ 
   */
public class Q4_Encode_And_Decode_Tiny_Url {

}

class Codec {

    private int num = 0;
    HashMap<String, String> map = new HashMap<>();

    private static final String addOnUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String ans = addOnUrl + "" + num;
        num++;
        map.put(ans, longUrl);
        return ans;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
