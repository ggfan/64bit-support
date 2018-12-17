package com.example.aar_lib;

public class SampleLib {
    static {
        System.loadLibrary("aar_lib");
    }

    public int add(int a, int b) {
        long sum = (long) a + (long)b;
        if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sum < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)sum;
    }

    public long product(int a, int b) {
        return productNative(a, b);
    }

    private native long productNative(int a, int b);
}
