package hashmap;

public class HashMap {
	private static final int MAX_SIZE = (int) 1e6;
	private ListNode[] bucket;

	public HashMap() {
		bucket = new ListNode[MAX_SIZE];
	}

	public void put(int key, int value) {
		int index = getIndex(key);
		ListNode previous = getPrevious(index, key);
		if (previous.next == null) {
			previous.next = new ListNode(key, value);
		} else {
			previous.next.value = value;
		}
	}

	public int get(int key) {
		int index = getIndex(key);
		ListNode previous = getPrevious(index, key);
		if (previous.next == null) {
			return -1;
		}
		return previous.next.value;
	}

	public void remove(int key) {
		int index = getIndex(key);
		ListNode previous = getPrevious(index, key);
		if (previous.next == null) {
			return;
		}
		// we can do this in 2 way
		previous.next = null;
		// or previous.next = previous.next.next;
	}

	public int getIndex(int key) {
		return key % MAX_SIZE;
	}

	public ListNode getPrevious(int index, int key) {
		if (bucket[index] == null) {
			return bucket[index] = new ListNode(-1, -1);
		}
		ListNode previous = bucket[index];
		while (previous.next != null && previous.next.key != key) {
			previous = previous.next;
		}
		return previous;
	}
}
