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

    public static int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;
        boolean diffSymbol = false;
        if(dividend * divisor < 0)
            diffSymbol = true;

        int i = 0;
        if(diffSymbol) divisor *= -1;
        int val = divisor;
        if(dividend < 0) {
            while(val >= dividend) {
                i++;
                val += divisor;
                if(i == Integer.MAX_VALUE && val > dividend)
                    return Integer.MAX_VALUE;
            }
        } else {
            while(val <= dividend) {
                i++;
                val += divisor;
                if(i == Integer.MAX_VALUE && val < dividend)
                    return Integer.MAX_VALUE;
            }
        }
        return diffSymbol ? i * -1 : i;
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
}
