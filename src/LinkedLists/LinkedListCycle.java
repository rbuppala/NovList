package LinkedLists;

/*
    Given a linked list, determine if it has a cycle in it.

    To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list
    where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */
public class LinkedListCycle {

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);

        head.next = second;
        second.next = head;
        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowNode = head;
        ListNode fastNode = head.next;

        while(slowNode !=  fastNode){
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return true;
    }
}
