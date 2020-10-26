package com.dy.leetcode._数组指针相关;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _80NO {
    //    public static int removeDuplicates(int[] nums) {
//        if (nums.length <= 0) {
//            return 0;
//        }
//        //int k =0; //[0,k)  包含所有重复次数小于等于2次的元素  循环当中第k个元素需要和后面的第一个不等于v的元素交换位置
//        int v = nums[0]; //初始值
//        int j = 0;  //j表示出现的次数
//        int k = nums.length;
//        for (int i = 1; i < k; i++) {
//            if (v == nums[i]) {
//                j++;
//            } else {
//                while (j > 2) {
//                    remove(nums, --i);
//                    j--;
//                    k--;
//                }
//                v = nums[i];
//                j = 1;
//            }
//        }
//
//        return k;
//    }
    public static int removeDuplicates(int[] nums, int k) {
        if (nums == null) return 0;
        if (nums.length <= k) return nums.length;

        // 1.定义[0,index] 是修改后的满足要求的数组区间,这里已经把0 1 2 ...k- 1 ,共k个数 放进去了
        int index = k - 1;
        // 2.判断终止条件
        for (int i = k; i < nums.length; i++) {
            // 3.指针移动条件
            if (nums[i] != nums[index - k + 1]) {
                index++;
                nums[index] = nums[i];
            }
        }
        // 4.判断返回值
        return index + 1;
    }


    private static int[] remove(int[] a, int i) {
        for (int j = i + 1; j < a.length; j++) {
            a[j - 1] = a[j];
        }
        return a;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};  //0, 0, 1, 1, 2, 3, 3,4,4
        int size = removeDuplicates(nums,0);

        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }
}
