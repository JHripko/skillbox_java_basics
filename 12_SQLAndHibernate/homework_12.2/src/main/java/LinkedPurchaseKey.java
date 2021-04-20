import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class LinkedPurchaseKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private Course course;

    public LinkedPurchaseKey(Student student, Course course) {
        this.student = student;
        this.course = course;
    }
}
