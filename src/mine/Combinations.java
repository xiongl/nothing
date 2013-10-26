package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/2/13
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int curr = 0;
        int level = 0;
        next(result, list, curr, n, level, k);
        return result;
    }

    private void next(ArrayList<ArrayList<Integer>> result,
                      ArrayList<Integer> list, int last, int n, int level, int k) {
        level++;

        for (int i=last+1; i<=n-k+level; i++) {
            ArrayList<Integer> newList = new ArrayList<Integer>(list);
            newList.add(i);
            if (level == k) {
                result.add(newList);
            } else {
                next(result, newList, i, n, level, k);
            }
        }
    }
}
