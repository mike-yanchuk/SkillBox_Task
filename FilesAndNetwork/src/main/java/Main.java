import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String path = "C:\\Skillbox\\NewStart 24.06.24\\NewStartFullPracticval\\19Restart\\FilesAndNetwork\\filesJson";
    public static void main(String[] args) throws IOException {

        ParseHtmlFile parseHtmlFile = new ParseHtmlFile();


//        JsonParseFile jsonParseFile = new JsonParseFile();
//        jsonParseFile.parseJsonFile(); // запись в файл


        ParseFullInformation parseFullInformation = new ParseFullInformation();
        parseFullInformation.parseJson();



//        String json = "fullInformation.json";
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(new File(json), parseHtmlFile);







//
//        SearchForFormatFilesJsonOrCsv searchForFormatFilesJsonOrCsv = new SearchForFormatFilesJsonOrCsv(path);
//        for (Map.Entry<String,String> e : searchForFormatFilesJsonOrCsv.getMap().entrySet()) {
//            System.out.println("Ключ = " + e.getKey());
//            System.out.println("Значение = " + e.getValue());
//        } // информация csv

        SearchForFormatFilesJsonOrCsv searchForFormatFilesJsonOrCsv = new SearchForFormatFilesJsonOrCsv(path);

//        for (String infoPath : searchForFormatFilesJsonOrCsv.getFilePath()) {
//            System.out.println(infoPath);
//        } // вывод путей файлов json and csv

//        for (List<Map<String, String>> info : searchForFormatFilesJsonOrCsv.getJsonParse()) {
//            for (Map<String, String> mapa : info) {
//                for (Map.Entry<String, String> map : mapa.entrySet()) {
//                    System.out.println(map.getKey() + ' ' + map.getValue());
//                }
//            }
//        } // информация json



//        for (List<String> fori : parseHtmlFile.getGetlistLineStation()) {
//
//            for (String fori1 : fori) {
//                System.out.println(fori1);
//
//            }
//        } // вывод станций

    }






}





