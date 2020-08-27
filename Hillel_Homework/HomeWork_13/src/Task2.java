import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {

    public static void main(String[] args) {
        List<Pair> pairs = Stream.of("one","two","three","four","five")
                .map(s -> new Pair(s,s.toUpperCase()))
                .collect(Collectors.toList());

        System.out.println(pairs);
    }
}
class Pair {
    private Object first;
    private Object second;

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "" + first +
                ": " + second +
                '}';
    }
}