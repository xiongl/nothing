package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 11/15/13
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestoreIPAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int len = s.length();
        String a, b, c, d;
        int startA, startB, startC, startD, endA, endB, endC;
        startA = 0;
        ArrayList<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (endA=startA+1; endA<len-9; endA++) {
            a = s.substring(startA, endA+1);
            if(isValid(a)) {
                sb.append(a);
                sb.append(".");
                startB = endA+1;
                for (endB=startB+1; endB<len-6; endB++) {
                    b=s.substring(startB, endB+1);
                    if (isValid(b)){
                        sb.append(b);
                        sb.append(".");
                        startC = endB+1;
                        for (endC=startC+1; endC<len-6; endC++) {
                            c=s.substring(startC, endC+1);
                            if (isValid(c)){
                                sb.append(c);
                                sb.append(".");
                                startD = endC+1;
                                d = s.substring(startD, len);
                                if (isValid(d)) {
                                    list.add(sb.toString());
                                }
                                sb.delete(0, sb.length());
                            } else {
                                sb.delete(0, sb.length());
                            }
                        }
                    } else {
                        sb.delete(0, sb.length());
                    }
                }
            } else {
                sb.delete(0, sb.length());
            }
        }
        return list;
    }

    private boolean isValid(String a) {
        try {
            int num = Integer.valueOf(a);
            if (num<0 || num>255) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new RestoreIPAddress().restoreIpAddresses("0000");
    }
}
