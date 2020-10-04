import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        BD bd = new BD("jdbc:mysql://localhost:3306/Hillel2020?"
                + "useSSL=false&user=root&password=123456789&serverTimezone=UTC");

        bd.selectByName("Bill Mitchell");
        bd.selectByID(1);
        bd.selectAllStudent();

        bd.addStudent();
        bd.selectAllStudent();
        System.out.println("" +bd.deleteStudent());
        bd.selectAllStudent();
    }
}
