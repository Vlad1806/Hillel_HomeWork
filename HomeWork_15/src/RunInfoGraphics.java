import java.awt.*;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class RunInfoGraphics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        String str;
        do {
            System.out.print("Please enter a positive sequence! (from 0 to 2147483647 and to 10 symbols) : ");
            while (!sc.hasNextInt()) {
                System.out.print("That's not a number! : ");
                sc.next();
            }
            str = sc.next();
            if (str.contains("-") || str.contains("+")){
               str =  str.replace("-","");
               str = str.replace("+","");
            }

        } while (number < 0);

        int width = 160;
        int height = 20;
        BufferedImage bufferedImage = new BufferedImage(
                width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(str, 1, 10);

        for (int y = 0; y < height; y++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < width; x++) {
                stringBuilder.append(bufferedImage.getRGB(x, y) == -16777216 ? " " : "$");
            }

            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }
            System.out.println(stringBuilder);
        }
    }
}
