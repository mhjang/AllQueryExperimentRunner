import utils.SimpleFileReader;
import utils.SimpleFileWriter;
import org.lemurproject.galago.core.retrieval.ScoredDocument;

import java.io.IOException;
import java.util.List;

/**
 * Created by mhjang on 8/25/2015.
 */
public class AllTermQueryExperiment {
    public static void main(String[] args) {
        String filepath = args[0];
        WikiRetrieval wr = new WikiRetrieval();
        try {
            SimpleFileReader sr = new SimpleFileReader(filepath);
            StringBuilder sb = new StringBuilder();
            while(sr.hasMoreLines()) {
                sb.append(sr.readLine());
            }
            List<ScoredDocument> docs = (List<ScoredDocument>) wr.runQuery(sb.toString());
            String filename = filepath.substring(filepath.lastIndexOf("\\")+1);
            SimpleFileWriter sw = new SimpleFileWriter(filename + ".rankedlist");
            sw.writeLine("qid: " + filename.substring(filename.lastIndexOf("\\")+1));
            for(ScoredDocument sd : docs) {
                sw.writeLine(sd.documentName);
                System.out.println(sd.documentName);
            }
            sw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
