package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/25/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry=0;
        int len = digits.length;
        for (int i=len-1; i>=0; i--) {
            if (i==len-1)
                digits[i]++;
            digits[i] = digits[i]+carry;
            carry = digits[i]/10;
            digits[i] = digits[i]%10;
        }
        if (carry==0)
            return digits;
        else {
            int[] result = new int[len+1];
            result[0] = 1;
            for (int i=0; i<len; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
    }
}
