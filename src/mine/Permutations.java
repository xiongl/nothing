package mine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-9-12
 * Time: 下午10:31
 * To change this template use File | Settings | File Templates.
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        Integer[] number = new Integer[num.length];
        for (int i=0; i<num.length; i++) {
            number[i] = num[i];
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteOne(number, list, result);
        return result;
    }

    private void permuteOne(Integer[] num, ArrayList<Integer> list,
                            ArrayList<ArrayList<Integer>> result) {
        for (int i=0; i<num.length; i++) {
            if (num[i]!=null && (i==0 || num[i]!=num[i-1])) {
                ArrayList<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num[i]);
                if (newList.size() == num.length) {
                    result.add(newList);
                    return;
                }
                int backup = num[i];
                num[i] = null;
                permuteOne(num, newList, result);
                num[i] = backup;
            }
        }
    }

    public static void main(String[] args){
        new Permutations().permuteUnique(new int[]{1,2,3});
    }
}
