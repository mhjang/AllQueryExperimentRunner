package main.java;

/**
 * Created by mhjang on 8/28/15.
 */
public class MergeResult {
    public static void main(String[] args) {
        try {
            SimpleFileReader sr = new SimpleFileReader("all");
            String docid = null;
            int rank = 1;
            SimpleFileWriter sw = new SimpleFileWriter("allqueryexp.txt");
            while (sr.hasMoreLines()) {
                String line = sr.readLine();
                if (line.contains("qid:")) {
                    docid = line.substring(60, line.length()).replace(".html", "");
                    rank = 1;
                } else
                    //  sw.writeLine(docid + "\t" + "0\t" + line.replace(".html","") + "\t" + rank++ + "20\t allterms\n");
                    sw.writeLine(docid + "\t" + "0\t" + line.replace(".html", "") + "\t" + rank++ + "\t20\t allterms");


            }
            sw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
