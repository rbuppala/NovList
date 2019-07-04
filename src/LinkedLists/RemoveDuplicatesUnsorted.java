package LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUnsorted {

    public static void main(String args[]) {
       ListNode head = new ListNode(1);
       ListNode second = new ListNode(3);
       ListNode third = new ListNode(1);
       ListNode fourth = new ListNode(3);
       ListNode fifth = new ListNode(5);


       head.next = second;
       second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        removeDuplicatesTwo(head);

       while (head != null) {
           System.out.println(head.val);
           head = head.next;
        }


    }

    public static void removeDuplicates(ListNode head) {
        ListNode prev = null;
        Set<Integer> dataSet = new HashSet<>();

        while (head != null) {
            if(dataSet.contains(head.val)) {
                prev.next = head.next;
            } else {
                dataSet.add(head.val);
                prev = head;
            }
            head = head.next;
        }

    }

    public static void removeDuplicatesTwo(ListNode head) {
        ListNode current = head;

        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
