package design;

import java.util.Hashtable;

/*
    Design and implement a data structure for Least Recently Used (LRU) cache.
    It should support the following operations: get and put.

    get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    put(key, value) - Set or insert the value if the key is not already present.
    When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    The cache is initialized with a positive capacity.

    Follow up:
    Could you do both operations in O(1) time complexity?
 */
public class LRUCache {

    class DLinkedList {
        int key;
        int value;
        DLinkedList pre;
        DLinkedList post;
    }

    private Hashtable<Integer, DLinkedList> cache = new Hashtable<Integer, DLinkedList>();
    int capacity;
    int count = 0;
    DLinkedList head = null;
    DLinkedList tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList();
        head.pre = null;

        tail = new DLinkedList();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedList node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedList node) {
        DLinkedList pre = node.pre;
        DLinkedList post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addNode(node);
    }

    /**
     *   pop the current tail.
     */
    private DLinkedList popTail() {
        DLinkedList node = tail.pre;
        removeNode(node);
        return node;
    }

    public Integer get(int key) {
        DLinkedList node = cache.get(key);

        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedList node = cache.get(key);

        if (node == null) {
            node = new DLinkedList();
            node.key = key;
            node.value = value;

            cache.put(key, node);
            addNode(node);
            count++;

            if (count > capacity) {
                DLinkedList evictNode = popTail();
                cache.remove(evictNode.key);
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }


    public static void main(String args[]) {

    }
}
