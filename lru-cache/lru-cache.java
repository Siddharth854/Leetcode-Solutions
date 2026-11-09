import java.util.*;
class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap <Integer, Node> map;
    Node head; // LRU side
    Node tail; // MRU side
    //constructor

    void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    void insert(Node node)
    {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        //Dummy Node
        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }        
        Node node = map.get(key);
        //move to MRU position
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) 
        {
            Node node = map.get(key);
            node.value = value;
            //make it most recently used
            remove(node);
            insert(node);
            return;
        }
        Node node = new Node(key, value);
        map.put(key,node);
        insert(node);
        if(map.size() > capacity)
        {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */