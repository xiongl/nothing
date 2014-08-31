package mine;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-7-8
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class MaxDigit {
    public String build(int[] arr) {
        String[] strings = new String[arr.length];
        for (int i=0; i<arr.length; i++) {
            strings[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int lenA = a.length();
                int lenB = b.length();
                int len = lenA < lenB ? lenA : lenB;
                for (int i=0; i<len; i++) {
                    char ca = a.charAt(i);
                    char cb = b.charAt(i);
                    if (ca > cb)
                        return -1;
                    if (ca < cb)
                        return 1;
                }
                if (lenA > lenB)
                    return compare(a.substring(lenB), b);
                if (lenA < lenB)
                    return compare(a, b.substring(lenA));
                return 0;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new MaxDigit().build(new int[]{1,7,12,47,161,0,9,94});
    }
}
