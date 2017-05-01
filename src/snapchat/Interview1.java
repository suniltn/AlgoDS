package snapchat;

/**
 * Created by stipturn on 3/21/17.
 */
public class Interview1 {


    static boolean isPowerofSeven(int n) {

        if( n == 1 ) return true;
        if( n <= 0 ) return false;

        if(n>1 && n <7) return false;


       return isPowerofSeven(n/7);


    }


    static boolean isPowerofSevenI(int n) {

        if(n <= 0) return false;

        while (n >= 1) {

            if( n == 1 ) return true;
            if(n>1 && n <7) return false;

            n = n/7;

        }

        return false;


    }





    public static void main(String[] args ) {

            //test
            System.out.println("0"+ isPowerofSeven(0));
            System.out.println("1"+ isPowerofSeven(1));
            System.out.println("7"+ isPowerofSeven(7));
            System.out.println("14"+ isPowerofSeven(14));
            System.out.println("49"+ isPowerofSeven(49));
            System.out.println("343"+ isPowerofSeven(343));

            System.out.println("343...."+ isPowerofSeven(343*343*343));
            System.out.println("340...."+ isPowerofSeven(343*343*340));

        System.out.println("Iterative ....343..."+ isPowerofSevenI(343*343*341));

        System.out.println("Iterative ....f..."+ isPowerofSevenI(0));
        System.out.println("Iterative ....t..."+ isPowerofSevenI(1));
        System.out.println("Iterative ....t..."+ isPowerofSevenI(7));
        System.out.println("Iterative ....f..."+ isPowerofSevenI(-23));
        System.out.println("Iterative ....t..."+ isPowerofSevenI(343*343*343));






    }
    }



