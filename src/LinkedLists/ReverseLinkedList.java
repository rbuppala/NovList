package LinkedLists;

/*
    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;

        ListNode newNode = reversListIterative(head);

        while (newNode != null) {
            System.out.print(newNode.val);
            newNode = newNode.next;
        }
        System.out.println("");

        /*ListNode newNode1 = reverseListRecursively(head);

        while (newNode1 != null) {
            System.out.print(newNode1.val);
            newNode1 = newNode1.next;
        }*/
    }

    /*
        Reverse List Iteratively


        Assume that we have linked list 1 → 2 → 3 → Ø, we would like to change it to Ø ← 1 ← 2 ← 3.
        While you are traversing the list, change the current node's next pointer to point to its previous element.
        Since a node does not have reference to its previous node, you must store its previous element beforehand.
         You also need another pointer to store the next node before changing the reference.
         Do not forget to return the new head reference at the end!

     */
    public static ListNode reversListIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;

    }

    /*
        Reverse Linked List recursively
     */
    public static ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseListRecursively(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

}
