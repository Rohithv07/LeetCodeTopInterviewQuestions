import java.util.*;

// https://youtu.be/3gbO7FDYNFQ


// TC :  4 * alpha
// SC : m where m is number of operations
public class UnionFind {
	public static void main(String [] args) {
		int n = 7;
		UnionFindImpl unionFind = new UnionFindImpl(n);
		unionFind.union(0, 1);
		unionFind.union(1, 2);
		unionFind.union(3, 4);
		unionFind.union(5, 6);
		unionFind.union(4, 5);
		unionFind.union(2, 6);
		System.out.println(unionFind.findParent(5)); // must be 3
		System.out.println(unionFind.isConnected(3, 6)); // true
	}
}

class UnionFindImpl {
	int size;
	int component;
	int [] parent;
	int [] rank;
	public UnionFindImpl(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n cannot be zero or negative");
		}
		size = n;
		component = n;
		parent = new int [n];
		rank = new int [n];
		// let every node be parent of itself initially
		for (int i=0; i<n; i++) {
			parent[i] = i;
		}
	}

	public int findParent(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int parentP = findParent(p);
		int parentQ = findParent(q);
		if (parentP == parentQ) {
			return;
		}
		if (rank[parentP] < rank[parentQ]) {
			parent[p] = parentQ;
		}
		else {
			parent[q] = parentP;
			if (rank[parentP] == rank[parentQ]) {
				rank[parentP] += 1;
			}
		}
		component -= 1;
	}

	public boolean isConnected(int p, int q) {
		return findParent(p) == findParent(q);
	}
}