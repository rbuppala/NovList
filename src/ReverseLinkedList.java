/*
Given pointer to the head node of a linked list, the task is to reverse the linked list.
We need to reverse the list by changing links between nodes.

Input: Head of following linked list
1->2->3->4->NULL
Output: Linked list should be changed to,
4->3->2->1->NULL

Input: Head of following linked list
1->2->3->4->5->NULL
Output: Linked list should be changed to,
5->4->3->2->1->NULL

 */

public class ReverseLinkedList {

    public static void main(String args[]) {
        ReverseLinkedList list = new ReverseLinkedList();
        Node node = new Node(10);
        Node node1 = new Node(20);
        Node node2 = new Node(30);

        node1.next = node2;
        node.next = node1;
        printNodes(node);
        Node headNode = reverseList(node);
        printNodes(headNode);

        Node newNode = reverseList(node);
        System.out.println("Using Recursion...");
        printNodes(headNode);
    }

    /*
    Initialize three pointers prev as NULL, curr as head and next as NULL.
    Iterate trough the linked list. In loop, do following.
    // Before changing next of current, store next node
        next = curr->next
    // Now change next of current
    // This is where actual reversing happens
        curr->next = prev

    // Move prev and curr one step forward
    prev = curr
    curr = next

    Time Complexity O(n)
    Space complexity O(1)
     */
    public static Node reverseList(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void printNodes(Node node) {
        while(node != null) {
            System.out.print(node.value+",");
            node = node.next;
        }
        System.out.println("");

    }

    /*
        Reverse linked list using Recursion
     */
    public static Node reverseListRecursive(Node head) {

        //If the head is null or there is only single element in the list
        if (head == null || head.next == null) return head;
        Node secondNode = head.next;
        head.next = null;
        // then we reverse everything from the second element on
        Node reverseRest = reverseListRecursive(secondNode);
        secondNode.next = head;
        return reverseRest;
    }
}


class Node {

    Node next;
    int value;

    public Node(int value) {
        this.value = value;
    }

}