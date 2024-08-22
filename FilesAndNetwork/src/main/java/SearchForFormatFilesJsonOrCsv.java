import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import parseCsv.ParseCsv;
import parseJson.JsonParser;
import parseJson.Station;

import java.io.File;
import java.util.*;

@Getter
@Setter
public class SearchForFormatFilesJsonOrCsv {
    private final List<String> filePath = new ArrayList<>();
    private final List<List<Map<String,String>>> jsonParse = new ArrayList<>();
    private List<Map<String,String>> map1 = new ArrayList<>();
    private String listLine = "";
    public final String path;

    public SearchForFormatFilesJsonOrCsv(String path) throws JsonProcessingException {
        this.path = path;
        File file = new File(path);
        getFiles(file);
    }


    public String returnStringForList(){
        filePath.forEach(line -> listLine += line + (filePath.get(filePath.size() - 1).equals(line) ? "" : '\n'));
        return listLine;
    }

    public void getFiles(File file) throws JsonProcessingException {
        Map<String,String> map = new HashMap<>();
        if (file.isFile()) {
            if ((file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1)).equals("json")) {
                filePath.add(file.getAbsolutePath());
                JsonParser jsonParser = new JsonParser(file.getAbsolutePath());
                jsonParser.parseJsonFile();
                jsonParse.add(jsonParser.getMetroStation());
            } else if((file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1)).equals("csv")){
                System.out.println(file.getAbsolutePath());
                filePath.add(file.getAbsolutePath());
                ParseCsv parseCsv = new ParseCsv(file.getAbsolutePath());
                parseCsv.parseCsvFile();
                map = parseCsv.getMapCsvFile();
                map1.add(map);


            }
        }

        try {
            File[] files = file.listFiles();
            for (File file1 : files) {

                if (file.isFile()) {
                    if ((file1.getAbsolutePath().substring(file1.getAbsolutePath().lastIndexOf('.') + 1)).equals("json") ||
                            (file1.getAbsolutePath().substring(file1.getAbsolutePath().lastIndexOf('.') + 1)).equals("csv")) {

                        filePath.add(file1.getAbsolutePath());

                    }
                } else getFiles(file1);

            }
        } catch (NullPointerException e) {

        }
    }
}
