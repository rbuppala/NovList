package LinkedLists;

/*
    Given a singly linked list, delete middle of the linked list.
    For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
 */
public class DeleteMiddleNode {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        deleteMiddleNode(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static void deleteMiddleNode(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        ListNode prevNode = null;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            prevNode = slowNode;
            slowNode = slowNode.next;
        }
        prevNode.next = slowNode.next;

    }
}
