package com.rmi.comm.utils;

import java.util.ArrayList;
import java.util.List;

public class RandomNumGenerator {

    private static final int MAX = 1500;
    private static final int MIN = -1500;

    public static List<Integer> getRandomNumbers(int size) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            integers.add(generateRandomNum());
        }
        return integers;
    }

    private static int generateRandomNum() {
        return (int) ((Math.random() * (MIN - MAX)) + MAX);
    }
}
