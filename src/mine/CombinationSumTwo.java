package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/10/13
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSumTwo {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        findSum(candidates, 0, 0, target, list, result);
        return result;
    }

    private void findSum(int[] candidates, int start, int base, int target,
                         ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        int begin = start;
        for ( ; start<candidates.length; start++) {
            int curr = candidates[start];
            if (start>begin && curr==candidates[start-1])
                continue;
            ArrayList<Integer> newList = new ArrayList<Integer>(list);
            if (base+curr == target) {
                newList.add(curr);
                result.add(newList);
            } else if (base+curr < target) {
                newList.add(curr);
                findSum(candidates, start+1, base+curr, target, newList, result);
            }
        }
    }
}
