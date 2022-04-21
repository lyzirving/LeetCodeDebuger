package com.lyzirving.leetcode.debug.data;

public class StringUtil {

    public static int findStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack == null || haystack.length() == 0)
            return 0;
        int len = haystack.length();
        for (int i = 0; i < len; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int matchLen = needle.length();
                boolean pair = true;
                if ((i + matchLen - 1) < len) {
                    for (int j = 1; j <= matchLen - 1; j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            pair = false;
                            break;
                        }
                    }
                } else {
                    pair = false;
                }
                if (pair)
                    return i;
            }
        }
        return -1;
    }

}
