import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchase {
    @EmbeddedId
    private LinkedPurchaseKey id;

    @Column(name = "student_id")
    private Student student;

    @Column(name = "course_id")
    private Course course;


    //Getters & Setters
    public LinkedPurchaseKey getId() {
        return id;
    }

    public void setId(LinkedPurchaseKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
