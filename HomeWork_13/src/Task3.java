
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        List<String> str = Stream.of("vlad","andrew","Kostya","Dima","oleg","vova","stas").collect(Collectors.toList());
        str.forEach(s-> System.out.print(s + " "));

        System.out.println(" ");
        str.stream().filter((x)-> x.length() == 4 && x.contains(x.toLowerCase())).
                forEach(result -> System.out.print(result + " "));
    }
}
