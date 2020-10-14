package Service;

import DAO.StudentDAO;
import Entity.Student;

import java.util.List;

public class StudentService {
    StudentDAO studentDAO = new StudentDAO();

    public List<Student> findAllStudents() {
        return studentDAO.selectAllStudents();
    }
}
