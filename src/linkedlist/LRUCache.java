package linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

// https://leetcode.com/problems/lru-cache/
// http://www.geeksforgeeks.org/implement-lru-cache/
public class LRUCache<K, V> {
    private static final int CAPACITY = 4;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private Node<K, V> head;
    private Node<K, V> tail;

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "ninja");
        cache.put(2, "darth");
        cache.put(3, "vader");
        cache.put(4, "star wars");
        System.out.println("Cache order - ");
        cache.printNodeOrder();
        IntStream.range(1, 5).forEach(k -> System.out.println(cache.get(5 - k)));
        System.out.println("Cache order - ");
        cache.printNodeOrder();
        System.out.println("Removing key 1...");
        cache.remove(1);
        System.out.println("Cache order - ");
        cache.printNodeOrder();
        System.out.println("Getting key 3...");
        cache.get(3);
        cache.printNodeOrder();
        cache.put(5, "luke");
        System.out.println("Cache order - ");
        cache.printNodeOrder();
        System.out.println("Removing key 1...");
        cache.remove(4);
        cache.printNodeOrder();
        System.out.println("Removing all keys...");
        cache.remove(5);
        cache.remove(3);
        cache.remove(2);
        System.out.println("Cache order - ");
        cache.printNodeOrder();
    }

    V get(K key) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            remove(node);
            addToHead(node);
            return node.value;
        }
        return null;
    }

    void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            // update existing node
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            if (map.size() > CAPACITY) {
                // evict tail node
                map.remove(tail.key);
                Node<K, V> prev = tail.prev;
                remove(tail);
                tail = prev;
            }
            node = new Node<>(key, value);
            if (map.size() == 0) {
                tail = node;
                head = node;
            } else {
                addToHead(node);
            }
            map.put(key, node);
        }
    }

    private void addToHead(Node<K, V> node) {
        if (head != null) {
            node.next = head;
            node.prev = null;
            head.prev = node;
        }
        head = node;
    }

    private void remove(K key) {
        Node<K, V> node = map.remove(key);
        remove(node);
    }

    private void remove(Node<K, V> node) {
        Node<K, V> next = node.next;
        Node<K, V> prev = node.prev;
        if (prev != null) { // not head
            prev.next = next;
        } else { // head
            head = next;
            if (head != null) {
                head.prev = null;
            }
        }
        if (next != null) { // not tail
            next.prev = prev;
        } else { // tail
            tail = prev;
            if (tail != null) {
                tail.next = null;
            }
        }
    }

    private void printNodeOrder() {
        Node node = head;
        while (node != null) {
            System.out.println("LRU - " + node.key + " " + node.value);
            node = node.next;
        }
    }

    private static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override
        public String toString() {
            return key + " -> " + value;
        }
    }
}