package LinkedLists;

/*
    Remove all elements from a linked list of integers that have value val.

    Example:

    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
 */
public class RemoveElements {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        head.next = second;
        second.next = third;

        ListNode newHead = removeElementsRecursive(head, 2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode current = head;

        if (current.val == val) {
            head = head.next;
            return head;
        }

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public static ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElementsRecursive(head.next,val);
        return head.val == val ? head.next : head;
    }
}
