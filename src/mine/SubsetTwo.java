package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 11/13/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubsetTwo {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        ArrayList<Integer> first = new ArrayList<Integer>();
        result.add(first);
        boolean duplicate;
        int len;
        for (int i=0; i<num.length; i++) {
            if (i!=0 && num[i] == num[i-1])
                duplicate = true;
            else
                duplicate = false;
            len = result.size();
            for (int j=0; j<len; j++) {
                ArrayList<Integer> list = result.get(j);
                if (!duplicate || (list.size()==0 && num[i]!=num[i-1]) || (list.size()!=0 && list.get(list.size()-1)==num[i])) {
                    ArrayList<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(num[i]);
                    result.add(newList);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        new SubsetTwo().subsetsWithDup(new int[]{1,1});
    }
}
