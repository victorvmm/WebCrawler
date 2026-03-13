import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<WebCrawler> bots = new ArrayList<>();
        bots.add(new WebCrawler("https://www.abcnews.go.com", 1));
        bots.add(new WebCrawler("https://www.npr.org", 2));
        bots.add(new WebCrawler("https://www.nytimes.com", 3));

        for (WebCrawler crawler : bots) {
            try {
                crawler.getThread().join();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
