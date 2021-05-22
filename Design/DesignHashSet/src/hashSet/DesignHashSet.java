package hashSet;

import java.util.*;

public class DesignHashSet {
	private static final int MAX_SIZE = (int) 1e6;
	private static final int ARRAY_SIZE = 100;
	private List<List<Integer>> parentList;

	public DesignHashSet() {
		parentList = new ArrayList<>(MAX_SIZE);
		for (int i = 0; i < ARRAY_SIZE; i++) {
			parentList.add(null);
		}
	}

	public void add(int key) {
		int bucket = key % ARRAY_SIZE;
		List<Integer> childList = parentList.get(bucket);
		if (childList == null) {
			List<Integer> link = new LinkedList<>();
			link.add(key);
			parentList.add(bucket, link);
		} else {
			if (!childList.contains(key)) {
				childList.add(key);
			}
		}
	}

	public void delete(int key) {
		int bucket = key % ARRAY_SIZE;
		List<Integer> childList = parentList.get(bucket);
		if (childList != null) {
			childList.remove(Integer.valueOf(key));
		}
	}

	public boolean contain(int key) {
		int bucket = key % ARRAY_SIZE;
		List<Integer> childList = parentList.get(bucket);
		return childList != null && childList.contains(key);
	}
}
