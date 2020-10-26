package Entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lesson",nullable = false)
    private Lesson lesson;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;
    private int mark;


    public Mark() {
    }

    public Mark(Lesson lesson, Student student, int mark) {
        this.lesson = lesson;
        this.student = student;
        this.mark = mark;
    }

    public long getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", mark=" + mark +
                '}';
    }
}
