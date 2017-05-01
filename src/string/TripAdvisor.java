package string;

/**
 * Created by stipturn on 2/23/17.
 */
public class TripAdvisor {

    //String str = "RADAR";
    //String str2 = "Amor, Roma!";

    //palindrome , returns a boolean if palindrome

    public static void main(String[] args) {


        if(isPalindrome("Amor, Roma!"))
        System.out.print("YES");
        else
            System.out.print("NO");

    }


    public static  boolean isPalindrome(String str) {
        //amorroma
        //amorroma //alpahnumeruic ..

        if (str == null || str.length()==0) return false;

        if(str.length()==1) return true;
        int start = 0 , end = str.length()-1;

        while (start < end ) {

          while (!Character.isLetterOrDigit(str.charAt(start))) start++;
          while(!Character.isLetterOrDigit(str.charAt(end))) end--;

          if(Character.toLowerCase(str.charAt(start)) == Character.toLowerCase(str.charAt(end))) {

              System.out.print(str.charAt(start)+"----"+str.charAt(end));

              start ++; end --;


          }else {

              return false;

          }



        }

        return true;
    }

}
