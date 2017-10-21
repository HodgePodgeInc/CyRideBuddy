package hodgepodge.cyridebuddy;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.IOException;

/**
 * Created by Ricky Faure on 10/21/2017.
 */

public class WebScraper {
  public WebScraper(String pageToScrape, String tableName){
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
              //if(i==0)
                  System.out.println(tds.get(i).text());
          }
      }
  }
}
