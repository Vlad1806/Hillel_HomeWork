package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "group_")
    private String group;

    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Student> students;

    public Group() {
    }

    public Group(String group) {
        this.group = group;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public long getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }





}
