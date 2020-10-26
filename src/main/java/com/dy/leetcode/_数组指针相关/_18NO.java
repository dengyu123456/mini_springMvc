package com.dy.leetcode._数组指针相关;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _18NO {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //借助set去重
        Set<String> stringSet = new HashSet<>();
        //特殊处理[0,0,0,0]的情况
        ArrayList<List<Integer>> list = new ArrayList<>();
        //nums[a]+nums[b]+nums[c]+nums[d]=target;
        Arrays.sort(nums);
        if (nums.length >= 4 && nums[0] == 0 && nums[nums.length - 1] == 0 && target == 0) {
            List<Integer> resultList = new ArrayList<>();
            resultList.add(0);
            resultList.add(0);
            resultList.add(0);
            resultList.add(0);
            list.add(resultList);
            return list;
        }
        //{-2,-1,0,0,1,2}
        //去除重复数组，那么必须按照nums[a]<=nums[b]<=nums[c]<=nums[d]的顺序 排除掉bcad、dcba等顺序
        //a=target-nums[b]-nums[c]-nums[d]
        //[]
        for (int a = 0; a + 1 < nums.length; a++) {
//            //排除掉重复元素
//            if (nums[a] == nums[a + 1]) {
//                continue;
//            }
            int target2 = target - nums[a];
            //在剩下的元素中找nums[b]+nums[c]+nums[d]=target2 且满足nums[a]<=nums[b]<=nums[c]<=nums[d]
            //nums[c]+nums[d]=target2-nums[b]
            int b = a + 1;
            while (b < nums.length && nums[b] >= nums[a]) {
                //排除掉重复元素
//                if (nums[b] == nums[b - 1]) {
//                    b++;
//                    continue;
//                }
                int target3 = target2 - nums[b];
                //target3=nums[c]+nums[d]
                int c = b + 1, d = nums.length - 1;//初始化c、d
                while (d > c) {
                    if ((nums[c] + nums[d]) < target3) {
                        ++c;
                    } else if ((nums[c] + nums[d]) > target3) {
                        --d;
                    } else if (!stringSet.contains(nums[a] + "" + nums[b] + nums[c] + nums[d])) {
                        List<Integer> resultList = new ArrayList<>();
                        resultList.add(nums[a]);
                        resultList.add(nums[b]);
                        resultList.add(nums[c]);
                        resultList.add(nums[d]);
                        list.add(resultList);
                        stringSet.add(nums[a] + "" + nums[b] + nums[c] + nums[d]);
                    } else {
                        c++;
                    }
                }
                b++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //1, 0, -1, 0, -2, 2
        //-3, -2, -1, 0, 0, 1, 2, 3
        //[-1,0,1,2,-1,-4]
        //-1
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        new _18NO().fourSum(nums, target);


    }
}
