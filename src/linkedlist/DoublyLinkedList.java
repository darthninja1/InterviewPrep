package linkedlist;

import static linkedlist.SinglyLinkedList.createList;
import static linkedlist.SinglyLinkedList.forwardTraversal;

public class DoublyLinkedList {

    public static void main(String[] args) {
        ListNode head = createList();
        forwardTraversal(head);
        System.out.println("Reversed: ");
        forwardTraversal(reverseIterative(null));
        forwardTraversal(reverse(null));
        forwardTraversal(reverseIterative(head));
        forwardTraversal(reverse(createList()));
        forwardTraversal(reverseIterative(new ListNode(10)));
        forwardTraversal(reverse(new ListNode(10)));
        forwardTraversal(reverseIterative(new ListNode(10).setNext(new ListNode(11))));
        forwardTraversal(reverse(new ListNode(10).setNext(new ListNode(11))));
    }

    static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head.next;
        head.next = head.prev;
        head.prev = temp;

        if (head.prev == null) {
            return head;
        }
        return reverse(head.prev);
    }

    static ListNode reverseIterative(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode currentNode = head;
        ListNode priorNode = null;
        while (currentNode != null) {
            priorNode = currentNode.prev;
            // swap
            currentNode.prev = currentNode.next;
            currentNode.next = priorNode;

            // Make current node point to the "next" node (which is now prev) in list
            currentNode = currentNode.prev;
        }
        if (priorNode != null) {
            head = priorNode.prev;
        }
        return head;
    }
}
