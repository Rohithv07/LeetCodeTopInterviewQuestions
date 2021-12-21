Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explaination:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explaination:
swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array. If the array is already sorted, return 0. 


Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 105
1 ≤ numsi ≤ 106



class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minimumSwaps = 0;
        int length = nums.length;
        int [] storeArray = new int[length];
        for (int i=0; i<length; i++) {
            storeArray[i] = nums[i];
        }
        Arrays.sort(storeArray);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<length; i++) {
            map.put(nums[i], i);
        }
        for (int i=0; i<length; i++) {
            if (nums[i] != storeArray[i]) {
                minimumSwaps += 1;
                int currentNumber = nums[i];
                swap(nums, i, map.get(storeArray[i]));
                map.put(currentNumber, map.get(storeArray[i]));
                map.put(storeArray[i], i);
            }
        }
        return minimumSwaps;
    }
    
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



// by counting cycle and taking sum of cycle - 1


class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        
        //creating a list of pairs where first element of pair is array 
        //element and second element is its position.
        ArrayList<ArrayList<Integer>> cur = new ArrayList<>();
        
        //iterating over the array elements.
        for(int i=0; i<n; i++)
        {
            //storing the elements and their position as pair in the list.
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(i);
            cur.add(temp);
        }
        
        //sorting the list.
        cur.sort(new Comparator<ArrayList<Integer>> ()
        {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2)
            {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        
        //using boolean list to mark visited elements and currently 
        //marking all the nodes as false.
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        
        int ans = 0;
        
        for (int i = 0; i < n; i++)
        {
            //if element is already visited or it is already at
            //correct position, we continue the loop.
            if (vis[i] || cur.get(i).get(1) == i)
                continue;
            else
            {
                int cycle_size = 0;
                int j = i;
                
                //while element is not visited, we find out the number of nodes 
                //in this cycle and keep incrementing cycle size.
                while (!vis[j])
                {
                    vis[j] = true;
                    j = cur.get(j).get(1);
                    cycle_size++;
                }
                //updating number of swaps required.
                ans += Math.max(0,cycle_size - 1);
            }
        }
        return ans;
    }
}
