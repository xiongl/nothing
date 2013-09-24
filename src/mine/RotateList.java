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
        boolean connected = false;
        while (true) {
            curr = curr.next;
            i++;
            if (curr.next == null) {
                curr.next = head;
                connected = true;
                if (i>n) {
                    ListNode result = tail.next;
                    tail.next = null;
                    return result;
                }
                n = n % (i+1);
                i = 0;
            }
            if (i>n) {
                tail = tail.next;
                if (connected){
                    ListNode result = tail.next;
                    tail.next = null;
                    return result;
                }
            }
        }

    }
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next=second;
        new RotateList().rotateRight(first, 1);
    }
}
