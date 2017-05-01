package string;

/**
 * Created by stipturn on 3/4/17.
 */
public class Fibonicaii {


    public static int fibL(int n) {

        int first = 0;
        int second = 1;
        int next = 0;

        for (int i = 2; i <= n; i++) {

            next = first + second;

            first = second;
            second = next;

        }

        return next;

    }


    public static void main(String[] args) {

        System.out.print(fibL(10));
        System.out.print(fibRec(10));
        System.out.print(fibDyn(10));


    }



    static int fibRec(int n) {
        if (n <= 1)
            return n;
        return fibRec(n-1) + fibRec(n-2);
    }


    static int fibDyn(int n) {

        int[] fib = new int[n+1];

        fib[0] = 0;
        fib[1] = 1;



        for (int i = 2 ; i<=n ; i ++) {

            fib[i] = fib[i-1]+fib[i-2];
        }

        return fib[n];
    }


    }