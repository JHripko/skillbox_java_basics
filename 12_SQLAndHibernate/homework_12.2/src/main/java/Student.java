import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
public class Student {
    private int id;

    private String name;

    private int age;

    private Date registrationDate;

    private List<Course> courses;


    //Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "registration_date")
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @OneToMany
    @JoinTable(name = "Subscriptions",
    joinColumns = {@JoinColumn(name = "student_id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
