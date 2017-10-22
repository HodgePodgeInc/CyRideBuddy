package hodgepodge.cyridebuddy;
import java.util.Scanner;
/**
 * Created by Ricky Faure on 10/21/2017.
 */

public class testScraper {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int userIn = s.nextInt();
        WebScraper ws = new WebScraper();

        if(userIn > 9 || userIn <= 0){
            return;
        }

        ws.ScrapePage(userIn);
    }
}
