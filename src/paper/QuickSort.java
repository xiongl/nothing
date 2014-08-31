package paper;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-8-31
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {
    public void quickSort(int[] num) {
        quickSort(num, 0, num.length-1);
    }
    private void quickSort(int[] num, int start, int end) {
        int partition = getPartition(num, start, end);
        if (start < partition-1)
            quickSort(num, start, partition-1);
        if (end > partition+1)
            quickSort(num, partition+1, end);
    }
    private int getPartition(int[] num, int start, int end) {
        int pivot = num[end];
        while (start < end) {
            while (start<end && num[start]<=pivot)
                start++;
            num[end] = num[start];
            while (start<end && num[end]>pivot)
                end--;
            num[start] = num[end];
        }
        num[start] = pivot;
        return start;
    }
    public static void main(String[] args) {
        int[] num = new int[]{1,4,7,9,2,5,6,3,8};
        new QuickSort().quickSort(num);
        for (int n : num) {
            System.out.print(n);
            System.out.print(",");
        }
    }
}
