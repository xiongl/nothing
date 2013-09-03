package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/11/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringToInt {
    public static void main(String[] args) {
        new StringToInt().atoi("    +0a32");
    }

    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str.length() == 0)
            return 0;
        char cha;
        boolean neg = false;
        boolean sign = false;
        int pos = 0;
        double result = 0;

        while (pos < str.length()) {
            cha = str.charAt(pos++);
            if (!isValid(cha)) {
                if (cha == ' ' && result == 0 && !sign)
                    continue;
                break;
            }
            if (cha == '-') {
                if (!isDigit(str.charAt(pos)))
                    return 0;
                neg = true;
                sign = true;
            } else if (cha == '+') {
                if (!isDigit(str.charAt(pos)))
                    return 0;
                neg = false;
                sign = true;
            } else {
                result = 10 * result + cha - '0';
            }
            if (!neg && result > 2147483647)
                return 2147483647;
            if (neg && result < -2147483648)
                return -2147483648;
        }
        if (neg)
            result = 0 - result;
        return (int) result;

    }

    public boolean isValid(char cha) {
        if ((cha < '0' || cha > '9') && cha != '-' && cha != '+')
            return false;
        return true;
    }

    public boolean isDigit(char cha) {
        if (cha < '0' || cha > '9')
            return false;
        return true;
    }
}
