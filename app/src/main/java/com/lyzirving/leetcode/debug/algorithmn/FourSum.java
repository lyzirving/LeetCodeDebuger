package com.lyzirving.leetcode.debug.algorithmn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * LeetCode test No.19
 * figure out how many type of combination of four digits in an array
 * the sum of four digits must be the target value
 */
public class FourSum {
    private static void backTrace(int[] nums, int target, int index, int start,
                                  HashMap<String, List<Integer>> map, List<Integer> current) {
        if (index == 4 && current.size() == 4) {
            int tmp = current.get(0) + current.get(1) + current.get(2) + current.get(3);
            if (tmp == target) {
                List<Integer> unit = new ArrayList();
                unit.addAll(current);
                Collections.sort(unit);
                String key = unit.get(0) + "-" + unit.get(1) + "-" + unit.get(2)
                        + "-" + unit.get(3);
                if (!map.containsKey(key)) {
                    map.put(key, unit);
                }
            }
        } else if (index > 4) {
            //do nothing
        } else {
            for (int i = start; i < nums.length; i++) {
                current.add(nums[i]);
                backTrace(nums, target, index + 1, i + 1, map, current);
                current.remove(index);
            }
        }
    }

    private static void addUniqueToMap(Map<String, List<Integer>> map,
                                       Integer arg0, Integer arg1, Integer arg2,
                                       Integer arg3) {
        String key = arg0 + "-" + arg1 + "-" + arg2 + "-" + arg3;
        if (!map.containsKey(key)) {
            List<Integer> unit = new ArrayList();
            unit.add(arg0);
            unit.add(arg1);
            unit.add(arg2);
            unit.add(arg3);
            map.put(key, unit);
        }
    }

    /**
     * use algorithm back-trace
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> execute0(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 4) {
            return result;
        }
        HashMap<String, List<Integer>> map = new HashMap();
        for (int i = 0; i <= (nums.length - 4); i++) {
            List<Integer> current = new ArrayList();
            //index 0
            current.add(nums[i]);
            backTrace(nums, target, 1, i + 1, map, current);
        }
        Iterator<Map.Entry<String, List<Integer>>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, List<Integer>> entry = iter.next();
            result.add(entry.getValue());
        }
        return result;
    }

    /**
     * use three looper; in the third looper, the double-pointer helps reduce a looper
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> execute1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int count = nums.length;
        Map<String, List<Integer>> map = new HashMap();
        for(int i = 0; i < count - 3; i++) {
            int currentMin = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            int currentMax = nums[i] + nums[count - 3] + nums[count - 2] + nums[count - 1];
            if(currentMin > target)
                continue;
            else if (currentMin == target) {
                addUniqueToMap(map, nums[i], nums[i + 1], nums[i + 2], nums[i + 3]);
                continue;
            }
            if(currentMax < target)
                continue;
            else if (currentMax == target) {
                addUniqueToMap(map, nums[i], nums[count - 3], nums[count - 2], nums[count - 1]);
                continue;
            }
            for(int j = i + 1; j < count - 2; j++) {
                if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    continue;
                if(nums[i] + nums[j] + nums[count - 2] + nums[count - 1] < target)
                    continue;
                int left = j + 1;
                int right = count - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        addUniqueToMap(map, nums[i], nums[j], nums[left], nums[right]);
                        left++;
                        right--;
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        Iterator<Map.Entry<String, List<Integer>>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, List<Integer>> entry = iter.next();
            result.add(entry.getValue());
        }
        return result;
    }
}
