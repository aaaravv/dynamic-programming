class LFUCache {
    int cap;
    int sizeOfList;
    
    Map<Integer, LFUCache.DLLNode> mp = new HashMap<>(); // key -> Address
    TreeMap<Integer, LFUCache.DoublyLinkedList> freq = new TreeMap<>(); // Freq -> DoublyLinkedList<DLLNode>

    public LFUCache(int capacity) {
        cap = capacity;
        sizeOfList = 0;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;

        DLLNode node = mp.get(key); // find the address of the node from map (mp)
        int val = node.val;

        makeMostFrequentlyUsed(key);

        return val;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;

        if(mp.containsKey(key)){
            DLLNode node = mp.get(key);

            node.val = value; // update the existing val for the node

            makeMostFrequentlyUsed(key);
            
        } else if(sizeOfList < cap){
            sizeOfList++;

            DLLNode node = new DLLNode(key, value);
            DoublyLinkedList lst = freq.getOrDefault(1, new DoublyLinkedList());
            lst.insert(node);
            freq.put(1, lst); // fresh node
            mp.put(key, node);
            
        } else{
            // Remove LRU or LFU when size is full
            int smallestKey = freq.firstKey();
            DoublyLinkedList whichLst = freq.get(smallestKey);
            
            int keyToDelete = whichLst.tail.prev.key;
            
            whichLst.remove(whichLst.tail.prev);
            
            if(whichLst.size == 0) freq.remove(smallestKey);
            
            DoublyLinkedList lst = freq.getOrDefault(1, new DoublyLinkedList());
            lst.insert(new DLLNode(key, value));
            freq.put(1, lst);
            
            mp.remove(keyToDelete);
            mp.put(key, lst.head.next);
        }
    }
    public void makeMostFrequentlyUsed(int key){
        DLLNode node = mp.get(key);

        int val = node.val;
        int f = node.freq;

        freq.get(f).remove(node); // remove the node from DoublyLinkedList

        if(freq.get(f).size == 0) freq.remove(f); // if DoublyLinkedList size is empty after removal remove it from that freq from freqMap

        f++; // increase the freq since it is recently used
        
        DoublyLinkedList lst = freq.getOrDefault(f, new DoublyLinkedList());
        lst.insert(node);
        freq.put(f, lst);
        node.freq = f;

        mp.put(key, node);
    }

    // Doubly LinkedList
    public class DLLNode{
        DLLNode next, prev;
        int key, val, freq;

        DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    public class DoublyLinkedList{
        DLLNode head, tail;
        int size;

        DoublyLinkedList(){
            this.size = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void remove(DLLNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        private void insert(DLLNode node){
            DLLNode headNext = head.next;
            head.next = node;
            node.next = headNext;
            headNext.prev = node;
            node.prev = head;
            size++;
        }
    }
}