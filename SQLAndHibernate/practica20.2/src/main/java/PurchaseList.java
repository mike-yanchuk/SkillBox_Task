import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey purchaseListKey;

    @Id
    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;
    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

}
