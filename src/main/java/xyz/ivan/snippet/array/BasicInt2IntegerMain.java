package xyz.ivan.snippet.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BasicInt2IntegerMain {
    public static void main(String[] args) {
        int[] array = IntStream.of(1, 2).toArray();
        Integer[] integers = int2Integer(array);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    public static Integer[] int2Integer(int[] arr) {
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }

}
