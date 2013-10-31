package mine;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 13-10-31
 * Time: 下午9:58
 * To change this template use File | Settings | File Templates.
 */
public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        int last = 1;
        for (int i=1; i<=n; i++) {
            last *= 2;
            for (int j=last/2-1; j>=0; j--) {
                list.add(list.get(j)+last/2);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        new GrayCode().grayCode(1);
    }
}
