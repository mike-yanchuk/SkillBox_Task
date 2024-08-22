import HtmlFile.StationParseHtml;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParseFullInformation {
    List<StationParse> station = new ArrayList<>();
    public final String path = "C:\\Skillbox\\NewStart 24.06.24\\NewStartFullPracticval\\19Restart\\FilesAndNetwork\\filesJson";


    public void parseJson() throws IOException {
        ParseHtmlFile parseHtmlFile = new ParseHtmlFile();
        List<String> name = parseHtmlFile.getListName();
        List<String> line = parseHtmlFile.getListLine();
        List<String> transition = parseHtmlFile.getTransition();
        SearchForFormatFilesJsonOrCsv searchForFormatFilesJsonOrCsv = new SearchForFormatFilesJsonOrCsv(path);

        for (int i = 0; i < name.size(); i++) {
            String data = "";
            String depth = "";
            for (List<Map<String, String>> info : searchForFormatFilesJsonOrCsv.getJsonParse()) {
                for(Map<String,String> mapa : info) {
                    depth = mapa.get(name.get(i));
                }
            }
            for (int j = 0; j < searchForFormatFilesJsonOrCsv.getMap1().size(); j++) {
                data = searchForFormatFilesJsonOrCsv.getMap1().get(j).get(name.get(i));

            }
            StationParse stationParse = new StationParse(name.get(i),line.get(i),data,depth,(transition.get(i).equals("true")));

            station.add(stationParse);
        }


        Map<String,List<StationParse>> map = new LinkedHashMap<>();
        map.put("station", station);
        String json = "ParseHtmlToJson\\fullInformation.json";




        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(json), map);

    }


}






        //        for (List<Map<String,String>> name : searchForFormatFilesJsonOrCsv.getJsonParse()){
//            for (Map<String,String> name1: name) {
//                for (Map.Entry<String,String> e : name1.entrySet()) {
//                    System.out.println("name: " + e.getKey() + "\n" + "value: " + e.getValue() );
//                }
//            }
//        }








