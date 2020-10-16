import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class WriteRead {

    private final String path;
    private ResourceBundle resourceBundle;

    public WriteRead(String path, ResourceBundle resourceBundle) {
        this.path = path;
        this.resourceBundle = resourceBundle;
    }

    public void write(String name,int games,int wins,int losses,int ties,double percent){
        try (FileOutputStream fos = new FileOutputStream(path, true);
             PrintStream printStream = new PrintStream(fos)){
            DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
            String percents  = decimalFormat.format(percent);
            printStream.printf( resourceBundle.getString("games"),name,games);
            printStream.println("\n" + resourceBundle.getString("results"));
            printStream.printf(resourceBundle.getString("score"), wins, losses,ties, percents);
            printStream.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readToString() {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contentBuilder.toString();
    }
}
