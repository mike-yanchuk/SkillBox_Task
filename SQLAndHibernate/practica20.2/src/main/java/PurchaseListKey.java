import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class PurchaseListKey implements Serializable {

    @Column(name = "student_name")
    private String student;

    @Column(name = "course_name")
    private String course;

}
