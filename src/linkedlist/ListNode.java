package linkedlist;

public class ListNode {
    int value;
    ListNode next;
    ListNode prev;

    ListNode(int value) {
        this.value = value;
    }

    ListNode withNext(ListNode nextNode) {
        this.next = nextNode;
        nextNode.prev = this;
        return nextNode;
    }

    ListNode withPrev(ListNode prevNode) {
        this.prev = prevNode;
        prevNode.next = this;
        return prevNode;
    }

    public int length() {
        int count = 1;
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
