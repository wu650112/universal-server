package com.us.bizs.unit;


public class UsMathUnit {

    public static Integer usSum(Integer... args) {
        if (args == null || args.length == 0) {
            return null;
        }
        Integer sum = 0;
        for (Integer a : args) {
            sum += a;
        }
        return sum;
    }
}
