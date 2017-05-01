package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by stipturn on 2/15/17.
 */
class Solution {

    public static void main(String[] args) {


        List<Domino> dList = new ArrayList();

        dList.add(new Domino(1, 2));
        dList.add(new Domino(2, 1));
        dList.add(new Domino(4, 1));

        if( pairExists(dList, 3)) {
            System.out.println("found");

        }

    }

    public static boolean pairExists(List<Domino> dominoList, int n) {


        Set<Domino> set = new HashSet<Domino>();


        for (Domino domino : dominoList) {




            int rdiff = Math.abs(n - domino.rightDiff);

            int ldiff = Math.abs(n - domino.leftDiff);



            Domino dom = new Domino(ldiff, rdiff);

            if (set.contains(dom)) {


                return true;

            } else {

                set.add(domino);

            }

        }
        return false;
    }
        static class  Domino {

            int leftDiff;
            int rightDiff;

            public Domino(int n , int m) {
                this.leftDiff = n;
                this.leftDiff = m;
                System.out.println(""+n+""+""+m);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Domino domino = (Domino) o;

                if (leftDiff != domino.leftDiff) return false;
                return rightDiff == domino.rightDiff;
            }

            @Override
            public int hashCode() {
                int result = leftDiff;
                result = 31 * result + rightDiff;
                return result;
            }
        }



    }

