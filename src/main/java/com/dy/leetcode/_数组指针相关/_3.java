package com.dy.leetcode._数组指针相关;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3 {
    //最长不包含重复字符的长度
    int max = 0;

    public int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        int[] temp = new int[256];  //temp当中一定是现在不重复的子串
        int le = 0, ri = 0; //[le,ri]当中是符合要求的子串长度： ri-le+1；
        while (ri < s.length()) {
            //维护[le,ri]之间一定是不重复的
            //查看ri+1是否在[le，ri]当中是否有重复
            if (temp[a[ri]] == 0) {
                temp[a[ri]] = 1;
            } else {//如果有重复的  找到重复的的位置 le定位到重复的位置 重复之前的全部变为0
                while (le < ri + 1) {
                    if ((a[le] == a[ri])) {
                        temp[a[le]] = 0;
                        le++;
                        break;
                    }
                    temp[a[le]] = 0;
                    le++;
                }
                temp[a[ri]] = 1;
            }
            max(ri - le + 1);
            ri++;
        }
        return max;
    }

    //大于返回true，小于返回false
    public boolean max(int i) {
        if (i > max) {
            max = i;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //bbbbb   pwwkew   abcabcbb
        System.out.println(new _3().lengthOfLongestSubstring("bbbbb"));
    }
}
