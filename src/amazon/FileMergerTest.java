package amazon;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-7-23
 * Time: 下午10:08
 * To change this template use File | Settings | File Templates.
 */
public class FileMergerTest extends TestCase {
    FileMerger merger = new FileMerger();

    /*
    1.log
    test,www.amazon.com,20140723120001
    test,www.amazon.com/abc,20140723140001

    2.log
    test,www.amazon.com/cctv,20140723130001

    wrong.log
    wrongtdfadf
    */

    @Test
    public void testMerge() throws IOException {
        File[] files = new File[2];
        files[0] = new File("/tmp/1.log");
        files[1] = new File("/tmp/2.log");
        File output = new File("/tmp/output.log");
        merger.mergeFile(files, output);
        String[] dates = new String[3];
        readDate(output, dates);
        Assert.assertTrue(dates[0].compareTo(dates[1])==-1 && dates[1].compareTo(dates[2])==-1);
    }

    @Test
    public void testWithInvalidFile() throws IOException {
        File[] files = new File[2];
        files[0] = new File("/tmp/1.log");
        files[1] = new File("/tmp/wrong.log");
        File output = new File("/tmp/output.log");
        merger.mergeFile(files, output);
        String[] dates = new String[3];
        readDate(output, dates);
        Assert.assertTrue(dates[0].compareTo(dates[1])==-1);
    }

    private void readDate(File output, String[] dates) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(output));
        String line;
        int i=0;
        while ((line=reader.readLine()) != null) {
            dates[i++] = line.split(",")[2];
        }
    }
}
