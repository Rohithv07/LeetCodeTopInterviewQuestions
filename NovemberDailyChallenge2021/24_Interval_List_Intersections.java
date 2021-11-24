You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 

Example 1:


Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:

Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
Example 3:

Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []
Example 4:

Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]
 

Constraints:

0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 109
endi < starti+1
0 <= startj < endj <= 109
endj < startj+1



// brute force

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int [][]{};
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int [] first : firstList) {
            for (int [] second : secondList) {
                List<Integer> current = new ArrayList<>();
                int firstStart = first[0];
                int secondStart = second[0];
                int firstEnd = first[1];
                int secondEnd = second[1];
                int lowStart = Math.max(firstStart, secondStart);
                int highEnd = Math.min(firstEnd, secondEnd);
                if (lowStart <= highEnd) {
                    current.add(lowStart);
                    current.add(highEnd);
                    result.add(current);
                }
            }
        }
        int [][] finalList = new int [result.size()][2];
        int index = 0;
        for (List<Integer> value : result) {
            finalList[index][0] = value.get(0);
            finalList[index][1] = value.get(1);
            index++;
        }
        return finalList;
        
    }
}


// better one

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int [][]{};
        }
        List<int[]> result = new ArrayList<>();
        int length1 = firstList.length;
        int length2 = secondList.length;
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            int firstStart = firstList[i][0];
            int firstEnd = firstList[i][1];
            int secondStart = secondList[j][0];
            int secondEnd = secondList[j][1];
            if (firstEnd < secondEnd) {
                i += 1;
            }
            else {
                j += 1;
            }
            int low = Math.max(firstStart, secondStart);
            int high = Math.min(firstEnd, secondEnd);
            if (low <= high) {
                result.add(new int []{low, high});
            }
        }
        return result.toArray(new int [result.size()][2]);
    }
}