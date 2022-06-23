import java.util.HashMap;

public class LRUCache {
    class DLinkedNode{
        int value;
        int key;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.value = value;
            this.key = key;
        }
    }

    private HashMap<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;


    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // 如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if (node == null){
            // 如果key不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key,value);
            // 添加进哈希表
            cache.put(key,newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity){
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeToTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }

        }else {
            // 如果key存在，先通过哈希表定位，在修改value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeToTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}