package mine;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-9-11
 * Time: 下午10:25
 * To change this template use File | Settings | File Templates.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num1==null || num2==null)
            return null;
        String result = "0";
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i=len1-1; i>=0; i--) {
            String mul = multi(num2, len2, Character.getNumericValue(num1.charAt(i)), len1-1-i);
            result = add(result, mul);
        }
        return result;
    }

    private String multi(String str, int len, int factor, int zeros) {
        if (factor==0 || str.equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        while (zeros>0) {
            sb.insert(0, "0");
            zeros--;
        }
        int carry = 0;
        for (int i=len-1; i>=0; i--) {
            int num = Character.getNumericValue(str.charAt(i)) * factor + carry;
            sb.insert(0, String.valueOf(num%10));
            carry = num / 10;
        }
        if (carry != 0)
            sb.insert(0, String.valueOf(carry));
        return sb.toString();
    }

    private String add(String first, String second) {
        StringBuilder sb = new StringBuilder();
        int len1 = first.length();
        int len2 = second.length();
        int len = len1 > len2 ? len1 : len2;
        int carry = 0;
        for (int i=1; i<=len; i++) {
            int one = len1 >= i ? Character.getNumericValue(first.charAt(len1-i)) : 0;
            int two = len2 >= i ? Character.getNumericValue(second.charAt(len2-i)) : 0;
            int sum = one + two + carry;
            sb.insert(0, String.valueOf(sum%10));
            carry = sum / 10;
        }
        if (carry != 0)
            sb.insert(0, String.valueOf(carry));
        return sb.toString();
    }

    public static void main(String[] args) {
        new MultiplyStrings().multiply("9133", "0");
    }
}
