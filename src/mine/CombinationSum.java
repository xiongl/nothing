package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/10/13
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
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
        for ( ; start<candidates.length; start++) {
            ArrayList<Integer> newList = new ArrayList<Integer>(list);
            int curr = candidates[start];
            if (base+curr == target) {
                newList.add(curr);
                result.add(newList);
            } else if (base+curr < target) {
                newList.add(curr);
                findSum(candidates, start, base+curr, target, newList, result);
            }
        }
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{1,2}, 2);
    }
}
