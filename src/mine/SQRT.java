package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/26/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class SQRT {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x<=0)
            return 0;
        int y = x;
        int i = 0;
        while (y>0) {
            y/=10;
            i++;
        }
        i=i/2+1;
        int left = 1;
        int right = 1;
        for (; i>0; i--) {
            right *= 10;
        }
        int mid;
        while (true) {
            mid = (left+right)/2;
            if ((long)mid*(long)mid == (long)x)
                return mid;
            else if ((long)mid*(long)mid < (long)x) {
                if (right-mid==1)
                    return mid;
                left = mid;
            } else {
                if (mid-left==1)
                    return left;
                right = mid;
            }
        }
    }
    public static void main(String[] args) {
        new SQRT().sqrt(2147395599);
    }
}
