package Entity;

import javax.persistence.*;

@Entity
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue
    private long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id",nullable = false)
//    private Lesson lesson;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id",nullable = false)
//    private Student student;

    private byte mark;


    public Mark() {
    }

    public Mark(Lesson lesson, Student student, byte mark) {
//        this.lesson = lesson;
//        this.student = student;
        this.mark = mark;
    }

    public long getId() {
        return id;
    }

//    public Lesson getLesson() {
//        return lesson;
//    }
//
//    public void setLesson(Lesson lesson) {
//        this.lesson = lesson;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
//                ", lesson=" + lesson +
//                ", student=" + student +
                ", mark=" + mark +
                '}';
    }
}
