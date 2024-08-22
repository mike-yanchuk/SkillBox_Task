import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StationParse {
    private String name;
    private String line;
    private String date;
    private String depht;
    private boolean hasConnection;


    public StationParse(String name, String line,String date,String depht, boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.date = date;
        this.depht = depht;
        this.hasConnection = hasConnection;
    }
}
