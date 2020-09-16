import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Convert {
   private String path;
   private File file;

    public Convert(String path) {
        this.path = path;
        check();
    }

    private void check(){
        if (path == null ) System.out.println("Wrong file path!!!");
       File f =  new File(path);
        if (f.exists() && f.isFile() && f.canRead()) {
            if (path.contains(".json")) JsontoYaml();

            if (path.contains(".yaml")) YamltoJson();
        }
        else{
            System.out.println("Wrong file path!!!");
        }
    }

    private void YamltoJson(){
        file = new File("/Users/vlad/Desktop/Hillel_HomeWork/Hillel_Homework/HomeWork_17/src/main/resources/Output/toJSON.json");
        Yaml yaml = new Yaml(new Constructor(Customer.class));
        String yamlStr = readToString(path);
        Customer customer = yaml.load(yamlStr);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void JsontoYaml(){
        file = new File("/Users/vlad/Desktop/Hillel_HomeWork/Hillel_Homework/HomeWork_17/src/main/resources/Output/toYAML.yaml");
        Gson gson = new Gson();
        String jsonStr = readToString(path);
        Customer customer = gson.fromJson(jsonStr,Customer.class);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(file,customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String readToString(String filePath) {

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
