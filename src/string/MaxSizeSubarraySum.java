package string;

import java.util.HashMap;

/**
 * Created by stipturn on 3/1/17.
 */
public class MaxSizeSubarraySum {


    public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }


    ///  [2,3,1,2,4,3]

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};

       System.out.println( "max"+ maxSubArrayLen(arr,7));
        System.out.println("min"+ minSubArrayLen(7,arr));

    }



    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int i=0;
        int j=0;
        int sum=0;

        int minLen = Integer.MAX_VALUE;

        while(j<nums.length){
            if(sum<s){
                sum += nums[j];
                j++;
            }else{
                minLen = Math.min(minLen, j-i);
                if(i==j-1)
                    return 1;

                sum -=nums[i];
                i++;
            }
        }

        while(sum>=s){
            minLen = Math.min(minLen, j-i);

            sum -=nums[i++];
        }

        return minLen==Integer.MAX_VALUE? 0: minLen;
    }
}