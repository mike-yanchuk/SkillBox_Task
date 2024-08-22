import java.util.ArrayList;
import java.util.List;

public class StationJson {
    private final List<StationJson> station = new ArrayList<>();
    private String name;
    private String line;
    private String date;
    private String depth;
    private boolean hasConnection;

    public StationJson(String name, String line, String date, String depth, boolean hasConnection) {
        this.name = name;
        this.line = line;
        this.date = date;
        this.depth = depth;
        this.hasConnection = hasConnection;
        station.add(this);
    }
}
