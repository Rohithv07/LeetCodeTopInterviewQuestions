class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2)
            return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        // the idea here is, we need say x1 < x2 < x3. SO x3 hav to be the largest of all 3, then x2, then x1.
        // so initially we initialised the varibales as x1 = max, x2 = min. Now we llok for the number which
        // will be greater than both x1 and x2.
        for (int number : nums) {
            if (number <= first)
                first = number;
            else if (number <= second)
                second = number;
            else 
                return true;
            // so what happens here.
            // as I said earlier we need number x1, x2, x3 such that x3 is the largest, then x2, then x1.
            // so we check first whether the current number <= x1, if yes then this must be the first number of our required sequence.
            // if the current number > x1, but <= x2, then we have our second number.
            // if altlast we find such a number like current number >x1 and current number > x2, thats it.
            // we have oru required sequence x1 < x2 < x3. So we return true.
        }
        return false;
    }
}