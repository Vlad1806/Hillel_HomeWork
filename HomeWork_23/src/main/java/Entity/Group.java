package Entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "groupa")
    private String group;

    @OneToMany(mappedBy = "id_group", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Student> students;


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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", group='" + group + '\'' +
                '}';
    }
}
