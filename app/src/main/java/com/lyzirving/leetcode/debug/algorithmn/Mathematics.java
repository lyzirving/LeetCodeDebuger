package com.lyzirving.leetcode.debug.algorithmn;

public class Mathematics {

    public static double pow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (Math.abs(x) == 1)
            return (n & 1) == 0 ? 1 : x;
        return quickPow(x, n);
    }

    private static double quickPow(double x, int n) {
        if (n == 0)
            return 1;
        double y = quickPow(x, n / 2);
        return (n & 1) == 0 ? y * y : y * y * x;
    }
}
