package LinkedLists;

/*
   You are given two non-empty linked lists representing two non-negative integers.
   The digits are stored in reverse order and each of their nodes contain a single digit.
   Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String args[]) {
        ListNode list1 = new ListNode(2);
        ListNode list12 = new ListNode(4);
        ListNode list13 = new ListNode(3);
        list1.next = list12;
        list12.next = list13;

        ListNode list2 = new ListNode(5);
        ListNode list22 = new ListNode(6);
        ListNode list23 = new ListNode(4);
        list2.next = list22;
        list22.next = list23;

        ListNode result = addTwoNumbers(list1,list2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode d = dummyNode;

        ListNode c1 = l1;
        ListNode c2 = l2;

        int sum = 0;

        while (c1 != null || c2 != null) {
            sum /= 10;

            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }

            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d . next;
        }
        if (sum / 10 ==1) {
            d.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
