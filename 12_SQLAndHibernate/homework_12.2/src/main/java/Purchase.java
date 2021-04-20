import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class Purchase {
    @EmbeddedId
    private PurchaseKey id;

    @Column(name = "student_name", insertable = false, updatable = false)
    @Getter
    @Setter
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    @Getter
    @Setter
    private String courseName;

    @Column(name = "price")
    @Getter
    @Setter
    private Integer price;

    @Column(name = "subscription_date")
    @Getter
    @Setter
    private Date subscriptionDate;
}
