package mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/18/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        int len = num.length;
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int a=0; a<=len-4; ) {
            for (int b=len-1; b>=a+3; ) {
                for (int left=a+1, right=b-1; right>left; ) {
                    if (num[a]+num[b]+num[left]+num[right]==target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(num[a]);
                        list.add(num[left]);
                        list.add(num[right]);
                        list.add(num[b]);
                        result.add(list);
                        while (left<right && num[left]==num[++left]);
                        while (left<right && num[right]==num[--right]);
                    } else if (num[a]+num[b]+num[left]+num[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
                while(b>=a+3 && num[b]==num[--b]);
            }
            while (a<=len-4 && num[a]==num[++a]);

        }
        return result;
    }

    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 4);
    }
}
