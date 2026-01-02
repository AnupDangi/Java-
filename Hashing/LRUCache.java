import java.util.*;

// Class representing a node in the doubly linked list
class Node {
    Node prev; // Pointer to the previous node
    Node next; // Pointer to the next node
    int key; // Key of the node
    int val; // Value of the node

    // Constructor to initialize key and value of the node
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    Node head = new Node(0, 0); // Dummy head node of the doubly linked list
    Node tail = new Node(0, 0); // Dummy tail node of the doubly linked list
    Map<Integer, Node> map = new HashMap<>(); // HashMap to store key-node pairs
    int capacity; // Maximum capacity of the cache

    // Constructor to initialize the LRU cache with a given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail; // Set head's next to tail
        tail.prev = head; // Set tail's prev to head
    }

    // Method to retrieve a value from the cache based on the key
    public int get(int key) {
        // If the key exists in the cache
        if (map.containsKey(key)) {
            Node node = map.get(key); // Get the corresponding node
            remove(node); // Remove the node from its current position
            insert(node); // Insert it at the front (most recently used position)
            return node.val; // Return the value of the node
        } else {
            return -1; // Return -1 if the key is not found
        }
    }

    // Method to insert or update a key-value pair in the cache
    public void put(int key, int value) {
        // If the key already exists in the cache
        if (map.containsKey(key)) {
            // Remove the existing node
            remove(map.get(key));
        }
        // If the cache is at full capacity, remove the least recently used node
        if (map.size() == capacity) {
            remove(tail.prev); // Remove the node just before the tail (LRU)
        }
        // Insert the new node at the front of the list
        insert(new Node(key, value));
    }

    // Private method to remove a node from the doubly linked list and the map
    private void remove(Node node) {
        map.remove(node.key); // Remove the node from the map
        node.prev.next = node.next; // Update the next pointer of the previous node
        node.next.prev = node.prev; // Update the prev pointer of the next node
    }

    // Private method to insert a node at the front of the doubly linked list
    private void insert(Node node) {
        map.put(node.key, node); // Add the node to the map
        Node headNext = head.next; // Store the current first node
        head.next = node; // Set head's next to the new node
        node.prev = head; // Set the new node's prev to head
        headNext.prev = node; // Set the previous first node's prev to the new node
        node.next = headNext; // Set the new node's next to the previous first node
    }
}

/**
 * Example usage:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */
