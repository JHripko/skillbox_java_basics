import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    @Getter
    @Setter
    private SubscriptionKey id;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @Getter
    @Setter
    private Course course;

    @Column(name = "subscription_date", insertable = false, updatable = false)
    @Getter
    @Setter
    private Date subscriptionDate;

}
