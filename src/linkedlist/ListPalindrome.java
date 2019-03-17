package linkedlist;

import static linkedlist.SinglyLinkedList.createList;

public class ListPalindrome {
    static ListNode head;

    public static void main(String[] args) {
        head = new ListNode(20);
        head.withNext(new ListNode(40)).withNext(new ListNode(55)).withNext(new ListNode(40)).withNext(new ListNode(20));
        System.out.println(isPalindrome(head));
        head = createList();
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode node) {
        if (node == null) {
            return true;
        }
        boolean status = isPalindrome(node.next);
        if (!status) return false;
        if (head.value == node.value) {
            head = head.next;
            return true;
        }
        return false;
    }
}
