class LRUCache {
    // Doubly linked list
    private class CacheNode {
        private int key;
        private int value;
        private CacheNode prev;
        private CacheNode next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, CacheNode> cache = new HashMap<>();
    private CacheNode dummyHead;
    private CacheNode dummyTail;

    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.dummyHead = new CacheNode(-1, -1);
        this.dummyTail = new CacheNode(-1, -1);

        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }
    
    public int get(int key) {
        CacheNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // Remove node from doubly-linked list
        remove(node);
        // Add node to the doubly-linked list
        add(node);

        return node.value;
    }

    private void remove(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(CacheNode node) {
        node.next = dummyTail;
        node.prev = dummyTail.prev;

        dummyTail.prev.next = node;
        dummyTail.prev = node;
    }

    public void put(int key, int value) {
        CacheNode node = cache.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            // Add node to the tail
            add(node);
            return;
        }

        CacheNode newNode = new CacheNode(key, value);
        add(newNode);
        cache.put(key, newNode);
        // System.out.println("Before Cache size = " + cache.size() + ", capacity = " + capacity);
        if (cache.size() > capacity) {
            CacheNode obsoleteNode = dummyHead.next;
            remove(obsoleteNode);
            cache.remove(obsoleteNode.key);
        }
        // System.out.println("After Cache size = " + cache.size() + ", capacity = " + capacity);
    }
}
