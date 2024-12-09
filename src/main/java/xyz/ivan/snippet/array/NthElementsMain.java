package xyz.ivan.snippet.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NthElementsMain {
    public static void main(String[] args) {
        Integer[] array = IntStream.of(1, 2, 3, 4).boxed().toArray(Integer[]::new);
        System.out.println(nthElements(array, -1));
    }

    private static <T> T nthElements(T[] elements, int n){
        if (n >= 0) {
            return Arrays.copyOfRange(elements,n,elements.length)[0];
        }
        return Arrays.copyOfRange(elements,elements.length + n,elements.length)[0];
    }
}