package DAO;

import Entity.Group;
import Entity.Student;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO implements StudentFunc{
    List<Student> students;
    List<Group> group;
    @Override
    public List<Student> selectAllStudents() {
        students = (List<Student>) HibernateUtil.getSessionFactory().openSession().createQuery("From Student").list();
        return students;
    }
    public List<Group> selectAllGroup() {
        group = (List<Group>) HibernateUtil.getSessionFactory().openSession().createQuery("From Group").list();
        return group;
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session);
        tx1.commit();
        session.close();
    }
    @Override
    public Student selectByID(long studentId) {
        return (Student) HibernateUtil.getSessionFactory().openSession().get(Student.class, studentId);
    }

    @Override
    public List<Student> selectByName(String studentName) {
        return students = (List<Student>) HibernateUtil.getSessionFactory().openSession().createSQLQuery(
                 "Select * From Students s where s.full_name like '" + studentName + "'")
                .addEntity(Student.class).list();

    }

    @Override
    public void addStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }
}
