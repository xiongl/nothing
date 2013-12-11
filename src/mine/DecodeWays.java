package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 11/1/13
 * Time: 3:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int ways = 1;
        int i = 0;
        int len = s.length();
        int current = 0;
        int before = 0;
        char c, last;
        while (i < len) {
            c = s.charAt(i);
            if (c<'0' || c>'9') {
                ways *= current;
                current = 0;
                before = 0;
            } else if (i>0) {
                last=s.charAt(i-1);
                if (c=='0' && (last<'1' && last>'2')) {
                    ways *= current;
                    current = 1;
                    last = 1;
                } else if ((last=='1') || (last=='2' && c<'7') ) {
                    int tmp = current;
                    current = before+current;
                    before = tmp;
                } else {
                    before = current;
                }
            } else if (c!='0') {
                current = 1;
                before = 1;
            }
            i++;
        }
        ways *= current;
        return ways;
    }
    public static void main(String[] args) {
        new DecodeWays().numDecodings("11");
    }
}
