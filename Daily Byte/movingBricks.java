You are transporting bricks on a construction site and want to work as efficiently as possible. The weight of each brick is given by bricks[i]. Given a wheelbarrow that can carry up to (not including) 5000 pounds, return then maximum number of bricks you can place in your wheelbarrow to transport.

Ex: Given the following bricks…

bricks = [1000, 1000, 1000, 2000], return 3.

Ex: Given the following bricks…

bricks = [1000, 200, 150, 200], return 4.

// I think that we can sort the array and consider taking the smallest ones and check whether we are less than 5000 or not, if we are smaller then continue taking the next smaller bricks and if we exceed then return the count as we can take the next brick as it will be larger than the current brick.


public class Solution {
	public static int maxBrick(int [] bricks) {
		if (bricks == null || bricks.length == 0)
			return 0;
		if (brick.length == 1 && bricks[0] <= 4999)
			return 1;
		// the maximum weight must be 4999 ie less than 5000
		int maxWeight = 4999;
		// lets sort the array and consider the smallest values
		Arrays.sort(bricks);
		int weightsInBarrow = 0;
		int numberOfBricks = 0;
		for (int i=0; i<bricks.length; i++) { 
			// start adding the bricks to the wheel barrow and we need the sum <= 4999
			weightsInBarrow += bricks[i];
			// as long as the weights < maxWeight, we keep on adding else we stops as there wont be further continuation
			if (weightsInBarrow <= maxWeight)
				count += 1;
			else 
				break;
		}
		return count;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // size of the array
		int [] bricks = new int [n];
		for (int i=0; i<n; i++)
			bricks[i] = sc.nextInt();
		System.out.println(maxBrick(bricks));
	}
}

// O(nlogn) as sorting is done here and O(1) Space no extra space is used.
