import lombok.Data;

@Data
public class Customer {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;
}
