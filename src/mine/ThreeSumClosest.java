package mine;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/17/13
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = 0;
        int len = num.length;
        if (len<3)
            return sum;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i=0; i<len; i++) {
            if (i>0 && num[i]==num[i-1])
                continue;
            for (int j=i+1, k=len-1; j<k; ) {
                if (j>i+1 && num[j]==num[j-1]){
                    j++;
                    continue;
                }
                if (k<len-1 && num[k]==num[k+1]){
                    k--;
                    continue;
                }
                int currSum = num[i]+num[j]+num[k];
                if (currSum > target)
                    k--;
                if (currSum < target)
                    j++;
                int currDiff = Math.abs(currSum - target);
                if (currDiff < diff) {
                    diff = currDiff;
                    sum = currSum;
                }
                if (diff == 0)
                    return sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        new ThreeSumClosest().threeSumClosest(new int[]{1,1,1,0}, 100);
    }
}
