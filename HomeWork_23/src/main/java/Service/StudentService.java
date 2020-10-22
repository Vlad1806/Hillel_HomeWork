package Service;

import DAO.StudentDAO;
import Entity.Group;
import Entity.Student;

import java.util.List;

public class StudentService {
    StudentDAO studentDAO = new StudentDAO();

    public List<Student> selectAllStudents() {
        return studentDAO.selectAllStudents();
    }
    public List<Group> selectAllGroup() {
        return studentDAO.selectAllGroup();
    }
    public Student selectStudentById(long id){
        return studentDAO.selectByID(id);
    }

    public List<Student> selectStudentByName(String name){
        return studentDAO.selectByName(name);
    }

    public void deleteStudent(Student student){
        studentDAO.delete(student);
    }

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }
}
