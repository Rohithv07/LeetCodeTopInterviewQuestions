import java.util.*;

class NearestRestaurant {

	public static List<List<Integer>> getNearestRestaurant(List<List<Integer>>restaurant, int howMany) {

		if (restaurant.size() < howMany || howMany == 0)
			return null;
		int[][] restaurants = restaurant.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
		Map<int [], Integer> trackDistance = new HashMap<>();
		for (int [] rest : restaurants) {
			int x = rest[0];
			int y = rest[1]; 
			int distance = (x * x) + (y * y);
			trackDistance.put(new int [] {x, y}, distance);
		}
		PriorityQueue<int [] > maxHeap = new PriorityQueue<>((a, b) -> trackDistance.get(b) - trackDistance.get(a));
		for (int [] key : trackDistance.keySet()) {
			maxHeap.add(key);
			while (maxHeap.size() > howMany) {
				maxHeap.remove();
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		while (!maxHeap.isEmpty()) {
			List<Integer> current = new ArrayList<>();
			int [] coordinates = maxHeap.remove();
			int x = coordinates[0];
			int y = coordinates[1];
			current.add(x);
			current.add(y);
			result.add(current);
		}
		Collections.reverse(result);
		return result;

	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int numRest = sc.nextInt();
		List<List<Integer>> restaurants = new ArrayList<>();
		for (int i=0; i<numRest; i++) {
			List<Integer> current = new ArrayList<>();
			int x = sc.nextInt();
			int y = sc.nextInt();
			current.add(x);
			current.add(y);
			restaurants.add(current);
		}
		int howMany = sc.nextInt();
		System.out.println(getNearestRestaurant(restaurants, howMany));
		
	}
}
