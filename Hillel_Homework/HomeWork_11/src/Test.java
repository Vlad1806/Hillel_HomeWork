import java.util.Objects;

public class Test {
    enum Person {
        Mozart, Picasso, Goethe, Dostoevsky, Prokofiev, Dali
    }

    static void print(Person person) {
        String title = switch (person) {
            case Dali, Picasso      -> "painter";
            case Mozart, Prokofiev  -> "composer";
            case Goethe, Dostoevsky -> "writer";
        };
        System.out.printf("%s was a %s%n", person, title);
    }

    record Point(float x, float y) {
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) {
        print(Person.Mozart);
        print(Person.Dali);
        print(Person.Dostoevsky);
        System.out.println(" ");
        var point = new Point(1, 2);
        System.out.println(point);
        System.out.println("hashCode = " + point.hashCode());
        System.out.println("hashCode2 = " + Objects.hash(point.x(), point.y()));

        var point2 = new Point(1, 2);
        System.out.println(point.equals(point2));
    }
}