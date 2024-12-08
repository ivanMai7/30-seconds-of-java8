package xyz.ivan.snippet.array;

import java.util.AbstractMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JoinMain {
    public static void main(String[] args) {
        Object[] array = Stream.of("a", "b", "c", "d").toArray();
        System.out.println(join(array, "-", "..."));
        Integer[] nums = new Integer[]{1,2,3};
        System.out.println(join(nums,"-","..."));
    }
    public static <T> String join(T[] arr, String separator, String end){
        return IntStream.range(0, arr.length).
                mapToObj(i->new AbstractMap.SimpleEntry<>(i,arr[i])).
                reduce("",(acc,val)->val.getKey() == arr.length - 1 ? acc + val.getValue() + end
                        : acc + val.getValue() + separator, (fst,snd)->snd);
    }
}
