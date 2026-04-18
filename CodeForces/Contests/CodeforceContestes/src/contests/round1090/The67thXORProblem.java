/**
 * @author rohithvazhathody
 * @date 4 Apr 2026
 * Project: CodeforceContestes
 * File: The67thXORProblem.java
 */

package contests.round1090;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class The67thXORProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			long maxPossible = findMaxPossible(nums); 
			System.out.println(maxPossible);
		}
		sc.close();
	}

	private static long findMaxPossible(int[] nums) {
		Arrays.sort(nums);
		Trie trie = new Trie();
		for (int num : nums) {
			trie.insert(num);
		}
		long maxValue = 0;
		for (int num : nums) {
			int currentMax = trie.getMaxXor(num);
			if (currentMax > maxValue) {
				maxValue = currentMax;
			}
		}
		return maxValue;
	}

}


// reused trie method

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsBit(bit)) {
                node.putBit(bit, new TrieNode());
            }
            node = node.nodeLink[bit];
        }
    }

    public int getMaxXor(int num) {
        TrieNode node = root;
        int maxValue = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsBit(1 - bit)) {
                maxValue = maxValue | (1 << i);
                node = node.nodeLink[1 - bit];
            }
            else {
                node = node.nodeLink[bit];
            }   
        }
        return maxValue;
    }
}

class TrieNode {
    TrieNode [] nodeLink;

    public TrieNode() {
        nodeLink = new TrieNode[2];
    }

    public boolean containsBit(int bit) {
        return nodeLink[bit] != null;
    }

    public void putBit(int bit, TrieNode node) {
        nodeLink[bit] = node;
    }
}
