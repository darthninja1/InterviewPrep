package hashtable;

public class HashTable<K, V> {
    private static final int CAPACITY = 10;
    Entry<K, V>[] table;
    int size = 0;

    public HashTable() {
        table = (Entry<K, V>[]) new Entry[CAPACITY];
    }

    public static void main(String[] args) {
        HashTable<String, String> hashtable = new HashTable<>();
        for (int i = 0; i < 26; i++) {
            hashtable.put(String.valueOf((char) ('a' + i)), String.valueOf((char) ('A' + i)));
        }

        for (int i = 0; i < 26; i++) {
            System.out.println("Mapping: " + (char) ('a' + i) + " -> " + hashtable.get(String.valueOf((char) ('a' + i))));
        }

        for (int i = 0; i < 26; i++) {
            System.out.println("Old mapping for - " + (char) ('a' + i) + " -> " +
                    hashtable.put(String.valueOf((char) ('a' + i)), (char) ('A' + i) + "1"));
        }

        for (int i = 0; i < 26; i++) {
            System.out.println("New Mapping: " + (char) ('a' + i) + " -> " + hashtable.get(String.valueOf((char) ('a' + i))));
        }

        for (int i = 0; i < 26; i++) {
            System.out.println("Removing mapping for - " + (char) ('a' + i) + " -> " +
                    hashtable.remove(String.valueOf((char) ('a' + i))));
        }
        System.out.println("Size: " + hashtable.size);
    }

    public V put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % CAPACITY;
        Entry<K, V> node = table[index];
        while (node != null) {
            if (key.equals(node.key)) {
                // replace
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }
        table[index] = new Entry<>(hash, key, value, table[index]);
        ++size;
        return null;
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % CAPACITY;
        Entry<K, V> node = table[index];
        while (node != null) {
            if (key.equals(node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int hash = key.hashCode();
        int index = hash % CAPACITY;
        Entry<K, V> node = table[index];
        Entry<K, V> prev = null;
        while (node != null) {
            if (key.equals(node.key)) {
                break;
            }
            prev = node;
            node = node.next;
        }
        if (node == null) {
            return null;
        }
        size--;
        if (prev != null) {
            prev.next = node.next;
        } else { // 1st entry
            table[index] = node.next;
        }
        return node.value;
    }

    private static class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
