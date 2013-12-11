package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-11-13
 * Time: 下午9:31
 * To change this template use File | Settings | File Templates.
 */
public class SubsetTwo {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if (num.length==0)
            return result;
        Arrays.sort(num);
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(num[0]);
        current.add(first);
        for (int i=1; i<num.length; i++) {
            if (num[i]!=num[i-1]) {
                result.addAll(current);
                current = new ArrayList<ArrayList<Integer>>();
                for (ArrayList<Integer> list : result) {
                    ArrayList<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(num[i]);
                    current.add(newList);
                }
            } else {
                int size = current.size();
                ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
                for (int j=0; j<size; j++) {
                    ArrayList<Integer> list = current.get(j);
                    ArrayList<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(num[i]);
                    result.add(list);
                    tmp.add(newList);
                }
                current = tmp;
            }
        }
        result.addAll(current);
        return result;
    }
    public static void main(String[] args) {
        new SubsetTwo().subsetsWithDup(new int[]{1,1});
    }
}
