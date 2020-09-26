package com.wyl.xue.jwt;

public class test {
    private static void my(int i) {
        System.out.println(i);
    }

    public static void test() {
        int m = 100;
        int n =0;
        double max_size = Math.sqrt(m);
        for (int i = 2; i < max_size; i++) {
            for (int j = 2 * i; j < m; j += i) {
                my(j);
                n++;
            }
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        test();
    }
}