import Entity.*;
import Service.StudentService;
import Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.selectAllStudents().forEach(System.out::println);
        System.out.println("By name:");
        studentService.selectStudentByName("Bill Mitchell").forEach(System.out::println);

//        System.out.println("By Id 5: " + studentService.selectStudentById(5));
//        Group group = new Group("React");

//        Student student = new Student("Victor Barinov", new Group("React"),2020);
//        student.addMark(new Mark(new Lesson("UI/UX",2,2020,new Lecturer("Luis Hall2",
//                new Department("Graphical Design",null))),student,95));
//
//        studentService.addStudent(student);
//        studentService.selectAllStudents().forEach(System.out::println);

    }
}
