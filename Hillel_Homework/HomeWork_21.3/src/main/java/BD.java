import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class BD {
    Connection connection;

    public BD(String url) {
        try {
            this.connection = DriverManager
                    .getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private String[] input() throws SQLException {
        String name;
        int group;
        int year;
        int max_year = Calendar.getInstance().get(Calendar.YEAR);
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("\nEnter full name: ");
            name = scanner.nextLine();
        }while ((name.isEmpty()));

        int count =  printGroups();
        do {
            System.out.print("Choose the group : ");
            group = scanner.nextInt();
        }while (!checkGroup(group,count));

        do {
            System.out.print("Enter year of admission (year > 2018 and <= " + max_year + ") : ");
            year = scanner.nextInt();
        }while (!checkYear(year,max_year));

        String []st = new String[3];
        st[0] = name;
        st[1] = String.valueOf(group);
        st[2] = String.valueOf(year);
        return st;
    }

    private boolean checkGroup(int group,int max){
        return (group > 0 && group <= max);
    }

    private boolean checkYear(int year,int max){
        return (year > 2018 && year <= max);
    }

    public void addStudent() throws SQLException {
       String []st =  input();
        String query = """
              INSERT INTO Hillel2020.students (full_name, id_group, year) Value (?,?,?)
              """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,st[0]);
        preparedStatement.setInt(2,Integer.parseInt(st[1]));
        preparedStatement.setInt(3,Integer.parseInt(st[2]));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("\nThe addition has been completed");
    }

    public void selectByName(String name) throws SQLException {
        String query = selectStudent() + "WHERE full_name = \"" + name + "\"";
        System.out.println(" ");
        System.out.println("\nStudent name: " + name);
        printStudent(query);
    }

    public void selectByID(int id) throws SQLException {
        String query = selectStudent() + "WHERE s.id = " + id;
        System.out.println(" ");
        System.out.println("\nStudent id: " + id);
        printStudent(query);
    }

    public void selectAllStudent() throws SQLException {
        String query = selectStudent();
        System.out.println("\nAll students: \n");
        printStudent(query);
    }

    public String deleteStudent() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.print("\tEnter student ID to delete : ");
        int id = sc.nextInt();
        String query = "Delete from Hillel2020.students Where id = ?";

        int before = countStudents();

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

        int after = countStudents();
        preparedStatement.close();
        if (after < before) return "\nRemoval was successful";
        return "\nRemoval failed";
    }

    private int countStudents() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select COUNT(*) FROM Hillel2020.students");
        resultSet.next();
        int count = resultSet.getInt(1);
        return count;
    }
    private void printStudent(String query) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            System.out.printf("%d\t" + "%-20s\t" + "%-20s\t\t" + "%-4d\n",resultSet.getInt(1),
                    resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4));
        }
        statement.close();
    }

    private String selectStudent(){
        return "SELECT s.id,full_name, group_, year FROM Hillel2020.students s join" +
                " Hillel2020.groups g on id_group = g.id ";
    }

    private int printGroups() throws SQLException {
        String query = "SELECT * FROM Hillel2020.groups";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        int i = 0;
        while (resultSet.next()){
            i++;
            System.out.println(i + "\t" + resultSet.getString(2));
        }
        statement.close();
        return i;
    }

}
