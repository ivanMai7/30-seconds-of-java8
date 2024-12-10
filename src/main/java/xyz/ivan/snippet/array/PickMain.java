package xyz.ivan.snippet.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PickMain {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        Integer[] array = IntStream.of(1, 3, 5, 7).boxed().toArray(Integer[]::new);
        pick(map,array).forEach((k,v)-> System.out.println(k + "==" + v));
    }

    private static <T,R> Map<T,R> pick(Map<T,R> obj, T[] arr){
        return Arrays.stream(arr)
                .filter(obj::containsKey)
                .collect(Collectors.toMap(k->k,obj::get));
    }
}
