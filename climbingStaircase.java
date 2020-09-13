You need to climb a staircase that has n steps, and you decide to get some extra exercise by jumping up the steps. You can cover at most k steps in a single jump. Return all the possible sequences of jumps that you could take to climb the staircase, sorted.

Example

For n = 4 and k = 2, the output should be

climbingStaircase(n, k) =
[[1, 1, 1, 1],
 [1, 1, 2],
 [1, 2, 1],
 [2, 1, 1],
 [2, 2]]
There are 4 steps in the staircase, and you can jump up 2 or fewer steps at a time. There are 5 potential sequences in which you jump up the stairs either 2 or 1 at a time.

Solution:
int[][] climbingStaircase(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    helper(result, current, n, k, 1, 0);
    System.out.println(result);
    int [][] array = new int [result.size()][];
    for (int i = 0; i < array.length; i++)
			array[i] = new int[result.get(i).size()]; 
    for (int i=0; i<result.size(); i++) {
        for (int j=0; j<result.get(i).size(); j++) {
            array[i][j] = result.get(i).get(j);
        }
    }
    return array;
}
void helper(List<List<Integer>> result, List<Integer> current, int n, int k, int start, int covered) {
    if (covered > n)
        return;
    if (covered == n) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i=1; i<=k; i++) {
        current.add(i);
        helper(result, current, n, k, i, covered+i);
        current.remove(current.size()-1);
    }
}

