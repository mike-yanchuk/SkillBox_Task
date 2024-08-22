import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.*;

@Getter
public class ParseHtmlFile {
    int count = 0;
    private List<String> listName = new ArrayList<>();
    private List<String> listLine = new ArrayList<>();
    private List<String> transition = new ArrayList<>();
    private List<String> getlistStaion = new ArrayList<>();
    private List<List<String>> getlistLineStation = new ArrayList<>();
    private Map<String, String[]> line = new LinkedHashMap<>();


    private final String URL = "https://skillbox-java.github.io/";

    private Document parseHtml() throws IOException {
        var page = Jsoup.parse(new URL(URL), 3000);
        return page;
    }

    public ParseHtmlFile() throws IOException {
        gettingFile();
    }

    public void gettingFile() throws IOException {
        List<String> listStaion = new ArrayList<>();
        List<String> listFileNameStation = new ArrayList<>();
        List<String> listFileNameLine = new ArrayList<>();
        List<String> listFileTransition = new ArrayList<>();


        List<List<String>> listLineStation = new ArrayList<>();
        Document doc = parseHtml();
        Elements tableStation = doc.select("div.js-depend");


        Elements nameLine = doc.select("div.js-toggle-depend.s-depend-control-single"); // имена линий

        Elements numberLine = doc.select("span.js-metro-line"); // номера линий

        Elements numberStation = tableStation.select("span.num");// number Station

        Elements nameStation = tableStation.select("span.name"); // nameStation

        String station;
        for (int i = 0; i < nameLine.size(); i++) {
            station = "";
            String numberLineFor = numberLine.get(i).attr("data-line");
            String nameLineFor = nameLine.get(i).text();
            Elements elementsName1 = tableStation.get(i).select("span.name");
            Elements elementsNumber1 = tableStation.get(i).select("span.num");
            String[] name = new String[tableStation.get(i).select("span.num").size()];
            for (int j = 0; j < tableStation.get(i).select("span.num").size(); j++) {

                String numberStationFor = elementsNumber1.get(j).text();
                String nameStationFor = elementsName1.get(j).text();
                listStaion.add(nameStationFor);
                listFileNameStation.add(nameStationFor);
                listFileNameLine.add(nameLineFor);
                name[j] = nameStationFor;
                Elements elements = tableStation.get(i).select("p.single-station");
                try {
                    Elements elementsTr = elements.get(j).select("span.t-icon-metroln");
                    String transition = "";
                    listFileTransition.add((elementsTr.size() < 1 ? "false" : "true"));

                    for (int k = 0; k < elementsTr.size(); k++) {

                        String stationTransition = elementsTr.get(k).attr("title");

                        transition += stationTransition + (k == elementsTr.size() ? "" : "\n" + "\t");



                    }

                    station += nameStationFor + '\n' + '\t' + transition + (j == tableStation.get(i).select("span.num").size() - 1 ? "" : '\n');


                } catch (Exception e) {

                }

                line.put(numberLineFor, name);
            }
            //System.out.println(station);


        }
        listName = listFileNameStation;
        System.out.println(listName.size());
        listLine = listFileNameLine;
        this.transition = listFileTransition;


        getlistLineStation = listLineStation;
        getlistStaion = listStaion;

    }
}
