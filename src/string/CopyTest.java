package string;

/**
 * Created by stipturn on 2/19/17.
 */

public class CopyTest {

    private static void swap1(StringBuilder arg1, StringBuilder arg2) {
        StringBuilder temp = arg2.append('A');
        arg2 = arg1;
        arg1 = temp;
    }

    private static void swap2(StringBuilder arg1, StringBuilder arg2) {
        String temp = arg2.toString();
        arg2.replace(0, arg2.length(), arg1.toString());
        arg1.replace(0, temp.length(), temp);
    }

    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("Hello");
        StringBuilder str2 = new StringBuilder("World");
        System.out.println("Before swap = " + str1 + " " + str2);

        swap1(str1, str2);
        System.out.println("After swap1 = " + str1 + " " + str2);

        swap2(str1, str2);
        System.out.println("After swap2 = " + str1 + " " + str2);
    }
}