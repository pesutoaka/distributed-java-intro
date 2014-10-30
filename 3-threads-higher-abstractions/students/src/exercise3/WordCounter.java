package exercise3;

import common.StringUtils;
import common.html.GazetaHtmlDocument;
import common.html.HtmlDocument;
import java.util.concurrent.Callable;

public class WordCounter implements Callable<Integer>{

    private final String documentUrl;
    private final String wordToCount;

    public WordCounter(String documentUrl, String wordToCount) {
        this.documentUrl = documentUrl;
        this.wordToCount = wordToCount;
    }
    
    /**
     *
     * @return
     */
    public Integer call(){
        HtmlDocument hd = new GazetaHtmlDocument(documentUrl);
        return StringUtils.countOccurrences(hd.getContent().toLowerCase(), wordToCount);
    }
}
