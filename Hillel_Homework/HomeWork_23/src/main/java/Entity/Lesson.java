package Entity;

import javax.persistence.*;
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
    @JoinColumn(name = "id",nullable = false)
    private Lecturer lecturer;

    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Mark> marks;

    public void addMark(Mark mark) {
//        mark.setLesson(this);
        marks.add(mark);
    }

    public void removeMark(Mark mark) {
        marks.remove(mark);
    }


    private byte semester;
    private short year;

    public Lesson(String lesson, byte semester, short year) {
        this.lesson = lesson;
        this.semester = semester;
        this.year = year;
    }

    public Lesson(){
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

    public byte getSemester() {
        return semester;
    }

    public void setSemester(byte semester) {
        this.semester = semester;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lesson='" + lesson + '\'' +
                ", lecturer=" + lecturer +
                ", semester=" + semester +
                ", year=" + year +
                '}';
    }
}
