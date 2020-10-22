import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class Task1 {
    public static void main(String[] args) {

        List<Integer> list = new Random()
                .ints(10, 1, 100).boxed().collect(toList());

        list.forEach(s-> System.out.print((s + " ")));

        System.out.println(" ");
        System.out.println("Average : " + list.stream().
                mapToDouble(s -> Integer.parseInt(String.valueOf(s)))
                .average().getAsDouble());
    }
}
