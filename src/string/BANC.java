package string;

import java.util.HashMap;

/**
 * Created by stipturn on 2/24/17.
 */
public class BANC {
  //  S = "ADOBECODEBANC", T = "ABC",
    public static String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int counter = t.length();
        int end = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        String ret = "";

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), 0);
        }
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!map.containsKey(curr)) {
                return "";
            }
            else {
                map.put(curr, map.get(curr) + 1);
            }
        }

        while (end < s.length()) {
            char curr = s.charAt(end);
            if (map.get(curr) > 0) {
                counter--;
            }
            map.put(curr, map.get(curr) - 1);

            while (counter == 0) { // window is finished, then we need to check whether we can narrowize this window
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    ret = s.substring(start, end + 1);
                }
                char leftMost = s.charAt(start);
                map.put(leftMost, map.get(leftMost) + 1);
                if (map.get(leftMost) > 0) {
                    counter++;
                }
                start++;
            }

            end++;
        }

        return ret;
    }

    public static void main(String[] args) {

       System.out.println( minWindow("ADOBECODEBANC","ABC"));

    }



    }

