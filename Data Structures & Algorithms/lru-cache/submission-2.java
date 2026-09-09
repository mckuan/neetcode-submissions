public class Node {
        int key;
        int val;
        Node prev;
        Node next;
    
        public Node (int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
}

public class LRUCache {

    private Map<Integer,Node> cache;
    private int size; 
    private Node left;
    private Node right;

    public LRUCache(int capacity) { //initialize LRU cache size:capacity
        this.size = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void add(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    
    public int get(int key) { //return val if key exists, if not return -1
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;    
    }
    
    public void put(int key, int value) { 
        // 1) update val of key if key exists
        // 2) else add key value pair to cache
        // 3) if cache.size > capacity, remove least recently used key

        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node (key,value);
        cache.put(key, newNode);
        add(newNode);

        if (cache.size() > size){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        } 
    }
}
