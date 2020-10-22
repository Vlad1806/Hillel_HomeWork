
import lombok.Data;

@Data
public class User {
    private String name;
    private String browser ;

    public User(String name, String browser) {
        this.name = name;
        this.browser = browser;
    }
}
