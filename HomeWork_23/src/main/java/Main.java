import Entity.*;
import Service.Group.GroupService;
import Service.Student.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        GroupService groupService = new GroupService();
        Group group = new Group("React");
        groupService.saveGroup(group);
        System.out.println("All students:");
        studentService.selectAllStudents().forEach(System.out::println);
        System.out.println("");
        System.out.println("By name:");
        studentService.selectStudentByName("Bill Mitchell").forEach(System.out::println);
        System.out.println("");
        System.out.println("By Id 5: " + studentService.selectStudentById(5));

        studentService.selectAllGroup().forEach(System.out::println);
        System.out.println(group.getGroup());
        Student student = new Student("Victor Barinov",2020,group);
        System.out.println("Add student" + student);
        studentService.addStudent(student);
        studentService.selectAllStudents().forEach(System.out::println);

    }
}
