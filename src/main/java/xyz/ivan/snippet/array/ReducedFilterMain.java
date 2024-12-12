package xyz.ivan.snippet.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReducedFilterMain {
    public static void main(String[] args) {
        Map<String,Object>[] data = new Map[2];
        Map<String,Object> students = new HashMap<>();
        students.put("Ron",1);
        students.put("Harry",2);
        students.put("Hermione",3);
        students.put("Draco",4);
        Map<String,Object> house = new HashMap<>();
        house.put("Gryffindor",5);
        house.put("Slytherin",6);
        house.put("RavenClaw",7);
        house.put("Hufflepuff",8);
        data[0] = students;
        data[1] = house;
        String[] keys = new String[]{"Gryffindor","Hermione"};
        for (Map<String, Object> map : reducedFilter(data, keys, (map) -> map.containsKey("Gryffindor"))) {
           map.forEach((k,v) -> System.out.println(k + "==" + v));
        }
    }


    public static Map<String, Object>[] reducedFilter(Map<String, Object>[] data, String[] keys, Predicate<Map<String, Object>> fn) {
        return Arrays.stream(data)
                .filter(fn)
                .map(
                        el->Arrays.stream(keys).filter(el::containsKey)
                                .collect(Collectors.toMap(k->k, el::get))
                ).toArray((IntFunction<Map<String, Object>[]>) Map[]::new);
    }

}
