package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/25/13
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a==null || a.length()==0)
            return b;
        if (b==null || b.length()==0)
            return a;
        int lenA = a.length();
        int lenB = b.length();
        int n = 1;
        int carry = 0;
        int charA, charB, sum;
        int len = (lenA > lenB ? lenA : lenB) + 1;
        char[] result = new char[len];
        while (n<=len) {
            charA = lenA>=n ? a.charAt(lenA-n) - '0' : 0;
            charB = lenB>=n ? b.charAt(lenB-n) - '0' : 0;
            sum = charA+charB+carry;
            if (sum>=2) {
                carry = 1;
                sum -= 2;
            } else {
                carry = 0;
            }
            result[len-n] = (char) (sum+'0');
            n++;
        }
        String str = new String(result);
        if (str.charAt(0)=='0')
            return str.substring(1);
        else
            return str;
    }
    public static void main(String[] args){
        new AddBinary().addBinary("0", "0");
    }
}
