package hashmaps_and_hashfunctions;

import java.util.*;

class MyHashMap<K, V> {
    class Node {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int size = 10;
    private LinkedList<Node>[] buckets;
    public MyHashMap() {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }
    public void put(K key, V value) {
        int index = hash(key);
        for (Node node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        buckets[index].add(new Node(key, value));
    }
    public V get(K key) {
        int index = hash(key);
        for (Node node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
    public void remove(K key) {
        int index = hash(key);
        Iterator<Node> it = buckets[index].iterator();
        while (it.hasNext()) {
            Node node = it.next();
            if (node.key.equals(key)) {
                it.remove();
                return;
            }
        }
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Node node : buckets[i]) {
                System.out.print("(" + node.key + "," + node.value + ") ");
            }
            System.out.println();
        }
    }
}
public class CustomHash {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Math", 95);
        map.put("Physics", 88);
        map.put("Chemistry", 91);
        map.put("English", 85);
        System.out.println("Initial Data:");
        map.display();
        System.out.println(map.get("Math"));
        map.put("Physics", 90);
        map.display();
        map.remove("English");
        map.display();
    }
}