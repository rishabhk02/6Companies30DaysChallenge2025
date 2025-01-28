import java.util.*;

class LRUCache {
    int cap;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            addToHead(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            addToHead(map.get(key));
            return;
        } else if (map.size() == cap) {
            removeNode();
        }
        Node newNode = new Node(key, value);
        map.put(key,newNode);
        addToHead(newNode);
        return;
    }

    void addToHead(Node cur) {
        if(cur.prev!=null) cur.prev.next = cur.next;
        if(cur.next!=null) cur.next.prev = cur.prev;
        cur.next = head.next;
        cur.next.prev = cur;
        head.next = cur;
        cur.prev = head;
        return;
    }

    void removeNode() {
        int key = tail.prev.key;
        map.remove(key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return;
    }
}

class Node {
    Node next;
    Node prev;
    int key;
    int val;

    Node(int key, int val) {
        next = null;
        prev = null;
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */