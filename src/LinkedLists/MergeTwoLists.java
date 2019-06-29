package LinkedLists;

/*
    Merge Two Sorted Lists

    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String args[]) {
        ListNode head = new ListNode(0);
        ListNode second = new ListNode(1);

        head.next = second;

        ListNode head1 = new ListNode(2);
        ListNode second1 = new ListNode(3);
        head1.next = second1;

       ListNode newHead =  mergeLists(head, head1);

       while (newHead != null) {
           System.out.print(newHead.val);
           newHead = newHead.next;
       }
    }

    public static ListNode mergeLists(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) return null;

        if (node1 == null) return node2;

        if (node2 == null) return node1;

        ListNode result = new ListNode(0);

        ListNode prev = result;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                prev.next = node1;
                node1 = node1.next;
            } else {
                prev.next = node2;
                node2 = node2.next;
            }
            prev = prev.next;
        }

        if (node1 != null) {
            prev.next = node1;
        }

        if (node2 != null) {
            prev.next = node2;
        }
        return result.next;
    }
}
