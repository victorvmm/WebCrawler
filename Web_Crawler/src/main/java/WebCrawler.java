import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WebCrawler implements Runnable{
    private static final int MAX_DEPTH = 3;
    public static Set<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
    private Thread thread;
    private String firstLink;
    private int ID;

    public WebCrawler(String firstLink, int num) {
        this.firstLink = firstLink;
        this.ID = num;

        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        crawl(0, firstLink);
    }

    private void crawl(int level, String url){
        if (level <= MAX_DEPTH){
            Document doc = request(url);
            if (doc != null){
                for (Element link : doc.select("a[href]")){
                    String nextlink = link.absUrl("href");
                    if (!visitedLinks.contains(nextlink)){
                        crawl(level+1, nextlink);
                    }
                }
            }
        }
    }

    private Document request(String url){
        try {
            Connection connection = Jsoup.connect(url);
            Document doc = connection.get();
            if (connection.response().statusCode() == 200){
                System.out.println("\n**Bot ID: " + ID + " Received webpage at: " + url);
                String title = doc.title();
                System.out.println(title);
                visitedLinks.add(url);
                return doc;
            }
            return null;

        } catch (IOException e){
            return  null;
        }
    }

    public Thread getThread() {
        return thread;
    }

    public String getFirstLink() {
        return firstLink;
    }

    public Set<String> getVisitedLinks() {
        return visitedLinks;
    }

    public int getID() {
        return ID;
    }
}
