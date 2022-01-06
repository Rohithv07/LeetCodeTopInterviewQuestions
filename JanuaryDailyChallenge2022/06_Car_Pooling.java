There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
 

Constraints:

1 <= trips.length <= 1000
trips[i].length == 3
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= capacity <= 105


class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int [] timeStamp = new int [1001]; // based on constraint given
        // add the number of passengers from the starting position as they get in
        // subtract the number of passengers from the ending position as they get out
        // timsStamp means in each time how many passengers are onboarded
        for (int [] trip : trips) {
            int passengers = trip[0];
            int getIn = trip[1];
            int getOut = trip[2];
            timeStamp[getIn] += passengers;
            timeStamp[getOut] -= passengers;
        }
        int currentCapacity = 0;
        for (int time : timeStamp) {
            currentCapacity += time;
            if (currentCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}