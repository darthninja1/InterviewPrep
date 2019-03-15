package linkedlist;

import static linkedlist.SinglyLinkedList.createList;

public class SecondLastNode {
    public static void main(String[] args) {
        ListNode head = createList();
        System.out.println(getSecondLastNode(head));
        System.out.println(getSecondLastNode(new ListNode(10)));
        System.out.println(getSecondLastNode(new ListNode(10).setNext(new ListNode(11))));
    }

    private static int getSecondLastNode(ListNode head) {
        if (head == null || head.next == null) return Integer.MIN_VALUE;
        ListNode ptr = head;
        while (ptr.next.next != null) {
            ptr = ptr.next;
        }
        return ptr.value;
    }
}
