package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name_department", nullable = false)
    private String name;

    private String head;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Lecturer> lecturers;

    public Department(String name, String head) {
        this.name = name;
        this.head = head;
        lecturers = new ArrayList<>();
    }

    public Department() {
    }

    public void addLecturer(Lecturer lecturer) {
        lecturer.setDepartment(this);
        lecturers.add(lecturer);
    }

    public void removeLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name of department='" + name + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}
