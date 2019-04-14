package linkedlist;

import static linkedlist.SinglyLinkedList.forwardTraversal;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.withNext(new ListNode(1)).withNext(new ListNode(2));
        deleteDuplicates(head);
        forwardTraversal(head);

        head = new ListNode(1);
        head.withNext(new ListNode(1)).withNext(new ListNode(2)).withNext(new ListNode(3)).withNext(new ListNode(3));
        deleteDuplicates(head);
        forwardTraversal(head);

        head = new ListNode(1);
        head.withNext(new ListNode(1)).withNext(new ListNode(1)).withNext(new ListNode(1)).withNext(new ListNode(1));
        deleteDuplicates(head);
        forwardTraversal(head);
    }

    private static void deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        while (head.next != null) {
            if (head.value == head.next.value) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
    }
}
