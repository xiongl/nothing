package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/28/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num==null)
            return;
        int len = num.length;
        if(len < 2)
            return;
        int i=len-1;
        while(i-1>=0 && num[i]<=num[i-1])
            i--;
        int temp;
        int pos = len-1;

        int compare = num[0];
        if (i>0)
            compare = num[i-1];
        for (int j=i, k=len-1 ; k>j; ){
            temp = num[j];
            num[j] = num[k];
            num[k] = temp;
            if (num[k]>compare && pos>k)
                pos = k;
            if (num[j]>compare && pos>j)
                pos = j;
            j++;
            k--;
        }
        if (i>0) {
            temp = num[pos];
            num[pos] = num[i-1];
            num[i-1] = temp;
        }

    }
    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1,2,3});
    }
}
