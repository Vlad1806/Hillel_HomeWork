package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "full_name")
    private String full_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_group", nullable = false)
    private Group group;

    @Column(name = "year")
    private int year;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Mark> marks;

    public Student() {
    }

    public Student(String full_name, int year, Group group) {
        this.full_name = full_name;
        this.year = year;
        this.group = group;
    }
    public void addMark(Mark mark) {
        mark.setStudent(this);
        marks.add(mark);
    }

    public void removeMark(Mark mark) {
        marks.remove(mark);
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", group=" + group.getGroup() +
                ", year=" + year +
                '}';
    }
}