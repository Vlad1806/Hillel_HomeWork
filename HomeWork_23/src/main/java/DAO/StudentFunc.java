package DAO;

import Entity.Student;

import java.util.List;

public interface StudentFunc {
    List<Student> selectAllStudents();

    Student selectByID(long studentId);

    List<Student> selectByName(String studentName);

    void addStudent(Student student);

    void delete(Student student);
}
