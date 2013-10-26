package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 10/2/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int len = S.length;
        int curr = 0;
        next(result, list, curr, len, S);
        return result;
    }
    private void next(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
                      int curr, int len, int[] S) {
        result.add(list);
        for (int i=curr; i<len; i++) {
            ArrayList<Integer> newList = new ArrayList<Integer>(list);
            newList.add(S[i]);
            next(result, newList, i+1, len, S);
        }
    }
}
