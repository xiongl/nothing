package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/18/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len<4)
            return result;
        Arrays.sort(num);
        for (int n=len-1; n>=3; n--) {
            if (n<len-1 && num[n]==num[n+1])
                continue;
            for (int i=0; i<n-2; i++ ) {
                if (i>0 && num[i]==num[i-1])
                    continue;
                for(int j=i+1, k=n-1; j<k; ) {
                    if ((j>i+1 && num[j]==num[j-1]) || (num[i]+num[j]+num[k]+num[n] < target)) {
                        j++;
                        continue;
                    }
                    if ((k<n-1 && num[k]==num[k+1]) || (num[i]+num[j]+num[k]+num[n] > target)) {
                        k--;
                        continue;
                    }
                    if (num[i]+num[j]+num[k]+num[n] == target) {
                        ArrayList<Integer> list = new ArrayList<Integer>(){};
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[n]);
                        result.add(list);
                        j++;
                        k--;
                        continue;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{0,0,0,0}, 0);
    }
}
