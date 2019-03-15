package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class SinglyLinkedList {

    public static void main(String[] args) {
        ListNode head = createList();
        System.out.println("Length: " + head.length());
        System.out.print("Forward traversal iterative: ");
        forwardTraversal(head);
        System.out.print("Forward traversal recursive: ");
        forwardTraversalRecursive(head);
        System.out.print("Reverse traversal recursive: ");
        reverseTraversalRecursive(head);
        System.out.print("\nReverse traversal iterative: ");
        reverseTraversalIterative(head);
        System.out.print("\nReverse a list: ");
        head = reverse(head);
        forwardTraversalRecursive(head);
        System.out.print("Reverse a list: ");
        head = reverseIterative(head);
        forwardTraversalRecursive(head);
    }

    static void forwardTraversal(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    static void forwardTraversalRecursive(ListNode head) {
        if (head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.value + " ");
        forwardTraversalRecursive(head.next);
    }

    static void reverseTraversalRecursive(ListNode head) {
        if (head == null) {
            return;
        }
        reverseTraversalRecursive(head.next);
        System.out.print(head.value + " ");
    }

    static void reverseTraversalIterative(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addFirst(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.removeFirst().value + " ");
        }
    }

    static ListNode reverse(ListNode head) {
        return reverseHelper(head, null);
    }

    private static ListNode reverseHelper(ListNode head, ListNode prev) {
        if (head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode temp1 = head.next;
        head.next = prev;
        return reverseHelper(temp1, head);
    }

    static ListNode reverseIterative(ListNode head) {
        ListNode next;
        ListNode prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    static ListNode createList() {
        ListNode head = new ListNode(20);
        head.withNext(new ListNode(13)).withNext(new ListNode(90)).withNext(new ListNode(56));
        return head;
    }
}
