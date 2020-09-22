Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

Solution:


"""
My thought process:
So for this question, the first approach I made is using an extra space, dictionary. This stores every element of the array and stores the count into the dictionary as values.
Now looks through the dictionary and see the keys whose values > len(nums) / 3 and append them into the result list.

But the problem description says about constance space.
So I definitely looks into the solution and sees a method named Boyer-Moore Voting Algorithm which is completely a new thing to me.
So in this we will be knowing the following idea:
There can be at most one majority element which is more than ⌊n/2⌋ times.
There can be at most two majority elements which are more than ⌊n/3⌋ times.
There can be at most three majority elements which are more than ⌊n/4⌋ times.

So we will be having maximum 2 majority element from n/3.
So we uses 2 varibales as candidates to store the majority and its corresponding count.
We traverse through the array and check whether we start by count1 = 0, or count 2 = 0 and update the respective candidates and incrementing the count. After coming out of the loop, we will be having 2 candidates as majority and we still need to check if its greater than n/3.
So we make a check and we append the result and return the answer.
Thats the whole problem.
There can be at most one majority element which is more than ⌊n/2⌋ times.
There can be at most two majority elements which are more than ⌊n/3⌋ times.
There can be at most three majority elements which are more than ⌊n/4⌋ times.
"""



"""
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        result = []
        dictionary = {}
        threshold = len(nums) / 3
        for element in nums:
            if element in dictionary:
                dictionary[element] += 1
            else:
                dictionary[element] = 1
                
        for key, value in dictionary.items():
            if dictionary[key] > threshold:
                result.append(key)
        return result
"""
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        if len(nums) == 0:
            return []
        result = []
        count1 = 0
        count2 = 0
        candidate1 = None
        candidate2 = None
        threshold = len(nums) / 3
        for element in nums:
            if candidate1 == element:
                count1 += 1
            elif candidate2 == element:
                count2 += 1
            elif count1 == 0:
                candidate1 = element
                count1 += 1
            elif count2 == 0:
                candidate2 = element
                count2 += 1
            else:
                count1 -= 1
                count2 -= 1
        for element in [candidate1, candidate2]:
            if nums.count(element) > threshold:
                result.append(element)
        return result
