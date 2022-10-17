package Two_Pointer;

/*
    !Name: Aritra Ghorai
    !Date:15/10/2022
    ?Program Details:443. String Compression
    *https://leetcode.com/problems/string-compression/description/
*/
public class Q4_String_compression {
  public int compress(char[] chars) {
    int n = chars.length;
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < n && j < n) {
      int count = 0;
      while (j < n && chars[i] == chars[j]) {
        j++;
        count++;
      }
      chars[k++] = chars[i];
      if (count > 1) {
        String temp = new String(count + "");
        for (int m = 0; m < temp.length(); m++) {
          chars[k++] = temp.charAt(m);
        }
      }
      i = j;
    }
    return k;
  }
}
