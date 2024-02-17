package com.ex17.executor_service.case2_callable;

import java.util.concurrent.Callable;

public class FetchSumJob implements Callable {
    int number;

    public FetchSumJob(int number) {
        this.number = number;
    }

    public int getSum() {
        int sum = 0;
        if (number == 0) throw new RuntimeException(number + " is not allowed");
        for (int i = 0; i <= number; i++) {
            sum = sum + i;
        }
        System.out.println("Sum of " + number + ", Executed by: " + Thread.currentThread().getName());
        return sum;
    }

    @Override
    public Integer call() {
        return getSum();
    }
}
