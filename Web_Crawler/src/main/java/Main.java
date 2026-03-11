import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.jsoup.org/").get();
            org.jsoup.select.Elements links = doc.select("a");
            for (Element link : links) {
                System.out.println(link.attr("abs:href"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
