package DAO;

import Entity.Student;
import Util.HibernateUtil;

import java.util.List;

public class StudentDAO implements StudentFunc{
    List<Student> students;
    @Override
    public List<Student> selectAllStudents() {
        students = (List<Student>) HibernateUtil.getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }

    @Override
    public Student selectByID(int studentId) {
        return null;
    }

    @Override
    public List<Student> selectByName(String studentName) {
        return null;
    }

    @Override
    public void addStudent(Student student) {

    }
}
