package com.kenzie.twopointer.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Contains a problem that can be solved using the Two-Pointer Technique.
 */
public class ThreeSumUnique {
    /**
     * Given an unsorted integer array nums, where each element is unique, return all the triplets
     * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Example:
     *  nums = [-1,0,1,3,2,-4]
     *  result = [[-4,1,3],[-1,0,1]]
     *
     * @param nums an unsorted integer array where each element is unique.
     * @return all triplets that sum to 0
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tripletsThatSumToZero = new ArrayList<>();
        //loop through array up to the 3rd element
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //start & end pointer
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    tripletsThatSumToZero.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    //skip duplicates
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        } return tripletsThatSumToZero;
    }
}
