package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 8/18/13
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = 0;
        ListNode curr = head;
        ListNode remove = null;
        while (curr.next != null) {
            curr = curr.next;
            m++;
            if(m==n){
                remove = head;
            } else if(m>n){
                remove = remove.next;
            }
        }
        if (m<n)
            head = head.next;
        if(remove!=null && remove.next!=null) {
            remove.next = remove.next.next;
        }
        return head;
    }
}
