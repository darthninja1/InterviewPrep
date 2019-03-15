package linkedlist;

import static linkedlist.SinglyLinkedList.createList;
import static linkedlist.SinglyLinkedList.forwardTraversalRecursive;

public class KthLastNode {
    public static void main(String[] args) {
        ListNode head = createList();
        getKthLastNode(head, 4);
        getKthLastNode(head, 3);
        getKthLastNode(head, 2);
        getKthLastNode(head, 1);
        getKthLastNode(head, 5);
        getKthLastNode(new ListNode(10), 1);
        getKthLastNode(new ListNode(10).setNext(new ListNode(11)), 2);
    }

    private static void getKthLastNode(ListNode head, int k) {
        forwardTraversalRecursive(head);
        ListNode ptr = head;
        if (head == null) {
            System.out.println(k +" --> Error");
            return;
        }
        ListNode kptr = head;
        for (int i = 0; i < k; i++) {
            if (kptr == null) {
                System.out.println(k +" --> Error");
                return;
            }
            kptr = kptr.next;
        }
        while (kptr != null) {
            ptr = ptr.next;
            kptr = kptr.next;
        }
        System.out.println(k + " --> " + ptr.value);
    }
}
