package com.dy.leetcode._数组指针相关;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
public class _16NO {
    int min = Integer.MAX_VALUE;

    //Math.abs(-3.5)=3.5 绝对值
    //暴力解法O（n^3）
//    public int threeSumClosest(int[] nums, int target) {
//        int minC = Integer.MAX_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    int temp = nums[i] + nums[j] + nums[k];
//                    if (Math.abs(target - temp) < minC) {
//                        minC = Math.abs(target - temp);
//                        min = temp;
//                    }
//                }
//            }
//        }
//        return min;
//    }
    //快了20ms
//    public int threeSumClosest(int[] nums, int target) {
//        Map<Integer, String> map = new HashMap<>();
//        //这里能不能把差距最小的找出来
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                map.put(target - (nums[i] + nums[j]), i + "," + j);
//            }
//        }
//        int minC = Integer.MAX_VALUE;
//        int min = Integer.MAX_VALUE;
//        for (Integer a : map.keySet()) {
//            int k = 0;
//            String[] split = map.get(a).split(",");
//            int i = Integer.parseInt(split[0]);
//            int j = Integer.parseInt(split[1]);
//            while (k < nums.length && k != i && k != j) {
//                //比较和a的差距最小的
//                if (Math.abs(a - nums[k]) < minC) {
//                    minC = Math.abs(a - nums[k]);
//                    min = nums[i] + nums[j] + nums[k];
//                }
//                k++;
//            }
//        }
//        return min;
//    }
    public int threeSumClosest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], nums[i]);
        }

        return min;
    }

    //大于返回true，小于返回false
    public boolean min(int i) {
        if (i < min) {
            min = i;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new _16NO().threeSumClosest(nums, target));
    }
}
