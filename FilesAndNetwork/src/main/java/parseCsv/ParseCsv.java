
package parseCsv;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParseCsv {
    private String nameCity;
    private String date;
    private Map<String,String> mapCsvFile = new HashMap<>();
    private final String path;
    private String line = null;

    public ParseCsv(String path) {
        this.path = path;


    }

    public void parseCsvFile() {
        try {
            List<String> fileLine = Files.readAllLines(Paths.get(path));
            for (String s : fileLine) {
                String[] arrayString = s.split(",");

                if (line == null) {
                    line = "было";
                } else {
                    nameCity = arrayString[0];
                    date = arrayString[1];
                    mapCsvFile.put(nameCity,date);
                }

            }

        } catch (Exception e) {
            e.toString();
        }

    }

}
