import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionKey subscriptionKey;

    @Id
    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


}
