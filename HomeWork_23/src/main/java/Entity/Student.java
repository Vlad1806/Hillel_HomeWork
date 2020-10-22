package Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "students")
public class Student {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "full_name")
    private String full_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()//name = "id_group",nullable = false)
    private Group id_group;

    @Column(name = "year")
    private int year;

//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private List<Mark> marks;

    public Student() {

    }

    public Student(String full_name, Group group, int year) {
        this.full_name = full_name;
        this.id_group = group;
        this.year = year;
//        marks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", id_group=" + id_group +
                ", year=" + year +
                '}';
    }


    public Group getGroup() {
        return id_group;
    }
    public void setGroup(Group group) {
        this.id_group = group;
    }

//    public List<Mark> getMarks() {
//        return marks;
//    }
//
//    public void setMarks(List<Mark> marks) {
//        this.marks = marks;
//    }
}
//    public long getId() {
//        return id;
//    }
//
//    public String getFull_name() {
//        return full_name;
//    }
//
//    public void setFull_name(String full_name) {
//        this.full_name = full_name;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }

//    public void addMark(Mark mark) {
//        mark.setStudent(this);
//        marks.add(mark);
//    }

//    public void removeMark(Mark mark) {
//        marks.remove(mark);
//    }