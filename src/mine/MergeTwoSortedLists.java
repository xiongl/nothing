package mine;

/**
 * Created with IntelliJ IDEA.
 * User: bjcoe
 * Date: 9/25/13
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode temp;
        if (l1.val > l2.val) {
            temp = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode head = l1;
        while (l1.next!=null && l2!=null) {
            if (l1.next.val > l2.val) {
                temp = l2.next;
                l2.next = l1.next;
                l1.next = l2;
                l2 = temp;
            } else {
                l1 = l1.next;
            }
        }
        if (l1.next==null && l2!=null)
            l1.next = l2;
        return head;
    }
    public static void main(String[] args){
         ListNode l1 = new ListNode(2);
         ListNode l2 = new ListNode(1);
         ListNode sec = new ListNode(2);
        ListNode thi = new ListNode(4);
//        l2.next=sec;
//        sec.next=thi;
        new MergeTwoSortedLists().mergeTwoLists(l1,l2);
    }
}
