import HtmlFile.StationParseHtml;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParseFile {
    public void parseJsonFile() throws IOException {


        String json = "ParseHtmlToJson\\htmlMetro.json";



        ParseHtmlFile parseHtmlFile = new ParseHtmlFile();
        StationParseHtml stationParseHtml = new StationParseHtml(parseHtmlFile.getLine());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(json), stationParseHtml);





    }
}
