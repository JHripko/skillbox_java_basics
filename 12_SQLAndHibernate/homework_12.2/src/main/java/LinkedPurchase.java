import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchase {
    @EmbeddedId
    @Getter
    @Setter
    private LinkedPurchaseKey id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, insertable = false, updatable = false)
    @Getter
    @Setter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
    @Getter
    @Setter
    private Course course;
}
