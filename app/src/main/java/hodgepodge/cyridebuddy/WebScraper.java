package hodgepodge.cyridebuddy;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Ricky Faure on 10/21/2017.
 */


public class WebScraper {
    private String pageToScrape;
    private String tableName;
    private HashMap<Integer, String> busPages;
    private HashMap<Integer, String> busTables;

    public WebScraper(){
        startupMap();
    }

    public void ScrapePage(int givenBus){
        //Get which page to scrape from hashmap.
        pageToScrape = busPages.get(givenBus);
        tableName = busTables.get(givenBus);

        System.out.println(System.getProperty("user.dir"));
        File f = new File("times/test.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(f);
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }

        Document doc = null;

        try{
           doc = Jsoup.connect(pageToScrape).get();
           System.out.println("Got it!");
        }
         catch(IOException ioe){
            ioe.printStackTrace();
        }

        Element table = doc.getElementById(tableName);
        Elements rows = table.getElementsByTag("tr");

        for(Element row: rows){
            Elements tds = row.getElementsByTag("td");
            for(int i = 0; i < tds.size(); i++){
                if (isTime(tds.get(i).text())){
                    out.print(tds.get(i).text() + "\t");
                }
            }
            out.println();
        }
        out.close();
    }

    /**
     * Sets up a map that links busses and pages to scrape.
     * 1 = Red South/West
     * 2 = Red East/West
     * 3 = Green South/West
     * 4 = Green East/North
     * 5 = Blue South
     * 6 = Blue North
     * 7 = Yellow
     * 8 = 6B Brown
     * 9 = 6A Towers/Campus
     */
    public void startupMap(){
        busPages = new HashMap<Integer, String>();
        busTables = new HashMap<Integer, String>();

        busPages.put(1,"http://www.cyride.com/ftp/routes/Fall/sareds.html");
        busPages.put(2,"http://www.cyride.com/ftp/routes/fall/sarede.html");
        busPages.put(3,"http://www.cyride.com/ftp/routes/Fall/sagreenw.html");
        busPages.put(4,"http://www.cyride.com/ftp/routes/Fall/sagreene.html");
        busPages.put(5,"http://www.cyride.com/ftp/routes/Fall/sablues.html");
        busPages.put(6,"http://www.cyride.com/ftp/routes/Fall/sabluen.html");
        busPages.put(7,"http://www.cyride.com/ftp/routes/Fall/sayellow.html");
        busPages.put(8,"http://www.cyride.com/ftp/routes/Fall/sabrownmall.html");
        busPages.put(9,"http://www.cyride.com/ftp/routes/Fall/saTowers.html");

        busTables.put(1,"F2016 Saturday for PDF_22511");
        busTables.put(2,"F2016 Saturday for PDF_16871");
        busTables.put(3,"F2016 Saturday for PDF_19028");
        busTables.put(4,"F2016 Saturday for PDF_21253");
        busTables.put(5,"F2016 Saturday for PDF_23233");
        busTables.put(6,"F2016 Saturday for PDF_25158");
        busTables.put(7,"F2016 Saturday for PDF_28476");
        busTables.put(8,"F2016 Saturday for PDF_241");
        busTables.put(9,"F2016 Saturday for PDF_31140");
    }

    public boolean isTime(String s){
        for(char c: s.toCharArray()){
            if("1234567890:-".indexOf(c) < 0)
                return false;
        }

        return true;
    }

}
