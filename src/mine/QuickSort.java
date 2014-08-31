package mine;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-7-8
 * Time: 下午9:04
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {
    public void sort(int[] arr) {
        //quickSort(arr, 0, arr.length-1);
        quickSortNoRecursive(arr);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pos = partition(arr, start, end);
            quickSort(arr,start,pos-1);
            quickSort(arr,pos+1,end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start<end) {
            while (start<end && pivot<=arr[end])
                end--;
            arr[start] = arr[end];
            while (start<end && pivot>arr[start])
                start++;
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }

    private void quickSortNoRecursive(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(end);
        stack.push(start);
        while (!stack.empty()) {
            start = stack.pop();
            end = stack.pop();
            int pos = partition(arr, start, end);
            if (pos-1>start) {
                stack.push(pos-1);
                stack.push(start);
            }
            if (pos+1<end) {
                stack.push(end);
                stack.push(pos+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,9,2,4,7,14,3};
        new QuickSort().sort(arr);
        System.out.print("");
    }
}
