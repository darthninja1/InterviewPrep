package linkedlist;

import static linkedlist.SinglyLinkedList.createList;
import static linkedlist.SinglyLinkedList.forwardTraversalRecursive;

public class KthLastNode {
    public static void main(String[] args) {
        ListNode head = createList();
        System.out.println("--> " + getKthLastNode(head, 4));
        System.out.println("--> " + getKthLastNode(head, 3));
        System.out.println("--> " + getKthLastNode(head, 2));
        System.out.println("--> " + getKthLastNode(head, 1));
        System.out.println("--> " + getKthLastNode(head, 5));
        System.out.println("--> " + getKthLastNode(new ListNode(10), 1));
        System.out.println("--> " + getKthLastNode(new ListNode(10).setNext(new ListNode(11)), 2));
    }

    private static int getKthLastNode(ListNode head, int k) {
        forwardTraversalRecursive(head);
        if (head == null || head.next == null) return Integer.MIN_VALUE;
        ListNode ptr = head;
        int count = 1;
        while (ptr.next != null) {
            count++;
            ptr = ptr.next;
        }
        if (k > count) return Integer.MIN_VALUE;
        ListNode kptr = head;
        for (int i = 0; i < k; i++) {
            kptr = kptr.next;
        }
        ptr = head;
        while (kptr != null) {
            ptr = ptr.next;
            kptr = kptr.next;
        }
        return ptr.value;
    }
}
