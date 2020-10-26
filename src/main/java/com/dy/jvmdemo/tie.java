package com.dy.jvmdemo;

public class tie {
    public static void main(String[] args) {
        for (int i = 1; i <= 22; i++) {
            System.out.print(getY(i)+"  ");
        }
    }

    public static int getY(int x) {
        if (x%3==0){
            return 80/x+30;
        }
        return 120 / x;
    }
}
