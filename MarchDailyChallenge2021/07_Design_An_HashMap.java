Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.


class MyHashMap {
    
    private int[] hash;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hash = new int[100001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hash[key] = value + 1;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hash[key] - 1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hash[key] = 0;
    }
}


// Another solution
class MyHashMap {
    ListNode[] nodes = new ListNode[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode previous = findElement(index, key);
        if (previous.next == null)
            previous.next = new ListNode(key, value);
        else
            previous.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode previous = findElement(index, key);
        return previous.next == null ? -1 : previous.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        ListNode previous = findElement(index, key);
        if (previous.next != null)
            previous.next = previous.next.next;
    }
    
    public int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    public ListNode findElement(int index, int key) {
        if (nodes[index] == null)
            return nodes[index] = new ListNode(-1, -1);
        ListNode previous = nodes[index];
        while (previous.next != null && previous.next.key != key) {
            previous = previous.next;
        }
        return previous;
    }
}

class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
