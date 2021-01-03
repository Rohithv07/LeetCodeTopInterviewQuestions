import java.util.*;

class ThirdLargest {

	public static int thirdLargestElement(int [] array) {
		if (array.length < 3) {
			return Arrays.stream(array).max().getAsInt();
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
		for (int number : array) {
			minHeap.add(number);
			if (minHeap.size() > 3)
				minHeap.remove();
		}
		return minHeap.remove();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] array = new int [n];
		for (int i=0; i<n; i++)
			array[i] = sc.nextInt();
		System.out.println(thirdLargestElement(array));
	}
}


/*
int max(int [] array) {
	int maximum = Integer.MIN_VALUE;
	for (int number : array)
		maximum = Math.max(number, maximum);
	return maximum;
}
*/