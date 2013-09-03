package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/12/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromeNumber {

    public static void main (String[] args) {
        new PalindromeNumber().isPalindrome(10);
    }

    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0)
            return false;
        if (x/10 == 0)
            return true;
        int dig = 2;
        int dev = 10;
        while (x/dev >= 10) {
            dev *= 10;
            dig ++;
        }
        while (dig > 1) {
            x = x - x/dev*(dev+1);
            if (x%10 != 0)
                return false;
            x = x/10;
            dig = dig -2;
            dev = dev/100;
        }
        return true;

    }
}
