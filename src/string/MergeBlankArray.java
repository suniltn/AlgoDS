package string;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by stipturn on 3/2/17.
 */
public class MergeBlankArray {



    public static void main(String[] args) {

        merge(new int[]{1,3 },new int[]{2,4,0,0} );
    }




        public static void merge (int[] arr1, int[] arr2) {

            if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) ;


            //arr1 smaller and arr2 is bigger
            // ArrayUtils.reverse(arr1);
            //Collections.reverse(Arrays.asList(arr1));

            int i = arr1.length - 1;
            int j = arr1.length - 1;
            int k = arr2.length - 1;

            while (k >= 0 ) {

                if(i >= 0 && j>=0 && arr1[i]>arr2[j]  ) {

                    arr2[k] = arr1[i];
                    k--;i--;

                }else {
                    if(j>=0) {
                        arr2[k] = arr2[j];
                        k--; j--; //if(j==-1) { arr2[k] =arr1[i]; break; }

                    }
                } if (k==0) break;


            }




            for (int p = 0 ; p <arr2.length; p++) {

                System.out.print(arr2[p]);
            }
        }



}
