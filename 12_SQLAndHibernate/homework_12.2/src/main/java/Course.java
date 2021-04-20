import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Getter
    @Setter
    private CourseType type;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @Getter
    @Setter
    private Teacher teacher;

    @Column(name = "students_count")
    @Getter
    @Setter
    private Integer studentsCount;

    @Column(name = "price")
    @Getter
    @Setter
    private int price;

    @Column(name = "price_per_hour")
    @Getter
    @Setter
    private float pricePerHour;

    @ManyToMany
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    @Getter
    @Setter
    private List<Student> students;
}
