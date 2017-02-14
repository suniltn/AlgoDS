/**
 * Created by stipturn on 2/7/17.
 */

package string;

public class StrStr {

public static void main (String[] args) {

    String str = "abcd";
    String pat = "cd";
   System.out.println(solution( str,  pat));
}

    private static String solution(String str, String pat) {

        int i = 0;

        while (i < str.length()) {
            int m = i;

            System.out.println("m"+m);
            for (int j = 0; j < pat.length(); j++) {


                if (str.charAt(m) != pat.charAt(j)) {
                    break;
                }
                if (j == pat.length() - 1) {
                    return "fooung at loc" + m;

                }
                if(m == str.length()-1) {return  "Not Found";}


                m++;
            }

                i++;
        }
        return "Not fooung at loc";


    }
}
