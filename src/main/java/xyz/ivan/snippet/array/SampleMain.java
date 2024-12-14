package xyz.ivan.snippet.array;


import java.util.stream.IntStream;

public class SampleMain {
    public static void main(String[] args) {
        Integer[] integers = BasicInt2IntegerMain.int2Integer(IntStream.of(1, 2, 3).toArray());
        System.out.println(sample(integers));
    }

    static <T> T sample(T[] arr){
        return arr[(int)Math.floor(Math.random() * arr.length)];
    }
}
