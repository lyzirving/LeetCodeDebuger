package com.lyzirving.leetcode.debug.data;

public class ArrayUtil {

    /**
     * LeetCode question No.26
     * @param num src arrays which may contain repeated items, and array is sorted by ascending order
     * @return  the number of rest item
     */
    public static int removeRepeatItem(int[] num) {
        if (num == null || num.length == 0) return 0;
        int count = num.length;
        int repeat = 0;
        for (int i = 1; i < count && (i + repeat) < count;) {
            if (num[i] == num[i - 1]) {
                repeat++;
                for (int j = i + 1; j < count; j++) {
                    num[j - 1] = num[j];
                }
            } else {
                i++;
            }
        }
        return count - repeat;
    }

    public static int removeRepeatItem_DoublePtr(int[] num) {
        if (num == null || num.length == 0) return 0;
        if (num.length == 1) return 1;
        int slow = 1;
        int fast = 1;
        while(fast < num.length) {
            if (num[fast] != num[fast - 1]) {
                num[slow] = num[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static int removeSpecificItem(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == val ? 0 : 1;
        int count = nums.length;
        int repeat = 0;
        int slotUsed = 0;
        int pt1 = 0;
        while ((pt1 + slotUsed) < count) {
            if (nums[pt1] == val) {
                repeat++;
                int slot = count - 1 - slotUsed;
                while(pt1 < slot && nums[slot] == val)
                    slot--;
                if (slot <= pt1)
                    break;
                nums[pt1] = nums[slot];
                slotUsed++;
            }
            pt1++;
        }
        return count - repeat;
    }

}
