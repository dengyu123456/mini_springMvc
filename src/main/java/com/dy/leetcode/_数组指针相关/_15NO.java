package com.dy.leetcode._数组指针相关;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * <p>
 * 输入：
 * [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
 * 输出：
 * [[-2,6,-4],[-4,4,0],[-4,3,1],[-4,2,2]]
 * 预期结果：
 * [,[-4,0,4],,,
 * [-4,2,2],[-2,0,2]],[-4,1,3],[-2,-2,4],[-4,-2,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _15NO {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                temp = 0 - nums[i] - nums[j];
                if (map.containsKey(temp) && map.get(temp) > 0) {
                    List<Integer> vo = new ArrayList<>();
                    vo.add(nums[i]);
                    vo.add(nums[j]);
                    vo.add(temp);
                    list.add(vo);
                    map.put(temp, map.get(temp) - 1);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {

        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        new _15NO().threeSum(nums);
    }

}
