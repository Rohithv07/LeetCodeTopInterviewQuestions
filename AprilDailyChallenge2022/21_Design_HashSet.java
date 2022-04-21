Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
 

Constraints:

0 <= key <= 106
At most 104 calls will be made to add, remove, and contains.


class MyHashSet {

    private ListNode [] bucket;
    
    public MyHashSet() {
        bucket = new ListNode[(int)(1e6)];
    }
    
    public void add(int key) {
        int hashCode = findHashCode(key);
        ListNode previous = findPrevious(hashCode, key);
        if (previous.next == null) {
            previous.next = new ListNode(key);
        }
    }
    
    public void remove(int key) {
        int hashCode = findHashCode(key);
        ListNode previous = findPrevious(hashCode, key);
        if (previous.next != null) {
            previous.next = previous.next.next;
        }
    }
    
    public boolean contains(int key) {
        int hashCode = findHashCode(key);
        ListNode previous = findPrevious(hashCode, key);
        if (previous.next == null) {
            return false;
        }
        return previous.next.value == key;
    }
    
    private int findHashCode(int key) {
        return Integer.hashCode(key) % bucket.length;
    }
    
    private ListNode findPrevious(int hash, int key) {
        if (bucket[hash] == null) {
            bucket[hash] = new ListNode(-1);
            return bucket[hash];
        }
        ListNode previous = bucket[hash];
        while (previous.next != null && previous.next.value != key) {
            previous = previous.next;
        }
        return previous;
    }
}

class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */