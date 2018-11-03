package com.chandra.structures.leetcode;

import java.util.Arrays;
import java.util.HashMap;


/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                int secondIndex = map.get(target-nums[i]);
                result[1] = i;
                result[0] = secondIndex;
            } else if (!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		TwoSum sum = new TwoSum();
		int[] nums = {2, 7, 11, 15};
		int[] nums1 = {3,2,4};
		
		System.out.println(Arrays.toString(sum.twoSum(nums, 9)));
		System.out.println(Arrays.toString(sum.twoSum(nums1, 6)));
		
	}
}
