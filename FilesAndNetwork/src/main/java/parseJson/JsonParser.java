package parseJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Getter
@Setter
public class JsonParser {
    private final String path;
    private final List<Map<String,String>> metroStation = new ArrayList<>();
    private final Map<String,String> infoStation = new LinkedHashMap<>();
    private String info = "";

    public JsonParser(String path) {
        this.path = path;
    }

    public void parseJsonFile()  {
        JSONParser parse = new JSONParser();

        try (FileReader fileReader = new FileReader(path)){
            JSONArray jsonArray = (JSONArray) parse.parse(fileReader);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject addres = (JSONObject) jsonArray.get(i);
                String stationName = (String) addres.get("station_name");
                String depth = (String) addres.get("depth");
                info = "station_name = " + stationName + '\n' +
                        "depth = " + depth;
                infoStation.put(stationName,depth);
                metroStation.add(infoStation);

            }
        } catch (Exception e) {
            System.out.println("Parse Error " + e.toString());

        }


    }


}
