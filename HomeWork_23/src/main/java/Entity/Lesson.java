package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lecture",nullable = false)
    private Lecturer lecturer;

    private int semester;
    private int year;

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Mark> marks;

    public Lesson() {

    }


    public void addMark(Mark mark) {
        mark.setLesson(this);
        marks.add(mark);
    }

    public void removeMark(Mark mark) {
        marks.remove(mark);
    }


    public Lesson(String lesson, int semester, int year,Lecturer lecturer) {
        this.lesson = lesson;
        this.semester = semester;
        this.year = year;
        this.lecturer = lecturer;
        marks = new ArrayList<Mark>();
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(byte semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

//    @Override
//    public String toString() {
//        return "Lesson{" +
//                "id=" + id +
//                ", lesson='" + lesson + '\'' +
//                ", semester=" + semester +
//                ", year=" + year +
//                '}';
//    }
}
