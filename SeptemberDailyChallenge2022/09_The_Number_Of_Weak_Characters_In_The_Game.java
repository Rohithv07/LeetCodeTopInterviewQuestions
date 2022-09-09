You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.

 

Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
Example 3:

Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.
 

Constraints:

2 <= properties.length <= 105
properties[i].length == 2
1 <= attacki, defensei <= 105



class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        if (properties == null || properties.length <= 1) {
            return 0;
        }
        // we need to sort based on attacking power in descending order
        // when attacking power is equal, sort based on increasing order of defensive power
        // property1[0] = attacking
        // property1[1] = defensive
        // property2[0] = attacking
        // property2[1] = defenisve
        int character  = properties.length;
        Arrays.sort(properties, (property1, property2) -> 
                    property1[0] != property2[0] ? Integer.compare(property2[0], property1[0])
                   : Integer.compare(property1[1], property2[1]));
        // [[1,5],[10,4],[4,3]]
        // [[10, 4], [4, 3], [1, 5]]
        
        // [[1,5],[10,4],[10,3]]
        // [[10, 3], [10, 4], [1, 5]]
        int minimumDefensivePower = Integer.MIN_VALUE;
        int weakCount = 0;
        for (int [] property: properties) {
            if (minimumDefensivePower > property[1]) {
                weakCount++;
            }
            minimumDefensivePower = Math.max(property[1], minimumDefensivePower);
        }
        return weakCount;
    }
}