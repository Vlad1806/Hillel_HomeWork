import java.util.Scanner;
public class SquereRoots {
    public static void main(String[] args) {
        System.out.print("Enter coefficient value (x^2): ");
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        if (a == 0){
            System.out.println("when the first term of the equation cannot be zero, change it and try again.");
        }

        System.out.print("Enter coefficient value (x): ");
        float b = scanner.nextFloat();

        System.out.print("Enter coefficient value \"C\": ");
        float c = scanner.nextFloat();
        System.out.println(" ");

        System.out.println("You entered an equation like this: " + a + "x^2 " + b +"x " + c + "C = 0");

        root r = new root(a,b,c);
        r.squere_root();
    }


    static class root{

        private  float a;
        private  float b;
        private  float c;

        public root(float a, float b, float c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        private float discriminant(){
            return  (float) (Math.pow(b,2) - 4 * a * c);
        }

        public void squere_root(){
          float d = discriminant();
            float result1 = (float) ((-b + Math.sqrt(d)) / (2 * a));
            float result2 = (float) (((-b) - Math.sqrt(d)) / (2 * a));
            if (d < 0){
                System.out.println("D = " + d);
                System.out.println("D < 0, then the equation has no real solutions.");
            }
            else
            if (d == 0){
                System.out.println("D = " + d);
                System.out.println("x = " + result1);

            }
            else {
                System.out.println("D = " + d);
                System.out.println("x1 = " + result1 + "    " + "x2 = " + result2);
            }
        }
    }
}
