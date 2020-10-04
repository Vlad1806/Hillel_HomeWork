import java.sql.*;


public class Main {
    public static void main(String[] args){
        try {
            DB DB = new DB("jdbc:mysql://localhost:3306/Hillel2020?"
                    + "useSSL=false&user=root&password=123456789&serverTimezone=UTC");
            System.out.println("Connection successful!!!");

            DB.selectByName("Bill Mitchell");
            DB.selectByID(1);
            DB.selectAllStudent();

            DB.addStudent();
            DB.selectAllStudent();
            System.out.println("" + DB.deleteStudent());
            DB.selectAllStudent();
        }catch (SQLException e) {
            System.out.println("Connection failed!!! ");
            e.printStackTrace();
        }
    }
}
