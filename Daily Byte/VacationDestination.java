/*
You are going on a vacation in which you need to take multiple planes to get to your destination. You are given a list, flights, that represents a set of your flights. Each flight is a list itself that contains two elements, the departing city and the arriving city respectively. Return the destination city.
Note: The destination city is the city that does not contain an outgoing flight and it is guaranteed there is a unique answer.

Ex: Given the following flights…

flights = [["A", "B"], ["B", "C"]], return "C".
Ex: Given the following flights…

flights = [["A", "B"], ["C", "D"], ["B", "C"]], return "D".
*/


import java.util.*;

class VacationDestination {

	public static char findTheDestination(char [][] trip) {
		if (trip == null || trip.length == 0)
			return ' ';
		if (trip.length == 1) {
			return trip[0][1];
		}
		Map<Character, List<Character>> graph = buildGraph(trip);
		char result = dfs(graph, trip[0][0]);
		return result;
	}
	public static char dfs(Map<Character, List<Character>> graph, char beg) {
		List<Character> children = graph.get(beg);
		if (!graph.containsKey(children.get(0)))
			return children.get(0);
		return dfs(graph, children.get(0));
	}

	public static Map<Character, List<Character>> buildGraph(char [][] trip) {
		Map<Character, List<Character>> graph = new HashMap<>();
		for (char [] t : trip) {
			graph.computeIfAbsent(t[0], x-> new ArrayList<>()).add(t[1]);
		}
		return graph;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int edge = sc.nextInt();
		char [][] trip = new char[edge][2];
		for (int i=0; i<trip.length; i++) {
			for (int j=0; j<2; j++) {
				trip[i][j] = sc.next().charAt(0);
			}
		}
		System.out.println(findTheDestination(trip));
	}
}
