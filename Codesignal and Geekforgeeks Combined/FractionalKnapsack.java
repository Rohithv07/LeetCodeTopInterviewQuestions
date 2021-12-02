Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

 

Example 1:

Input:
N = 3, W = 50
values[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.00
Explanation:Total maximum value of item
we can have is 240.00 from the given
capacity of sack. 
Example 2:

Input:
N = 2, W = 50
values[] = {60,100}
weight[] = {10,20}
Output:
160.00
Explanation:
Total maximum value of item
we can have is 160.00 from the given
capacity of sack.
 

Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size n and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.


Expected Time Complexity : O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= W <= 105



/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

// explanation video : https://youtu.be/F_DDzYnxO14
class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        // Your code here
        if (arr == null || n == 0) {
            return 0.0;
        }
        // sort by value/weight ratio
        Arrays.sort(arr, (item1, item2) -> Double.compare((double)item2.value/(double)item2.weight, (double)item1.value/(double)item1.weight));
        double maximumValue = 0.0;
        int runningWeight = 0;
        for (int i=0; i<n; i++) {
            int currentWeight = arr[i].weight;
            int currentValue = arr[i].value;
            if (currentWeight + runningWeight <= w) {
                runningWeight += currentWeight;
                maximumValue += currentValue;
            }
            else {
                // take the remaining weight left as we can take fractive
                 double value = (w - runningWeight) * ((double)currentValue / (double)currentWeight);
                 maximumValue += value;
                 break;
            }
        }
        return maximumValue;
    }
}