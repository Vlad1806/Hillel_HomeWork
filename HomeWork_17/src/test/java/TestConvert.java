import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.io.File;

public class TestConvert {
  private String[] json = {"/Users/vlad/Desktop/Hillel_HomeWork/Hillel_Homework/HomeWork_17/src/main/resources/Input/FromJson.json"};
  private String[] yaml = {"/Users/vlad/Desktop/Hillel_HomeWork/Hillel_Homework/HomeWork_17/src/main/resources/Input/FromYAML.yaml"};
  private File result = new File("/Users/vlad/Desktop/Hillel_HomeWork/Hillel_Homework/HomeWork_17/src/main/resources/Output");

  @Before
  public void deleteAllFilesFolder() {
      File[] files = result.listFiles();
      for (File f: files) {
          if (f.isFile()) f.delete();
      }
  }
    @Test
    public void JsonToYaml() {
      Assertions.assertEquals(0,result.listFiles().length);
      MainConvert.main(json);
      Assertions.assertTrue(result.exists());
        Assertions.assertEquals("toYAML.yaml", result.list()[0]);
      Assertions.assertEquals(1, result.list().length);
    }
    @Test
    public void YamlToJson() {
        Assertions.assertEquals(0,result.listFiles().length);
        MainConvert.main(yaml);
        Assertions.assertTrue(result.exists());
        Assertions.assertEquals("toJSON.json", result.list()[0]);
        Assertions.assertEquals(1, result.list().length);
    }
}

