package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/24/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head==null || head.next==null || n==0 )
            return head;
        ListNode curr = head;
        ListNode tail = head;
        int i = 0;
        int len = 0;
        while (true) {
            curr = curr.next;
            i++;
            if (i>n) {
                tail = tail.next;
                if (curr.next == head){
                    ListNode result = tail.next;
                    tail.next = null;
                    return result;
                }
            }
            if (curr.next == null) {
                curr.next = head;
                if (i>=n) {
                    ListNode result = tail.next;
                    tail.next = null;
                    return result;
                }
                len = i+1;
                n = n % len;
                i = 0;
                curr = head;
            }
        }

    }
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next=second;
        second.next=third;
        new RotateList().rotateRight(first, 1);
    }
}
