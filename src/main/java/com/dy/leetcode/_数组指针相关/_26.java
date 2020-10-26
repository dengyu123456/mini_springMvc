package com.dy.leetcode._数组指针相关;

/**
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _26 {
//    public static int removeDuplicates(int[] nums) {
//        if (nums.length==0){
//            return 0;
//        }
//        //第一种方案：额外的数组存储
//        List<Integer> alist = new ArrayList<>();
//        int j = 0;
//        int v;
//        int i = 1;
//        alist.add(nums[j]);
//        while (i < nums.length) {
//            if (nums[i] == nums[j]) {
//                i++;
//            } else {
//                j = i;
//                alist.add(nums[j]);
//            }
//        }
//        for (int k = 0; k < alist.size(); k++) {
//            nums[k] = alist.get(k);
//        }
//        return alist.size();
//    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int k = 1;  //[1,k) 之间包含的是非重复元素
        int v = nums[0];  //记录K指针所处的位置的重复元素
        for (int i = 1; i < nums.length; i++) {
            if (!(v == nums[i])) { //如果相等，不交换位置  k=1
//                k++;   //k=2  k往前扫描加1
                //交换位置
                exch(nums, k, i);
                v = nums[k];
                k++;
            }
        }
        return k;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};  //0,1,2,3,4
        int size = removeDuplicates(nums);

        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }
}
