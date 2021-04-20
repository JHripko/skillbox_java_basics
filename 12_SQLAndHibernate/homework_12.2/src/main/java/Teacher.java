import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "salary")
    @Getter
    @Setter
    private int salary;

    @Column(name = "age")
    @Getter
    @Setter
    private int age;
}
