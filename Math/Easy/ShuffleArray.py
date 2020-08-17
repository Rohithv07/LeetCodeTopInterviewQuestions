Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();



class Solution:

    def __init__(self, nums: List[int]):
        self.array = nums;
        self.original = list(nums)

    def reset(self) -> List[int]:
        """
        Resets the array to its original configuration and return it.
        """
        self.array = self.original
        self.original = list(self.original)
        return self.array
        

    def shuffle(self) -> List[int]:
        """
        Returns a random shuffling of the array.
        """
        length = len(self.array)
        for i in range(length):
            j = random.randrange(i, len(self.array))
            self.array[i], self.array[j] = self.array[j], self.array[i]
        return self.array


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
