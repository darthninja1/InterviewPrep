package linkedlist;

import static linkedlist.SinglyLinkedList.createList;

public class MiddleNode {

    public static void main(String[] args) {
        ListNode head = createList();
        System.out.println(getMiddleNode(head));
        System.out.println(getMiddleNode(new ListNode(10)));
        System.out.println(getMiddleNode(new ListNode(10).setNext(new ListNode(11).setNext(new ListNode(33)))));
    }

    private static int getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

}
