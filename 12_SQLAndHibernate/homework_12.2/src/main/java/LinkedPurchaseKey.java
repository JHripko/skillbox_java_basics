import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class LinkedPurchaseKey implements Serializable {
    @Column(name = "student_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private int studentId;

    @Column(name = "course_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private int courseId;

    public LinkedPurchaseKey(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
