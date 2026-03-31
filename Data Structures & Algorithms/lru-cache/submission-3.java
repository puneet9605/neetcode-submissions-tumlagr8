class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;
    

    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        cache.put(key, newNode);
        if (cache.size()>capacity){
            Node last = tail.prev;
            deleteNode(last);
            cache.remove(last.key);
        }
    }
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
        
    }


    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int k,int v){
            val =v;
            key = k;
        }
    }
