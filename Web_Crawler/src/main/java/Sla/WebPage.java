package Sla;

import com.sun.tools.javac.Main;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebPage {
    private final Anchor anchor;
    private String webPageHash;
    private int anchorParseStatus;
    private int emailParseStatus;
    private Document html;

    public WebPage(Anchor anchor) {
        this.anchor = anchor;
    }

    private void loadDocumentFromWeb(){
        try {
            Document doc = Jsoup.connect(anchor.getAnchorUrl()).get();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
