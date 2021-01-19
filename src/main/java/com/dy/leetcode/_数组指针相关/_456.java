package com.dy.leetcode._数组指针相关;

//132-pattern
//给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
//
//注意：n 的值小于15000。
//
//示例1:
//
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
//示例 2:
//
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
//示例 3:
//
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/132-pattern
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _456 {


    //    public boolean find132pattern(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int j = i + 1;
//            if (j < nums.length && nums[j] > nums[i]) {
//                for (; j < nums.length; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (nums[k] < nums[j] && nums[k] > nums[i]) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public static boolean[] visit = null;

    public boolean find132pattern(int[] nums) {
        visit = new boolean[nums.length];
        //1、寻找出数组的最大值 记录下标index 数组被分为 0-index-1  index+1-length
        //2、在右边找出最大值 记录最大值 riMax 然后去左边找小于riMax的值
        int m = 0;
        while (m < nums.length) {
            int index = findMaxIndex(nums);
            int riMax = Integer.MIN_VALUE / 2;
            if (index + 1 < nums.length) {
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] > riMax&& nums[i] < nums[index]) {
                        riMax = nums[i];
                    }
                }
            }
            if (index > 0 && riMax != Integer.MIN_VALUE / 2 && riMax < nums[index]) {
                for (int i = 0; i < index; i++) {
                    if (nums[i] < riMax) {
                        return true;
                    }
                }
            }

            m++;
        }
        return false;
    }

    private int findMaxIndex(int[] nums) {
        int max = Integer.MIN_VALUE / 2;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i] && nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        visit[index] = true;
        return index;
    }

    public static void main(String[] args) {
        int nums[] = {12,1,2, 3, 2, 4, 10,-1};
        int min[]=new  int[nums.length];
        min[0]=nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);

       System.out.println(new _456().find132pattern(nums));
    }
}
