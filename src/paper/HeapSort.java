package paper;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-8-31
 * Time: 下午6:42
 * To change this template use File | Settings | File Templates.
 */
public class HeapSort {
    public void heapSort(int[] num) {
        buildHeap(num, num.length);
        for (int i=num.length-1; i>0; i--) {
            int temp = num[i];
            num[i] = num[0];
            num[0] = temp;
            adjustHeap(num, 0, i);
        }
    }
    private void buildHeap(int[] num, int length) {
        for (int i=(length-1)/2; i>=0; i--) {
            adjustHeap(num, i, length);
        }
    }
    private void adjustHeap(int[] num, int root, int length) {
        int temp = num[root];
        int child = root*2+1;
        while (child < length) {
            if (child+1<length && num[child]<num[child+1])
                child++;
            if (num[root] < num[child]) {
                num[root] = num[child];
                root = child;
                child = root*2+1;
            } else {
                break;
            }
            num[root] = temp;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,5,7,2,4,9,6,8,3};
        new HeapSort().heapSort(num);
        for (int n : num) {
            System.out.print(n);
            System.out.print(",");
        }
    }
}
