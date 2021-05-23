package net.teaho.algorhythm.leetcode.alg146LRUCache;


import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private static class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部 和 伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        //如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            //如果key不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加进哈希表
            cache.put(key, newNode);
            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if(size > capacity){
                //如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else{
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        //如：
        //head ↔ 1 ↔ 2 ↔ 3 ↔ 4 ↔ tail
        //res = 4
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(DLinkedNode node) {
        //将node“移出来”
        removeNode(node);
        //放到头节点；也就是伪头节点之后
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        //1.如果是新节点 newNode = 2
        //之前： head ↔ 1 ↔ tail
        //之后： head ↔ 2 ↔ 1 ↔ tail

        //2.如果是removeNode(node)之后的节点：比如当前操作的节点是 node = 2
        //之前：head ↔ 1 ↔ 3 ↔ 4 ↔ tail
        //             ↖2↗
        //之后：head ↔ 2 ↔ 1 ↔ 3 ↔ 4 ↔ tail

        //让当前节点2的 prev指针 指向伪头结点head：2 prev head
        node.prev = head;
        //让当前节点2的 next指针 指向头结点的下一个节点1：2 next 1
        node.next = head.next;
        //让伪头结点的下一个节点1的 prev指针 指向当前节点2: 1 prev 2
        head.next.prev = node;
        //让伪头节点的 next指针 指向当前节点2：head next 2
        head.next = node;
    }

    private static void removeNode(DLinkedNode node) {
        //比如当前操作的结点是 node = 2
        //之前： head ↔ 1 ↔ 2 ↔ 3 ↔ 4 ↔ tail
        //之后： head ↔ 1 ↔ 3 ↔ 4 ↔ tail
        //              ↖2↗
        // node = 2 被移出来：但是2的 next指针 依然指向3，prev指针 依然指向1

        //当前节点的前一个节点1 的 next指针 指向当前节点的下一个节点：1 next 3
        node.prev.next = node.next;
        //当前节点的下一个节点3 的 prev指针 指向当前节点的前一个节点：3 prev 1
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */