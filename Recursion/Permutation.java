

// https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12


/*
so there will be n! number of different permutations available
in our recursive function we will be holding a data structure that can store the current items for the permutations and an extra array which can mark whether we pick a particular element or not.
[1,2,3] lets say for this example we start by fun(ds, markArray)

for the very first position, we can either have 1 or 2 or 3.
We start by 1. So our ds will store this 1 currently and mark it in the markArray.
fun(1, [true, false, false])
now for the next position, we can either pick 2 or 3. Lets pick 2
So while picking, the 2 gets added to our data structure and we mark it inside the markArray.
fun(12, [true, true, false])
Next the only available option is to pick 3 and there are not other options currently available for us. So we pick 3, add to the ds and mark it inside the mark array.
fun(123, [true, true, true]) [1, 2, 3]
Now we hit the base condition which is ds.size() == n. So now whatever is there inside the ds, we just store it in our final result array and we move backward. While we move backward, we must make sure that we are taking out the lastly added element, here it will be 3 and mark it as not taken
fun(12, [true, true, false])
Now there are no more elements suitable for the 3rd element, other than 3 and we have already done a perumation.So we once again move backward, removing the lastly added element which is 2 in this case and unmark that element
fun(1, [true, false, false])
Now we have another option as second element which is 3. So we can store that element inside the data structure and mark it inside the markArray.
fun(13, [true, false, true])
Now what are the other options we have, we can't take 1 or 3 again as its already being marked, then our only option now for the 3rd element is 2. So store 2 inside the ds and mark it inside the data structure.
fun(132, [true, true, true]) [1, 3, 2]
We hit the base condition and store this perumation inside our final array.
Now there are no more options available for us, so move backward by unmarking and removing the lastly added element which is 2.
fun(13, [true, false, true])
We have no other option here too, so again move backward by removing and unmarking the lastly added element which is 3.
fun(1, [true, false, false])
Same case as above and we move backward by removing and unmarking the lastly added element which is 1.
fun(ds, [false, false, false]).
We have got the permuatation where our starting number is 1. We also have 2 and 3 as our options as starting number and the same steps can be repeated to get
[2, 3, 1], [2, 1, 3], [3, 1, 2], [3, 2, 1]

TC : n! * n
SC : n + n + n!(output) + auxiliary

*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean [] markArray = new boolean [length];
        backtrack(nums, result, current, markArray);
        return result;
    }
    
    private void backtrack(int [] nums, List<List<Integer>> result, List<Integer> current, boolean [] markArray) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (markArray[i]) {
                continue;
            }
            markArray[i] = true;
            current.add(nums[i]);
            backtrack(nums, result, current, markArray);
            markArray[i] = false;
            current.remove(current.size() - 1);
        }
    }
}



// https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13

/*
so there will be n! number of different permutations available
the other approach which will get rid of the extra boolean markArrary will be by making use of a swapping technique.

[1,2, 3]
So for the first position, we lets start by swapping 1 with 1, 
Also we can do swapping for the first position by swapping 1 with 2.
Also we can do swapping for the first position by swapping 1 and 3.
So we can get like [1,2,3] [2, 1, 3] [3,2,1]. Please not we are not yet decided our final permuations, we just fixed our different starting positions.

Now [1, 2, 3] and we fixed 1 as the starting position, now for the second position, we can swap 2 with 2 and we can swap 2 with 3 which are the different possibilities for the second position
[1, 2, 3] and [1, 3, 2]. So we now just fixed the possible 2nd position of the permutation.
Now for [1, 2, 3], we can fix 3 at the last position by swapping 3 with 3. So we have [1, 2, 3] as our one of the final permutation
Now for [1, 3, 2], we can fix 2 ath the last position by swapping 2 with 2. So we have [1, 3, 2] as our one of the final permutation.

The same swapping technique can be applied to [2, 1, 3] and [3, 2, 1] where we fixed 2 and 3 as the first position and continue further to produce the final permutations.


We can try swapping here because each and every number can be at any position in the permutation of an array.

TC : n! * n
SC : n + n!(output) + auxiliary

*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0);
        return result;
    }
    
    private void backtrack(int [] nums, List<List<Integer>> result, int index) {
        if (index >= nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            backtrack(nums, result, index + 1);
            swap(nums, index, i); // undo the previous swap
        }
    }
    
    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
