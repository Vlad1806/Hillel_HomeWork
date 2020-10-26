package Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "groupa")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "groupa")
    private String group;

    @OneToMany(
            mappedBy = "id",
            cascade = CascadeType.PERSIST
    )
    private List<Student> students;

    public Group(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", group='" + group + '\'' +
                '}';
    }
}
