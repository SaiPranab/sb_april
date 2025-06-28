package com.tastytown.backend.utils;

public class OrderCodeGenerator {
    private OrderCodeGenerator() {}

    public static String generateOrderCode() {
        char c1 = (char) ('A' + (int) (Math.random() * 26));
        char c2 = (char) ('A' + (int) (Math.random() * 26));
        char c3 = (char) ('A' + (int) (Math.random() * 26));

        int digits = (int) (Math.random() * 9000) + 1000;

        return "ORD-" + c1 + c2 + c3 + "-" + digits;
    }

    // ORD-XYZ-7654
}
