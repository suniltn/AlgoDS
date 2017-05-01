package interview;

/**
 * Created by stipturn on 4/29/17.
 */

public class Attendance {
    public static boolean  checkRecord(String s) {
        if(s==null||s.length()==0) return false;
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        int absetCount =0;
        int lateCount =0;

        for(int i=0; i<=arr.length-1; i++) {
            if(absetCount>=3) return false;


            if(arr[i]=='A')
            {
                absetCount++;
                continue;

            }

            if(arr[i]=='L' && (i+1<= arr.length-1 && arr[i+1]=='L') && (i+2<= arr.length-1 && arr[i+2]=='L'))
                return false;


        }
        return true;
    }

    public static void main(String[] args ) {

        if(Attendance.checkRecord("PPALPPLL"))
            System.out.print("true");
        else
            System.out.print("flase");


    }


}
