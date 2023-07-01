package code_자동차_단일_거래_이익_최대화하기_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Arrays;

public class Code_자동차_단일_거래_이익_최대화하기_2 {

    private static int n;
    private static long[] cars;

    public static void main(String[] args) {
        init();
        System.out.println(maxDiff());
    }

    private static void init() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(input.readLine());
            cars = Arrays.stream(input.readLine().split(" "))
                         .mapToLong(Long::parseLong)
                         .toArray();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static long maxDiff() {
//        int minArg = getMinArg();
//        int maxArgAfterMinArg = getMaxArgAfterMinArg(minArg);
//        return cars[maxArgAfterMinArg] - cars[minArg];

        long maxDiff = 0;
        long minCar = cars[0];

        for (int i = 1; i < n; i++) {
            if (minCar > cars[i]) {
                minCar = cars[i];
                continue;
            }

            maxDiff = Math.max(maxDiff, cars[i] - minCar);
        }

        return maxDiff;
    }

    private static int getMinArg() {
        int minArg = -1;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (min > cars[i]) {
                minArg = i;
                min = cars[i];
            }
        }

        return minArg;
    }

    private static int getMaxArgAfterMinArg(int minArg) {
        int maxArg = -1;
        long max = Long.MIN_VALUE;

        for (int i = minArg; i < n; i++) {
            if (max < cars[i]) {
                maxArg = i;
                max = cars[i];
            }
        }

        return maxArg;
    }

}
