package com.lyzirving.leetcode.debug.algorithmn;

public class Search {
    public static int binarySearch(int left, int right, int[] nums, int target) {
        if(left == right) {
            return nums[left] == target ? left : -1;
        }
        int mid = (left + right) >> 1;
        if(mid == left) {
            if(nums[left] == target)
                return left;
            else if(nums[right] == target)
                return right;
            return -1;
        }
        if(target < nums[mid]) {
            right = mid;
        } else if(target > nums[mid]) {
            left = mid;
        } else {
            return mid;
        }
        return binarySearch(left, right, nums, target);
    }

    /**
     * LeetCode question No.34
     * find target range in nums
     * @param nums input array
     * @param target target value
     * @return range
     */
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int pos = binarySearch(0, nums.length - 1, nums, target);
        if(pos == -1)
            return new int[]{-1, -1};
        int left = pos, right = pos;
        boolean stopSearchLeft = false;
        boolean stopSearchRight = false;
        for(;;) {
            if(left < 0 || nums[left] != target) {
                stopSearchLeft = true;
            } else {
                left--;
            }
            if(right >= nums.length || nums[right] != target) {
                stopSearchRight = true;
            } else {
                right++;
            }
            if(stopSearchLeft && stopSearchRight)
                break;
        }
        left++;
        right--;
        return new int[]{left, right};
    }
}
