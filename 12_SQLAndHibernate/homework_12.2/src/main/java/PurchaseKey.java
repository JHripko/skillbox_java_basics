import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PurchaseKey implements Serializable {
    @Column(name = "student_id")
    private Student student;

    @Column(name = "course_id")
    private Course course;

    public PurchaseKey(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
