package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lectures")
public class Lecturer {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "full_name",nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_department",nullable = false)
    private Department department;

    @OneToMany(mappedBy = "lecturer",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Lesson> lessons;


    public long getId() {
        return id;
    }

    public Lecturer(String name, Department department) {
        this.name = name;
        this.department = department;
        lessons = new ArrayList<>();
    }

    public Lecturer() {
    }

    public void addLesson(Lesson lesson) {
        lesson.setLecturer(this);
        lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

//    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
