import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.stream.Stream;

public class WriteRead {

    private final String path;

    public WriteRead(String path) {
        this.path = path;
    }

    public void write(String name,int games,int wins,int losses,int ties,double percent){
        try (FileOutputStream fos = new FileOutputStream(path, true);
             PrintStream printStream = new PrintStream(fos)){
            DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
            String percents  = decimalFormat.format(percent);
            printStream.printf("Player %s has played games: %d\n",name,games );
            printStream.println("Your results :");
            printStream.printf("Wins: %d Losses: %d  Ties: %d Percent: %s\n", wins, losses,ties, percents);
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
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
