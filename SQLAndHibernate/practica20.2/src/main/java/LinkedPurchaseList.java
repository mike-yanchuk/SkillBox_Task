import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class LinkedPurchaseList {


    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;


}
