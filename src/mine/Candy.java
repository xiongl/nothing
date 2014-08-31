package mine;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-6-28
 * Time: 下午10:37
 * To change this template use File | Settings | File Templates.
 */
public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] c = new int[len];
        c[0] = 1;
        for (int i=1; i<len; i++) {
            if (ratings[i] > ratings[i-1])
                c[i] = c[i-1] + 1;
            else
                c[i] = 1;
        }
        int sum = c[len-1];
        for (int i=len-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1])
                c[i] = c[i] > c[i+1]+1 ? c[i] : c[i+1]+1;
            sum += c[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        new Candy().candy(new int[]{2,1});
    }
}
