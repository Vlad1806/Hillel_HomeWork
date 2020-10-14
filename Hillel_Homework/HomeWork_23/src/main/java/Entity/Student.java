package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name")
    private String full_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",nullable = false)
    private Group group;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Mark> marks;


    public void addMark(Mark mark) {
//        mark.setStudent(this);
        marks.add(mark);
    }

    public void removeMark(Mark mark) {
        marks.remove(mark);
    }

    public Student(String full_name, Group group, int year) {
        this.full_name = full_name;
        this.group = group;
        this.year = year;
        marks = new ArrayList<>();
    }

    public Student() {
    }

    private int year;

    public long getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getYear() {
        return year;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
