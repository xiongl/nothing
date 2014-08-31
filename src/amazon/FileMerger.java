package amazon;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-7-23
 * Time: 下午10:07
 * To change this template use File | Settings | File Templates.
 */
public class FileMerger {
    private static final Logger logger = Logger.getLogger(FileMerger.class);
    public void mergeFile(File[] files, File output) {
        TreeSet<Record> set = new TreeSet<Record>(new Comparator<Record>() {
            @Override
            public int compare(Record record, Record record2) {
                return record.date.compareTo(record2.date);
            }
        });
        for (int i=0; i<files.length; i++) {
            merge(set, files[i]);
        }
        outputResult(set, output);
    }

    private void merge(TreeSet<Record> set, File file) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line=br.readLine())!=null) {
                String[] row = line.split(",");
                if (row.length!=3)
                    continue;
                Record record = new Record(row[0], row[1], row[2]);
                set.add(record);
            }
        } catch (Exception e) {
            logger.error("fail to process file "+file.getName(), e);
        } finally {
            if (br!=null)
                try {
                    br.close();
                } catch (IOException e) {
                    logger.error("fail to close BufferedReader", e);
                }
        }
    }


    private void outputResult(TreeSet<Record> set, File output) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(output, false));
            for (Record record : set) {
                bw.append(record.user);
                bw.append(",");
                bw.append(record.url);
                bw.append(",");
                bw.append(record.date);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            logger.error("fail to write to output", e);
        } finally {
            if (bw !=null )
                try {
                    bw.close();
                } catch (IOException e) {
                    logger.error("fail to close BufferedReader", e);
                }
        }
    }
}

class Record {
    String user;
    String url;
    String date;
    public Record(String user, String url, String date) {
        this.user = user;
        this.url = url;
        this.date = date;
    }
}
