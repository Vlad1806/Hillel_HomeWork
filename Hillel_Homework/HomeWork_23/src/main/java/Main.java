import Entity.*;
import Service.StudentService;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.findAllStudents().forEach(System.out::println);
    }
}
