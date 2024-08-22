package HtmlFile;

import lombok.Getter;
import org.jsoup.nodes.Element;

import java.util.*;
@Getter
public class StationParseHtml {
    private final Map<String,String[]> stations;
    public StationParseHtml(Map<String,String[]> stations) {
        this.stations = stations;
    }
}
