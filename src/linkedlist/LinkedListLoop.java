package linkedlist;

public class LinkedListLoop {
    public static void main(String[] args) {
        ListNode head = new ListNode(20);
        ListNode node = new ListNode(90);
        ListNode loop = new ListNode(33);
        head.withNext(new ListNode(13))
                .withNext(node).withNext(new ListNode(56))
                .withNext(new ListNode(23)).withNext(loop);
        loop.withNext(node);
        // Infinite loop
        // SinglyLinkedList.forwardTraversal(head);
        System.out.println(hasLoop(head));
        System.out.println(hasLoop(null));
        System.out.println(hasLoop(new ListNode(10)));
        System.out.println(hasLoop(new ListNode(10).setNext(new ListNode(11))));
        ListNode head2 = new ListNode(9);
        ListNode node2 = new ListNode(18);
        head2.next = node2;
        node2.next = head2;
        System.out.println(hasLoop(head2));
    }

    private static boolean hasLoop(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
