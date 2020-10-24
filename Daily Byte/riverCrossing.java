A frog is attempting to cross a river to reach the other side. Within the river, there are stones located at different positions given by a stones array (this array is in sorted order). Starting on the first stone (i.e. stones[0]), the frog makes a jump of size one potentially landing on the next stone. If the frog’s last jump was of size x, the frog’s next jump may be of size x - 1, x, or x + 1. Given these following conditions return whether or not the frog can reach the other side.
Note: The frog may only jump in the forward direction.

Ex: Given the following stones…

stones = [0, 1, 10], return false.
This question is asked by Amazon. The frog can jump from stone 0 to stone 1, but then the gap is too far to jump to the last stone (i.e. the stone at position 10)
Ex: Given the following stones…

stones = [0, 1, 2, 4], return true.
The frog can jump from stone 0, to stone 1, to stone 2, to stone 4.



class Solution {
    public boolean canCross(int[] stones) {
        int length = stones.length;
        for (int i=3; i<length; i++) {
            if (stones[i] > stones[i-1] * 2)
                return false;
        }
        // let us create a hashset to store all the values of the stone array
        Set<Integer> set = new HashSet<>();
        for (int stone: stones)
            set.add(stone);
        // here we make use of two stack to keep track of the possible possible
        // the other stack to keep track of the jump that may happen if the frog jumps on a stone
        Stack<Integer> position = new Stack<>();
        Stack<Integer> jump = new Stack<>();
        position.add(0);
        jump.add(0);
        int lastStone = stones[length-1];
        // now we continue until we start the last stone
        while (!position.isEmpty()) {   //O(stonesSize)
            int currentPosition = position.pop();
            int currentJump = jump.pop();
            // we can jump k-1 or k or k+1
            for (int i=currentJump-1; i<=currentJump+1; i++) { // O(possibleJump) = constant as only 3
                if (i <= 0)
                    continue;
                // we need to know the next position after jumping i unit
                int nextPosition = currentPosition + i;
                // check if we reach the last stone
                if (nextPosition == lastStone)
                    return true;
                // now check whether we jumped on a stone or not, then we have to add the jump and position on to the respective stack
                if (set.contains(nextPosition)) {
                    position.add(nextPosition);
                    jump.add(i);
                }
            }
        }
        return false; 
    }
}

// O(sizeOfArray)
