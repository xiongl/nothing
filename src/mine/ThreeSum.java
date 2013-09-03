package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/16/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len<3)
            return result;
        Arrays.sort(num);
        for (int i=0; i<len; i++ ) {
            if (i>0 && num[i]==num[i-1])
                continue;
            for(int j=i+1, k=len-1; j<k; ) {
                if ((j>i+1 && num[j]==num[j-1]) || (num[i]+num[j]+num[k] < 0)) {
                    j++;
                    continue;
                }
                if ((k<len-1 && num[k]==num[k+1]) || (num[i]+num[j]+num[k] > 0)) {
                    k--;
                    continue;
                }
                if (num[i]+num[j]+num[k] == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>(){};
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                    j++;
                    k--;
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{0,0,0,0});
    }
}
