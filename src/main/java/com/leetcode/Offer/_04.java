package com.leetcode.Offer;

public class _04 {
    //二分查找
    int minI = 0;
    int maxI = 0;
    int minJ = 0;
    int maxJ = 0;

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int leI = 0;
        int leJ = 0;
        if (matrix == null || matrix.length == 0) return false;
        int riI = matrix.length - 1;
        int riJ = matrix[0].length - 1;
        maxI = riI;
        maxJ = riJ;
        return dp(leI, leJ, riI, riJ, matrix, target);
    }

    private boolean dp(int leI, int leJ, int riI, int riJ, int[][] matrix, int target) {
        int midI = (leI + riI) / 2;
        int midJ = (leJ + riJ) / 2;
        // if (matrix[midI][midJ] == target) return true;
        //if (leI > minI && leI < maxI && leJ > minJ && leJ < maxJ && matrix[leI][leJ] == target) return true;
        //if (riI > midI && riI < maxI && riJ > minJ && riJ < maxJ && matrix[riI][riJ] == target) return true;
        if (leI <= riI && leJ <= riJ && midI >= minI && midI <= maxI && midJ >= minJ && midJ <= maxJ) {
            if (matrix[midI][midJ] == target) return true;
            if (matrix[midI][midJ] > target) {
                if (dp(leI, leJ, midI - 1, riJ, matrix, target)) {
                    return true;
                }
                if (dp(leI, leJ, riI, midJ - 1, matrix, target))
                    return true;

            } else if (matrix[midI][midJ] < target) {
                if (dp(midI + 1, leJ, riI, riJ, matrix, target)) {
                    return true;
                }
                if (dp(leI, midJ + 1, riI, riJ, matrix, target))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int nums[][] = {
//                {3, 3, 8, 13, 13, 18},
//                {4, 5, 11, 13, 18, 20},
//                {9, 9, 14, 15, 23, 23},
//                {13, 18, 22, 22, 25, 27},
//                {18, 22, 23, 28, 30, 33},
//                {21, 25, 28, 30, 35, 35},
//                {24, 25, 33, 36, 37, 40}};
       int [][]nums={{93,157,226,308,365,384,479,539,557,652},{118,234,287,368,395,432,480,607,634,723},{132,263,381,453,525,533,577,650,707,800},{171,307,473,504,526,596,643,719,776,842},{233,319,514,571,668,710,733,777,875,886},{318,362,555,605,717,782,809,884,889,940},{349,415,622,708,787,795,824,921,957,1014},{414,420,656,789,813,898,954,1052,1095,1175},{430,477,705,863,961,991,1003,1121,1190,1236},{524,611,793,868,1027,1111,1112,1123,1252,1253}};
        //System.out.println(nums[5][0]);
        System.out.println(new _04().findNumberIn2DArray(nums, 1253));
    }
}
