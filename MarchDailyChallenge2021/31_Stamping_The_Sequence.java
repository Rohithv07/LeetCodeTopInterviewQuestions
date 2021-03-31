You want to form a target string of lowercase letters.

At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.

On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.

For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)

If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.

For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".

Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.  Any answers specifying more than this number of moves will not be accepted.

 

Example 1:

Input: stamp = "abc", target = "ababc"
Output: [0,2]
([1,0,2] would also be accepted as an answer, as well as some other answers.)
Example 2:

Input: stamp = "abca", target = "aabcaca"
Output: [3,0,1]
 

Note:

1 <= stamp.length <= target.length <= 1000
stamp and target only contain lowercase letters.



// go from the target to *******.. Do the reverse process


class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char [] s = stamp.toCharArray();
        char [] t = target.toCharArray();
        List<Integer> track = new ArrayList<>();
        int stampLength = stamp.length();
        int targetLength = target.length();
        boolean [] visited = new boolean [targetLength];
        int starCount = 0;
        while (starCount < targetLength) {  
            boolean replace = false;
            for (int i=0; i<=targetLength - stampLength; i++) {
                if (!visited[i] && isPossibleToReplace(t, i, s)) {
                    starCount = continueReplace(t, i, stampLength, starCount);
                    visited[i] = true;
                    replace = true;
                    track.add(i);
                    if (starCount == targetLength)
                        break;
                }
            }
            if (!replace) {
                return new int [0];
            }
        }
        Collections.reverse(track);
        int [] result = new int [track.size()];
        for (int i=0; i<track.size(); i++) {
            result[i] = track.get(i);
        }
        return result;
    }
    
    public boolean isPossibleToReplace(char [] t, int key, char [] s) {
        for (int i=0; i<s.length; i++) {
            if (t[i + key] != '*' && t[i + key] != s[i])
                return false;
        }
        return true;
    }
    
    public int continueReplace(char [] t, int start, int end, int starCount) {
        for (int i=0; i<end; i++) {
            if (t[i + start] != '*') {
                t[i + start] = '*';
                starCount += 1;
            }   
        }
        return starCount;
    }
}
