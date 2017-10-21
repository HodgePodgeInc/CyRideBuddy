package hodgepodge.cyridebuddy;
import java.util.Scanner;
/**
 * Created by Ricky Faure on 10/21/2017.
 */

public class testScraper {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int userIn = s.nextInt();

        if(userIn == 1){
            WebScraper ws = new WebScraper("http://www.cyride.com/ftp/routes/Fall/sablues.html", "F2016 Saturday for PDF_23233");
        }

        else if(userIn == 2){
            WebScraper ws = new WebScraper("http://www.cyride.com/ftp/routes/Fall/sabluen.html", "F2016 Saturday for PDF_25158");
        }

        else{
            System.out.println("Bus not found");
        }
    }
}
