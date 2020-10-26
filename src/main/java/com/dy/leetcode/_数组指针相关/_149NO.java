package com.dy.leetcode._数组指针相关;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * <p>
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _149NO {
    public int maxPoints(int[][] points) {
        //线性方程：y=a*x+b;
        //map存储每个点之间的线段
        if (points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        //枚举每条线
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                String ab = getab(x1, y1, x2, y2);
                if (!map.containsKey(ab)) {
                    map.put(ab, 0);
                }
            }
        }
        //取出每个点，统计该点应该在那条线上
        //线性方程：y=a*x+b;
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            for (String str : map.keySet()) {
                String[] split = str.split(",");
                if ("x".equals(split[0]) && (x + "").equals(split[1])) {
                    map.put(str, map.get(str) + 1);
                }
                if ("y".equals(split[0]) && (y + "").equals(split[1])) {
                    map.put(str, map.get(str) + 1);
                }
                if (!"x".equals(split[0]) && !"y".equals(split[0])) {
                    //线性方程：y=a*x+b;
                    double a = Double.parseDouble(split[0]);
                    double b = Double.parseDouble(split[1]);
                    if (y == a * x + b) {
                        map.put(str, map.get(str) + 1);
                    }
                }
            }
        }
        //找到最多点出现的频率的线
        for (String str : map.keySet()) {
            if (map.get(str) > max) {
                max = map.get(str);
            }
        }
        return max;
    }

    //计算ab y=a*x+b   y1-a*x1=y2-a*x2  y-x*a=b;  (y-b)/a=x x=1,2,3,4
    //y1-y2=a*x1-a*x2
    //a=y1-y2/x1-x2
    //
    private String getab(int x1, int y1, int x2, int y2) {
        double a;
        double b;
        if (x1 == x2) {
            return "x," + x1;
        } else if (y1 == y2) {
            return "y," + y1;
        } else {
            a = (y1 - y2) / (x1 - x2)+0.0;
            b = y1 - x1 * a;
            return a + "," + b;
        }
    }

//    //解一元二次方程组
//    private double getN(int c) {
//        int a = 1, b = -1;
//        double x1 = ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));//运用求根公式，并且Math.sqrt()为开平方根
//        double x2 = ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));//运用求根公式，并且Math.sqrt()为开平方根
//        if (x1 > 0) {
//            return x1;
//        } else {
//            return x2;
//        }
//    }

    public static void main(String[] args) {
//        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
//        int[][] points = {{0, 0}, {1, 1}, {0, 0}, {0, 0}};
//        int[][] points = {{1, 1}, {1, 1}, {2, 3}, {1, 1}, {1, 1}};
//        int[][] points = {{1, 1}, {1, 1}, {1, 1}};
        int[][] points = {{3, 10}, {0, 2}, {0, 2}, {3, 10}};
        System.out.println(new _149NO().maxPoints(points));


    }
}
