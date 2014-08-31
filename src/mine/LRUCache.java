package mine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Xiong
 * Date: 14-6-29
 * Time: 下午9:15
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {
    private Map<Integer, LRUNode> map;
    private LRUList list;
    int capacity;
    public LRUCache(int capacity) {
        float loadFactor = 0.75f;
        int size = (int)Math.ceil(capacity / loadFactor) + 1;
        map = new HashMap<Integer, LRUNode>(size, loadFactor);
        list = new LRUList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            list.moveToFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            list.moveToFirst(map.get(key));
        } else {
            if (map.size() >= capacity) {
                int removeKey = list.removeLast();
                map.remove(removeKey);
            }
            LRUNode node = new LRUNode(key, value);
            map.put(key, node);
            list.addToFirst(node);
        }
    }

    class LRUNode {
        public int key;
        public int value;
        public LRUNode next;
        public LRUNode prev;
        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LRUList {
        private LRUNode head;
        private LRUNode tail;
        public LRUList() {
            head = new LRUNode(0,0);
            tail = new LRUNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
        public void addToFirst(LRUNode node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        }
        public void moveToFirst(LRUNode node) {
            if (node.prev != head) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                head.next.prev = node;
                node.next = head.next;
                node.prev = head;
                head.next = node;
            }
        }
        public int removeLast() {
            int key = tail.prev.key;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            return key;
        }
    }



    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.set(2,1);
        cache.set(2,2);
        cache.get(2);
        cache.set(1,1);
        cache.set(4,1);
        cache.get(2);
    }
}
