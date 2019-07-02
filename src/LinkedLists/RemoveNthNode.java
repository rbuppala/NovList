package LinkedLists;

/*
    Given a linked list, remove the n-th node from the end of list and return its head.

    Example:

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
    Note:

    Given n will always be valid.
 */
public class RemoveNthNode {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        head.next = second;
        second.next = third;

        ListNode newHead = removeNthFromEnd(head,1);

        while(newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    /*
        Time complexity O(n)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n +1;i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return dummy.next;
    }
}
